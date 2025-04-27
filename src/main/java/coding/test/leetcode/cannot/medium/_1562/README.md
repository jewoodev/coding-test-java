## [1562. Find Latest Group of Size M](https://leetcode.com/problems/find-latest-group-of-size-m/description/)

> 이 문제는 중복된 수가 들어오지 않는다는 조건이 중요한 포인트이다. 

문자의 핵심은 다음과 같다.

1. 1부터 n까지의 숫자가 순차적으로 주어진다.
2. 각 숫자는 배열의 해당 인덱스에 1을 설정한다.
3. 연속된 1들의 그룹 중 크기가 정확히 m인 그룹이 존재하는 가장 마지막 단계를 찾아야 한다.

효율적인 해결 방법은 다음과 같다.

1. Union-Find (Disjoint Set) 자료구조를 사용하여 연속된 1들의 그룹을 관리한다.
2. 각 단계마다 새로운 1을 추가할 때, 좌우의 그룹과 병합한다.
3. 각 그룹의 크기를 추적하면서, 크기가 정확히 m인 그룹이 있는지 확인한다.

이를 구현한 코드를 작성해보겠다.

```java
class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n) return n;
        
        int[] parent = new int[n + 2];
        int[] size = new int[n + 2];
        int[] count = new int[n + 2];
        int result = -1;
        
        for (int i = 0; i < n; i++) {
            int pos = arr[i];
            parent[pos] = pos;
            size[pos] = 1;
            count[1]++;
            
            if (parent[pos - 1] != 0) {
                union(parent, size, count, pos - 1, pos);
            }
            if (parent[pos + 1] != 0) {
                union(parent, size, count, pos, pos + 1);
            }
            
            if (count[m] > 0) {
                result = i + 1;
            }
        }
        
        return result;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    
    private void union(int[] parent, int[] size, int[] count, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        
        if (rootX != rootY) {
            count[size[rootX]]--;
            count[size[rootY]]--;
            
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
            
            count[size[rootX]]++;
        }
    }
}
```

이 코드는 다음과 같은 주요 특징을 가지고 있다. 

1. **Union-Find 자료구조**
    - `parent` 배열: 각 위치의 부모 노드를 저장
    - `size` 배열: 각 그룹의 크기를 저장
    - `count` 배열: 각 크기의 그룹이 몇 개 있는지 추적
2. **최적화된 접근**
    - 각 단계에서 새로운 1을 추가할 때마다 좌우의 그룹과 병합
    - 병합 시 그룹 크기를 업데이트하고 count 배열을 관리
    - 크기가 m인 그룹이 존재하는지 O(1) 시간에 확인 가능
3. **시간 복잡도**
    - 전체 시간 복잡도: O(n α(n)) (α는 아커만 함수의 역함수로, 실질적으로 상수 시간)
    - 공간 복잡도: O(n)
4. **특별 케이스 처리**
    - m이 전체 길이 n과 같을 경우 바로 n을 반환 (모든 수가 1이 되는 마지막 단계)

이 구현은 문제의 제약 조건을 효율적으로 처리하면서도, 코드가 직관적이고 이해하기 쉽다. Union-Find를 사용함으로써 그룹 병합과 크기 추적을 효과적으로 수행할 수 있다.

---

## 다른 풀이법

Union-Find 자료구조를 사용하지 않고 더 효율적으로 풀 수 있다. 

주요 아이디어는 다음과 같다.

1. **배열의 의미**
   - `length` 배열은 각 위치에서 시작하거나 끝나는 연속된 1들의 그룹의 길이를 저장합니다.
   - 배열의 크기를 `arr.length + 2`로 설정한 것은 인덱스 범위를 벗어나는 것을 방지하기 위함입니다.
2. **핵심 로직**
    ```java
    int left = length[num - 1], right = length[num + 1];
    length[num - left] = left + right + 1;
    length[num + right] = left + right + 1;
    ```
    - `left`: 현재 위치의 왼쪽에 있는 연속된 1들의 그룹 길이
    - `right`: 현재 위치의 오른쪽에 있는 연속된 1들의 그룹 길이
    - 새로운 1을 추가하면, 왼쪽과 오른쪽 그룹이 합쳐지므로
      - 왼쪽 그룹의 시작점(`num - left`)에 새로운 전체 길이를 저장
      - 오른쪽 그룹의 끝점(`num + right`)에 새로운 전체 길이를 저장
3. **결과 확인**
    ```java
    if (left == m || right == m) {
        result = i;
    }
    ```
    - 현재 단계에서 왼쪽이나 오른쪽 그룹의 길이가 정확히 m이면, 그 단계를 결과로 저장
    - 마지막으로 저장된 단계가 정답이 됨

```java
class Solution {
    public int findLatestStep(int[] arr, int m) {
        if (arr.length == m) return m;
        int[] length = new int[arr.length + 2];

        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int left = length[num - 1], right = length[num + 1];

            length[num - left] = left + right + 1;
            length[num + right] = left + right + 1;

            if (left == m || right == m) {
                result = i;
            }
        }

        return result;
    }
}
```

이 풀이의 장점:

1. Union-Find보다 더 간단하고 직관적
2. 공간 복잡도가 O(n)으로 동일하지만, 구현이 더 간단
3. 각 단계에서 상수 시간(O(1))에 연산이 가능

예시로 설명하면:

```text
arr = [3,5,1,2,4], m = 1

단계 1: 3 추가
[0,0,0,1,0,0,0]
length[3] = 1

단계 2: 5 추가
[0,0,0,1,0,1,0]
length[5] = 1

단계 3: 1 추가
[0,1,0,1,0,1,0]
length[1] = 1

단계 4: 2 추가
[0,1,1,1,0,1,0]
length[1] = 2, length[2] = 2

단계 5: 4 추가
[0,1,1,1,1,1,0]
length[1] = 5, length[5] = 5
```

이 풀이는 그룹의 시작점과 끝점만 추적하면서 연속된 1들의 그룹을 효율적으로 관리하는 매우 우아한 방법이다.