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

