## [실패율](https://school.programmers.co.kr/learn/courses/30/lessons/42889)

## 문제 접근 전략

1. **문제 분석**
   - 실패율 = (스테이지에 도달했으나 클리어하지 못한 플레이어 수) / (스테이지에 도달한 플레이어 수)
   - 실패율이 높은 스테이지부터 내림차순으로 정렬
   - 실패율이 같다면 스테이지 번호가 작은 것부터 정렬
2. **핵심 로직 접근 방법**
    ```
    // 1단계: 각 스테이지별 도전자 수 계산
    Map<Integer, Integer> map = new HashMap<>();
    for (int s : stages) {
        map.put(s, map.getOrDefault(s, 0) + 1);
    }
    ```
    - HashMap을 사용하여 각 스테이지별 도전자 수를 효율적으로 계산
    - `getOrDefault`를 사용하여 코드를 간결하게 작성
```java
// 2단계: 실패율 계산
int total = stages.length;
for (int i = 1; i <= N; i++) {
    double failRate = total == 0 ? 0 : (double)map.getOrDefault(i, 0) / total;
    total -= map.getOrDefault(i, 0);
}
```
- 전체 플레이어 수에서 시작
- 각 스테이지마다 실패율 계산
- 계산 후 해당 스테이지의 플레이어 수를 빼줌
3. **정렬 전략**
   ```java
   list.sort((a, b) -> a.getKey().equals(b.getKey())
              ? a.getValue() - b.getValue()
              : b.getKey().compareTo(a.getKey()));
   ```
   - 실패율을 기준으로 내림차순 정렬
   - 실패율이 같을 경우 스테이지 번호로 오름차순 정렬
4. **최적화 포인트**
   - HashMap 사용으로 O(1) 시간에 각 스테이지의 도전자 수 조회
   - 한 번의 순회로 모든 스테이지의 실패율 계산
   - 정렬은 한 번만 수행
5. **예외 처리**
    ```java
    total == 0 ? 0 : (double)map.getOrDefault(i, 0) / total
    ```
    - 분모가 0이 되는 경우 처리
    - 해당 스테이지에 도전자가 없는 경우 처리
이 접근 방법의 장점:
1. **효율성**
   - 시간 복잡도: O(N log N) - 정렬이 가장 큰 비용
   - 공간 복잡도: O(N) - 맵과 리스트 사용
2. **가독성**
   - 각 단계가 명확하게 구분됨
   - 코드의 의도가 잘 드러남
3. **유지보수성**
   - 각 부분을 독립적으로 수정 가능
   - 예외 처리가 명확함
4. **확장성**
   - 다른 정렬 기준으로 쉽게 변경 가능
   - 추가 요구사항이 생겨도 수정이 용이

이러한 접근 방법은 문제의 요구사항을 정확히 만족하면서도, 효율적이고 깔끔한 코드를 작성할 수 있게 해준다.

---

## 풀이법

또 다른 풀이법으로 `Pair` 클래스를 이용하는 방법이 있다.

1. **데이터 구조 준비**
   - `Map<Integer, Integer>`를 사용하여 각 스테이지별 도전자 수를 저장합니다.
   - `List<Pair<Double, Integer>>`를 사용하여 실패율과 스테이지 번호를 함께 저장합니다.
2. **스테이지별 도전자 수 계산**
   ```java
   for (int s : stages) {
      map.put(s, map.getOrDefault(s, 0) + 1);
   }
   ```
   - 각 스테이지에 도전한 플레이어의 수를 맵에 저장
   - `getOrDefault`를 사용하여 해당 스테이지가 없으면 0을 반환하고, 있으면 기존 값에 1을 더함
3. **실패율 계산**
   ```java
   int total = stages.length;
   for (int i = 1; i <= N; i++) {
      list.add(new Pair<>(total == 0 ? 0 : (double)map.getOrDefault(i, 0) / total, i));
      total -= map.getOrDefault(i, 0);
   }
   ```
   - 전체 플레이어 수(`total`)에서 시작하여 각 스테이지별로 실패율을 계산합니다.
   - 실패율 = (해당 스테이지에 도전한 플레이어 수) / (해당 스테이지에 도달한 플레이어 수)
   - 각 스테이지 계산 후에는 해당 스테이지의 플레이어 수를 `total`에서 빼줍니다.
4. **정렬**
   ```java
   list.sort((a, b) -> a.getKey().equals(b.getKey())
              ? a.getValue() - b.getValue()
              : b.getKey().compareTo(a.getKey()));
   ```
   - 실패율을 기준으로 내림차순 정렬
   - 실패율이 같을 경우 스테이지 번호로 오름차순 정렬
5. **결과 추출**
   ```java
   for (int i = 0; i < N; i++) {
      answer[i] = list.get(i).getValue();
   }
   ```
   - 정렬된 리스트에서 각 스테이지 번호를 추출하여 배열에 저장

### `Pair` 클래스 사용 이유
`Pair` 클래스는 두 개의 값을 하나의 객체로 묶어서 관리할 때 사용되는 유용한 클래스다. 이 문제에서는 다음과 같은 용도로 `Pair` 클래스를 사용했다.

1. 실패율과 스테이지 번호의 연관 관계 유지
   - 실패율(Double)과 스테이지 번호(Integer)를 하나의 객체로 묶어서 관리한다.
   - 이렇게 함으로써 정렬 시 두 값의 관계가 깨지지 않는다.
2. 정렬의 편의성
   ```java
   list.sort((a, b) -> a.getKey().equals(b.getKey())
          ? a.getValue() - b.getValue()
          : b.getKey().compareTo(a.getKey()));
   ```
   - Pair 클래스의 `getKey()`는 실패율을, `getValue()`는 스테이지 번호를 반환한다.
   - 정렬 시 실패율을 기준으로 내림차순 정렬하고, 실패율이 같을 경우 스테이지 번호로 오름차순 정렬할 수 있다.

### 정리리

이 풀이의 시간 복잡도는 O(N log N)다. 여기서 N은 스테이지의 개수이다. 정렬 과정이 가장 큰 시간을 차지하며, 나머지 연산들은 O(N) 시간 내에 수행된다.

공간 복잡도는 O(N)이다. 맵과 리스트에 각각 N개의 요소를 저장하기 때문이다.
이 풀이는 실패율을 효율적으로 계산하고 정렬하는 깔끔한 방법을 보여주고 있다. 특히 Pair 클래스를 사용하여 실패율과 스테이지 번호를 함께 관리하는 것이 인상적이이다.
