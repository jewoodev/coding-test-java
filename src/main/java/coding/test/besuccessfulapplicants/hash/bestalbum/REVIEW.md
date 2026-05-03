# 베스트앨범 코드 리뷰 학습 정리

## 1. 정렬 컴퍼레이터에 타이브레이커가 빠짐

### 문제 코드
```java
@Override
public int compareTo(Song o) {
    return o.plays - this.plays;
}
```

### 두 가지 결함
**(1) 타이브레이커 누락**
문제 명세에 "재생 횟수가 같으면 고유 번호가 낮은 노래 먼저"라는 규칙이 있는데, 컴퍼레이터는 `plays`만 비교함. 지금 정답을 받은 건 두 가지 우연이 맞물린 결과:
- `Song`을 인덱스 0부터 차례대로 `songList`에 넣음
- `List.sort()`가 stable sort라서 동률일 때 원래 순서가 보존됨

**(2) 뺄셈 비교의 오버플로우 위험**
`o.plays - this.plays`는 두 int의 차가 `Integer.MAX_VALUE`를 넘으면 wrap-around돼서 부호가 뒤집힘. 베스트앨범 제약에서는 안전하지만 안티패턴.

### 수정안
```java
@Override
public int compareTo(Song o) {
    if (o.plays != this.plays) return Integer.compare(o.plays, this.plays);
    return Integer.compare(this.num, o.num);
}
```

### 배운 것
- **정렬 알고리즘의 stable 특성에 의존하지 말 것.** 컴퍼레이터는 정렬 규칙 전체를 자기가 책임지도록 명시적으로 작성한다. stable sort는 "동률을 유지한다"는 보조 보장이지, 정답을 결정하는 1차 규칙이 되어선 안 됨.
- **`Integer.compare`는 뺄셈을 안 하고 `<`, `==` 비교 연산자만 써서** -1/0/1을 반환. 비교 연산자 자체는 산술 결과를 만들지 않으니 오버플로우가 발생할 수 없음. `Long.compare`도 같은 원리.
- "두 수를 빼서 부호로 비교"는 흔하지만 위험한 패턴이라, 입력 범위가 늘었을 때 디버깅이 매우 까다로워짐.

---

## 2. `private class Song` (non-static inner class)

### 문제 코드
```java
private class Song implements Comparable<Song> { ... }
```

### 무엇이 문제인가
non-static inner class는 컴파일러가 자동으로 외부 인스턴스 참조(`Solution.this`)를 숨겨서 넣음:
```java
// 컴파일러가 실제로 만드는 형태
private class Song {
    final Solution this$0;   // 숨겨진 외부 참조
    int num, plays;
    Song(Solution outer, int num, int plays) { ... }
}
```

이게 야기하는 결과:
- **메모리**: 모든 `Song`이 참조 한 칸을 추가로 들고 있음
- **GC 누수**: `Song`이 살아있는 한 외부 `Solution`도 GC 대상 못 됨
- **직렬화 문제**: 외부 클래스까지 직렬화 대상이 됨
- **의도 불명확**: 외부 상태를 쓰는지 시그니처만으로 알 수 없음

### 수정안
```java
private static class Song implements Comparable<Song> { ... }
```

### 배운 것
- **외부 클래스 멤버를 안 쓰는 nested class는 무조건 `static`** (Effective Java Item 24).
- non-static을 정당하게 쓰는 경우는 외부 인스턴스 필드/메서드에 실제로 접근해야 할 때뿐. 단순 데이터 holder는 99% `static`이 맞음.
- Android의 `Activity` 누수, 수백만 객체 다루는 서비스의 메모리 폭발 등 실무에서 진짜 문제가 되는 사례가 많음. 코딩테스트에서는 티가 안 나도 습관으로 들여놔야 함.

---

## 3. `getOrDefault + put` 패턴의 비효율

### 문제 코드
```java
genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);

var songList = songMap.getOrDefault(genres[i], new ArrayList<Song>());
songList.add(new Song(i, plays[i]));
songMap.put(genres[i], songList);
```

### 무엇이 문제인가
- `getOrDefault(..., new ArrayList<>())`는 키가 이미 있어도 빈 ArrayList를 **매번 새로 할당**해서 즉시 버려짐 (즉시 garbage).
- 해시 lookup이 `getOrDefault` + `put`으로 두 번 일어남.
- 분기 의도가 코드에 흩어져 있음.

### 수정안
```java
genreMap.merge(genres[i], plays[i], Integer::sum);
songMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
```

### 배운 것

**`merge(key, value, BiFunction)`**
- 키가 없으면 `value`를 넣고, 있으면 `BiFunction(기존값, 새값)` 결과를 넣음.
- 카운팅·누산 패턴에 최적: `Integer::sum`, `Math::max`, `String::concat` 같은 메서드 레퍼런스가 자연스럽게 맞물림.
- 람다가 `null`을 반환하면 그 키가 제거되는 동작도 종종 유용.

**`computeIfAbsent(key, Function)`**
- 키가 없을 때만 `Function(key)`를 호출해서 값을 만들어 넣고, **그 값을 반환**.
- 핵심 차별점은 **반환값**: 새로 만든 (또는 기존) 값을 받아서 chain할 수 있음.
- 람다는 "값"이 아니라 "레시피". `getOrDefault(k, new ArrayList<>())`처럼 미리 만들지 않고, 정말 필요할 때만 평가됨 (lazy evaluation).

**`computeIfAbsent(...).add(...)` 한 줄의 원리**
1. `computeIfAbsent`가 항상 "그 키의 현재 값"을 반환 → `List<Song>`을 손에 받음
2. Java는 객체를 참조로 다루기 때문에, Map이 가진 참조와 우리가 받은 참조가 **같은 객체**를 가리킴
3. 그 객체에 `.add()` 하면 Map을 통해 봐도 같은 변화가 반영됨
4. Map에 뭘 추가하는 게 아니라, Map이 가리키는 객체를 직접 수정하는 것

**언제 쓸지 선택 기준**
| 상황 | 메서드 |
|---|---|
| 값이 컬렉션이고, 없을 때 빈 컨테이너로 초기화 후 누적 | `computeIfAbsent` |
| 값이 스칼라이고 기존 값과 결합 | `merge` |
| 값을 받아서 chain 필요 | `computeIfAbsent` |
| 누적만 하면 됨 (반환값 안 씀) | `merge` |

---

## 4. 정렬된 키만 필요한데 `LinkedHashMap`을 만듦

### 문제 코드
```java
var generLank = genreMap.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new)
        );

for (String s : generLank.keySet()) { ... }
```

### 무엇이 문제인가
`generLank`의 value는 이후에 한 번도 안 쓰임. 키 순서만 필요한데 entry 전체를 LinkedHashMap에 다시 빌드함 — 불필요한 자료구조 생성.

### 수정안
```java
var genreRank = genreMap.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .map(Map.Entry::getKey)
        .toList();

for (String s : genreRank) { ... }
```

### 배운 것
- **자료구조는 실제로 사용하는 형태에 맞춰 선택한다.** 정렬된 순서로 키만 순회할 거면 `List<String>`이 충분함. Map을 만들면 키-값 양쪽을 다 들고 다니는 불필요한 비용이 생김.
- 스트림 collector를 고를 때 "내가 다음에 이 결과로 뭘 할 건가"를 먼저 생각하면 더 가벼운 선택지가 보임.

---

## 5. 변수명 오타: `generLank` → `genreRank`

### 무엇이 문제인가
`genre`의 e/r 순서, `Rank`의 L/R이 둘 다 잘못됨.

### 배운 것
- 변수명은 코드 가독성에 직결됨. "이게 뭐의 약자인지" 파악하려고 멈칫하는 순간 리뷰어/미래의 자신이 비용을 치름.
- IDE의 spell-check 플러그인을 켜두면 영어 오타를 자동으로 잡아줌.

---

## 6. 상위 N개 추출 루프의 가독성

### 문제 코드
```java
for (int i = 0; i < 2; i++) {
    if (songList.size() - 1 < i) break;
    answer.add(songList.get(i).num);
}
```

### 무엇이 문제인가
`songList.size() - 1 < i`는 결국 `i >= songList.size()`인데 한 번 머리로 변환해야 의미가 잡힘. `break`로 빠져나가는 흐름도 한 단계 더 쳐야 함.

### 수정안
```java
int limit = Math.min(2, songList.size());
for (int i = 0; i < limit; i++) {
    answer.add(songList.get(i).num);
}
```

### 배운 것
- **루프 조건은 의도가 즉시 읽혀야 한다.** "최대 2개 또는 가능한 만큼" → `Math.min(2, size)` 한 번에 표현 가능.
- 조기 종료(`break`)는 정말 필요할 때만 쓰고, 카운트 기반 루프는 상한선을 미리 계산해두는 게 더 명확함.

---

## 종합 인사이트

1. **"동작한다"와 "잘 짰다"는 다르다.** 정답을 받은 코드도 stable sort에 우연히 기댄 정렬, 묵시적 외부 참조, 매번 garbage를 만드는 패턴 등이 숨어 있을 수 있음. 채점 결과는 출발점이지 도착점이 아님.

2. **Java 8+의 함수형 API (`merge`, `computeIfAbsent`)는 "check-then-act" 안티패턴을 한 번의 atomic 호출로 압축한다.** 짧아진 코드 길이는 부산물이고, 진짜 가치는 (a) 해시 lookup 1회로 감소, (b) `ConcurrentHashMap`에서 진짜 atomic, (c) 분기 없는 의도 표현.

3. **Java의 객체 참조 의미론을 이해하면 `computeIfAbsent(...).add(...)` 같은 패턴이 "마법"에서 "당연한 것"으로 바뀐다.** Map은 객체 참조를 저장할 뿐이고, 외부에서 그 객체를 수정하면 Map을 거치지 않고도 변화가 반영됨.

4. **컴퍼레이터는 정렬 규칙 전체를 책임져야 한다.** 외부 조건(stable sort, 입력 순서)에 의존하면 입력 분포나 라이브러리 구현이 바뀔 때 조용히 깨짐. `Integer.compare`로 안전한 비교 습관까지 같이 들이면 좋음.

5. **`static` 키워드 하나의 의미를 가볍게 보지 말 것.** non-static inner class는 외부 참조를 묵시적으로 들고 다님. 메모리·GC·직렬화·의도 명확성 모두에 영향을 주는 결정.
