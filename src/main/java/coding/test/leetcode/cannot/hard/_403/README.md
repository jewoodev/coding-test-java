# 403. Frog Jump

문제 링크: [링크](https://leetcode.com/problems/frog-jump/description/)

개구리가 점프를 뛸 때 바로 다음의 돌로만 뛰는 것이 아닌데, 이 논리를 놓쳤다.(단순 인덱싱 접근법)

---

이 문제를 해결하려면 DP나 백트래킹을 사용해야 한다.

1. 메모이제이션을 활용해 각 돌과 마지막 점프 거리의 상태를 기록한다.
2. DFS를 사용해 각 돌에 대해 `k-1`, `k`, `k+1` 으로 가능한 점프를 탐색한다.
3. 마지막 돌에 도달하면 `true`를 반환하고, 모든 경로를 탐색해도 도달하지 못하면 `false`를 반환한다.

---

시간, 공간 복잡도를 낮추는 풀이법은 다음과 같다.

## 1. 돌의 위치를 Map에 저장

```
Map<Integer, Set<Integer>> steps = new HashMap<>();
for (int stone : stones) {
    steps.put(stone, new HashSet<>());
}
steps.get(0).add(0);
```

- `Map<Integer, Set<Integer>>`: 각 돌의 위치를 Key로 하고, 해당 돌에서 가능한 점프 거리를 Set에 저장한다.
- `steps.get(0).add(0)`: 첫 번째 돌(위치 0)에서 0의 점프 거리로 시작합니다. 이 위치에서 `+1` 점프를 하면 다음 돌로 이동할 수 있습니다.

## 2. 모든 돌을 순회하며 가능한 점프 거리 탐색

```
for (int i = 0; i < stones.length; i++) {
    int stone = stones[i];
    Set<Integer> stepSet = steps.get(stone);
```

- stones 배열을 왼쪽에서 오른쪽으로 순차적으로 탐색한다.
- 현재 돌의 점프 거리 목록(stepSet)을 가져온다.

## 3. 다음 점프 거리(k-1, k, k+1)를 계산

```
for (Integer step : stepSet) {
    for (int k = step - 1; k <= step + 1; k++) {
        if (steps.containsKey(stone + k)) {
            if (stone + k == target) return true;
            if (stone + k != stone) {
                steps.get(stone + k).add(k);
            }
        }
    }
}
```

### 3.1 점프 거리 k의 범위

- `k = step - 1`, `step`, `step + 1`  
  → 이전 점프 거리를 기준으로 k-1, k, k+1만큼 점프한다.  
  → 조건: k > 0 (점프 거리가 양수여야 함).

### 3.2 다음 돌로 이동 가능한지 확인

- `if (steps.containsKey(stone + k)):`  
  → 현재 돌 stone에서 점프 거리 k를 더한 위치(stone + k)에 돌이 존재하는지 확인합니다.

### 3.3 목표 돌 확인

- `if (stone + k == target) return true;`
  → 다음 돌이 마지막 돌(`target`)이라면 `true`를 반환하고 종료합니다.

### 3.4 다음 돌에 점프 거리 추가

- `steps.get(stone + k).add(k):`  
  → 현재 돌에서 점프 거리 k로 도달할 수 있는 다음 돌의 점프 거리 목록에 k를 추가한다.  
  → 이렇게 하면 다음 돌에서 가능한 점프 거리를 기록하고, 이후의 탐색에 활용된다.

## 시간 복잡도

각 돌에서 최대 O(3)개의 점프 거리를 확인한다.  

총 N개의 돌이 있으므로 O(N^2)이 된다.

## 공간 복잡도

Map의 크기는 최대 O(N)이며, 각 돌당 Set에 저장되는 점프 거리는 평균적으로 적기 때문에 공간 복잡도는 O(N)이다.

## 정리 

각 돌에서 가능한 점프 거리를 기록하고 동적 계획법을 활용해 효율적으로 탐색한다. 중복된 경로를 제거하고 빠르게 목표 돌에 도달하는지 확인해서 최적화한다.