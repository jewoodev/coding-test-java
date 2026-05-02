# 오픈채팅방 문제 풀이 회고

## 1. 문제 상황

- 공개된 예제 케이스는 통과
- 제출하면 **모든 케이스가 런타임 에러**
- 원인: `ArrayIndexOutOfBoundsException`

## 2. 첫 번째 버그: 배열 크기와 인덱스를 분리해서 생각하지 못함

### 잘못된 코드 패턴

```java
var answer = new String[record.length - cnt];  // 크기는 줄였음
for (int i = 0; i < record.length; i++) {
    if (check[i]) continue;
    answer[i] = name + disassembled[i][0];     // 그런데 인덱스는 i를 그대로 사용
}
```

### 핵심 깨달음

**(A) 배열의 "크기"** 와 **(B) 배열의 "인덱스"** 는 별개의 문제다.

- `- cnt`로 (A)는 해결했지만,
- `i`는 *원본 record* 의 위치를 가리키는 변수라서 (B)는 해결되지 않았음.
- Change가 마지막이 아닌 위치에 등장하면 `i ≥ answer.length` 가 되어 OOB 발생.

### 왜 공개 예제는 통과했을까?

공개 예제는 우연히 Change가 **마지막 인덱스**에 있어서, 건너뛴 인덱스가 정확히 `answer.length`가 되어 문제가 안 생겼음. 채점 서버 케이스는 Change의 위치가 다양해서 모두 실패.

### 교훈

> "원본 배열을 훑는 인덱스"와 "결과 배열에 채우는 인덱스"는 **다른 변수**여야 한다. 일부를 건너뛰는 로직이 들어가는 순간 둘은 동기화되지 않는다.

```java
int aIdx = 0;
for (int i = 0; i < record.length; i++) {
    if (check[i]) continue;
    answer[aIdx++] = name + disassembled[i][0];  // i가 아니라 aIdx로 채우기
}
```

## 3. 두 번째 버그: 절반만 한 리팩토링

자료구조를 `String[][]` → `ArrayList<String[]>` 로 바꾸면서 **Change를 애초에 리스트에 넣지 않도록** 변경.

```java
if (arr[0].equals("Leave")) {
    list.add(new String[]{arr[1], "님이 나갔습니다."});
} else if (arr[0].equals("Enter")) {
    list.add(new String[]{arr[1], "님이 들어왔습니다."});
}
// Change는 list.add를 하지 않음 — 자연스럽게 걸러짐
```

### 그런데 `check`와 `cnt`를 그대로 둔 게 문제

- `check`는 **원본 record 인덱스** 기준으로 Change 위치를 표시한 배열
- 두 번째 루프는 이제 **list 인덱스** 로 도는데, 같은 `i`로 `check[i]`를 조회 → 의미가 어긋남
- `cnt`도 마찬가지로 무의미해짐 (`list.size()`가 이미 답을 가지고 있음)

### 교훈

> 자료구조를 바꾸면, 그 자료구조에 의존하던 **부수적인 변수들도 같이 재검토**해야 한다. 절반만 리팩토링하면 새 버그가 생긴다.

리팩토링 체크리스트:
1. 자료구조를 바꿨다 → 이 자료구조를 보조하던 변수들이 여전히 의미 있는지 확인
2. 그 변수들이 더 이상 필요 없다면 **반드시 제거** (남겨두면 헷갈리는 데드 코드 + 잠재적 버그)

## 4. 자료구조 시간복잡도 오개념 정정

### 흔한 오해

> "ArrayList의 `get(i)`은 O(n)이라서 배열로 바꾸면 더 빠르다"

### 사실

| 자료구조 | `get(i)` | 이유 |
|---|---|---|
| **`ArrayList`** | **O(1)** | 내부가 `Object[]`이라 그냥 배열 인덱싱 |
| `LinkedList` | O(n) | 노드를 `i`번 따라가야 함 |

`ArrayList.get(i)`는 배열의 `arr[i]`와 본질적으로 같다. 메서드 호출 / 범위 체크 등 약간의 상수 오버헤드만 있을 뿐, **점근적으로 동일**.

### 배열로 바꾸는 게 의미 있는가?

- **시간복잡도**: 동일 (둘 다 O(1) 접근)
- **메모리**: `toArray()`는 복사를 발생시킴 → 오히려 손해
- **상수 인자**: 배열 인덱싱이 살짝 빠르지만, 입력 10만 정도에선 체감 불가
- **가독성**: 케이스 바이 케이스

### 교훈

> 성능 고민 전에 **자료구조별 연산의 시간복잡도 표**를 정확히 떠올려라. 헷갈리는 건 보통 `ArrayList` ↔ `LinkedList` 의 차이.

## 5. 최종 코드

```java
class Solution {
    public String[] solution(String[] record) {
        var map = new HashMap<String, String>();
        var list = new ArrayList<String[]>();

        for (int i = 0; i < record.length; i++) {
            var arr = record[i].split(" ");

            if (arr[0].equals("Leave")) {
                list.add(new String[]{arr[1], "님이 나갔습니다."});
                continue;
            }
            else if (arr[0].equals("Enter")) {
                list.add(new String[]{arr[1], "님이 들어왔습니다."});
            }

            map.put(arr[1], arr[2]);
        }

        var answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            var arr = list.get(i);
            var name = map.get(arr[0]);
            answer[i] = name + arr[1];
        }

        return answer;
    }
}
```

## 6. 디버깅 일반 원칙

이 세션에서 적용한 디버깅 흐름:

1. **단서를 정확히 분리**: "오답"이 아니라 "런타임 에러" → 자료 의존적 예외 의심 (NPE, OOB, ClassCast 등)
2. **공개 예제와 다른 패턴 만들어보기**: "Change가 중간에 있는" 작은 입력 직접 손으로 트레이싱
3. **변수의 의미를 한 번 더 점검**: `i`가 가리키는 게 정말 내가 의도한 그것인지
4. **리팩토링 후엔 부수 변수도 재검토**: 자료구조 변경의 파급 효과를 끝까지 추적
