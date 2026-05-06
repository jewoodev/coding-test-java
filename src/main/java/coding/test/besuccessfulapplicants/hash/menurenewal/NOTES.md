# 메뉴 리뉴얼 — 풀이 학습 노트

## 문제의 본질

손님들의 주문 목록 `orders`와 코스 길이 후보 `course`가 주어진다.
각 코스 길이 `c`에 대해 **가장 많이 함께 주문된 길이 c짜리 메뉴 조합**을 찾으면 된다.
조건: 최소 2명 이상이 주문한 조합만 답이 될 수 있고, 동률은 모두 답에 포함한다.

예시:
- `orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]`
- `course = [2, 3, 4]`
- 결과: `["AC", "ACDE", "BCFG", "CDE"]` (사전순 정렬)

---

## 막혔던 지점들과 깨달음

### 처음 시도한 잘못된 접근

```java
for (int i = 0; i < orders.length; i++) {
    for (String key : map.keySet()) {
        if (key.contains(orders[i])) {  // 주문 문자열 통째로 비교
            map.merge(orders[i], 1, Integer::sum);
        }
    }
    map.merge(orders[i], 1, Integer::sum);
}
```

**문제점**:
1. 주문 문자열을 통째로 key로 썼다. → "BCFG"라는 답은 입력에 부분적으로만 있고, 통째로는 어디에도 없음.
2. `String.contains`는 **부분문자열** 검사이지 **부분집합** 검사가 아니다.
3. course 숫자를 등장 횟수와 비교했다. → course는 메뉴의 **길이**이지 **빈도**가 아님.

### 핵심 전환점: "조합을 만들어야 한다"

각 주문에서 길이 c짜리 **부분집합(조합)**을 모두 만들어, 손님 간에 동일한 조합이 몇 번 등장하는지 카운트한다.

---

## 알고리즘 흐름 (4단계)

### 1단계. 자료구조 설계

길이별로 분류된 카운터를 둔다:

```
courseMap = {
  2 -> { 길이 2짜리 조합 -> 등장 횟수 },
  3 -> { 길이 3짜리 조합 -> 등장 횟수 },
  4 -> { 길이 4짜리 조합 -> 등장 횟수 }
}
```

### 2단계. 정규화 후 조합 생성

각 주문 문자열에서 모든 부분집합을 만들기 전에 **반드시 정렬**한다.
- `"BAC"`와 `"CAB"`는 정렬하면 둘 다 `[A,B,C]` → 같은 key로 묶임.
- 정렬 안 하면 `"BC"`, `"AB"` 등이 따로 카운트되어 손님 간 비교가 깨짐.

```java
char[] orderArray = order.toCharArray();
Arrays.sort(orderArray);
combinations(0, orderArray, "");
```

### 3단계. 백트래킹으로 모든 부분집합 만들기

```java
private static void combinations(int idx, char[] order, String result) {
    if (courseMap.containsKey(result.length())) {
        var map = courseMap.get(result.length());
        map.put(result, map.getOrDefault(result, 0) + 1);
    }
    for (int i = idx; i < order.length; i++) {
        combinations(i + 1, order, result + order[i]);
    }
}
```

핵심 패턴:
- `i + 1`을 다음 재귀에 넘김 → 같은 원소를 두 번 쓰지 않음, 조합 중복 없음.
- `result.length()`로 현재 깊이를 알 수 있고, courseMap에 해당 키가 있으면 카운트.

### 4단계. 각 길이별로 최댓값 뽑고 동률 모으기

```java
var answer = new ArrayList<String>();
for (var count : courseMap.values()) {
    if (count.isEmpty()) continue;
    int max = Collections.max(count.values());
    if (max < 2) continue;
    for (var entry : count.entrySet()) {
        if (entry.getValue() == max) {
            answer.add(entry.getKey());
        }
    }
}
Collections.sort(answer);
return answer.toArray(new String[0]);
```

핵심:
- `Collections.max(map.values())` → 한 번 순회로 최댓값 O(n). 정렬(O(n log n))은 과함.
- `if (max < 2) continue;` → 1명만 시킨 조합은 답에서 제외.
- 마지막에 `Collections.sort(answer)` → 사전순 정렬 (course 순서 아님).

---

## 빈 카운터 처리

`Collections.max(...)`는 컬렉션이 비어있으면 `NoSuchElementException`을 던진다.
빈 카운터가 생기는 경우: course에 5가 있는데 어떤 주문도 길이 5 이상이 아닐 때.

대처법:
- for 루프 버전: `if (count.isEmpty()) continue;`
- Stream 버전: `stream().max(...)`는 `Optional`을 반환하므로 `.ifPresent(...)`로 자연스럽게 처리됨.

---

## Stream 버전과의 매핑

| for 루프 | Stream |
|---|---|
| `Collections.max(map.values())` | `count.values().stream().max(Comparator.comparingInt(o -> o))` |
| `if (max < 2) continue;` | filter의 `cnt > 1` |
| `if (entry.getValue() == max)` | filter의 `cnt.equals(entry.getValue())` |
| `answer.add(entry.getKey())` | `forEach(entry -> answer.add(entry.getKey()))` |

→ **로직은 완전히 동일.** 표현 방식만 다름.

---

## 배운 것들 (일반화)

1. **"부분집합/조합 카운트" 패턴**: 각 입력에서 가능한 모든 조합을 만들어 빈도를 세는 문제는 흔하다.
2. **정규화의 중요성**: 같은 의미를 갖는 입력이 다른 표현으로 들어올 때, key로 쓰기 전에 표준 형태로 변환해야 한다 (이 문제에선 정렬).
3. **백트래킹으로 조합 만들기**: `idx + 1`을 다음 재귀에 넘기는 것이 중복 없는 조합의 표준 패턴.
4. **다층 Map**: `Map<K1, Map<K2, V>>` 구조로 카테고리별 카운터를 만들 수 있다.
5. **`Collections.max`는 빈 컬렉션에서 예외**: 사용 전 비어있는지 확인하거나 Optional 패턴 사용.
6. **String 결과 정렬은 마지막에 한 번**: 답을 모은 후 `Collections.sort`로 한 번에.

---

## 다음에 비슷한 문제를 만나면

- "각 입력에서 가능한 조합/부분집합을 모두 만들어 빈도 세기"가 보이는가? → 이 패턴.
- key 충돌을 막기 위해 정규화가 필요한가? (정렬, 소문자화 등)
- 카운터를 카테고리(길이/타입 등)별로 분리하면 답을 뽑기 쉬운가?
- 동률 처리가 명시되어 있는가? (모두 포함 / 하나만 / 임의 등)
