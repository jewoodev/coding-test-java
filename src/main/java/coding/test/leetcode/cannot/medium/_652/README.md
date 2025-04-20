# [652. Find Duplicate Subtrees](https://leetcode.com/problems/find-duplicate-subtrees/description/)

이 문제는 이진 트리에서 중복된 서브트리를 찾는 문제입니다. 문제를 해결하기 위한 핵심 아이디어는 다음과 같다.

1. 각 서브트리를 고유하게 표현하는 문자열을 생성하여 해시맵에 저장
2. 서브트리가 이미 해시맵에 존재하면 중복된 서브트리로 판단
3. 중위 순회나 전위 순회를 사용하여 서브트리를 문자열로 직렬화

먼저 문제를 해결하기 위한 코드를 살펴보자.

```java
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        serialize(root, map, result);
        return result;
    }

    private String serialize(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
        if (node == null) return "#";
        
        String serial = node.val + "," + serialize(node.left, map, result) + "," + serialize(node.right, map, result);
        
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            result.add(node);
        }
        
        return serial;
    }
}
```

이 풀이의 주요 아이디어와 동작 방식을 살펴보자.

1. **서브트리 직렬화** 
   - 각 서브트리를 문자열로 직렬화합니다. 예를 들어, 노드의 값과 왼쪽/오른쪽 자식의 직렬화된 문자열을 콤마로 구분하여 연결합니다. 
   - null 노드는 '#'으로 표시합니다.
2. **중복 검출**
   - 직렬화된 문자열을 키로 사용하여 해시맵에 저장합니다.
   - 같은 직렬화 문자열이 두 번째로 나타날 때 해당 서브트리를 결과 리스트에 추가합니다.
3. **시간 복잡도**
   - O(N^2) - 각 노드를 방문하고, 각 노드마다 직렬화 문자열을 생성해야 합니다.
   - 공간 복잡도는 O(N^2) - 직렬화된 문자열을 저장해야 합니다. 

예를 들어, 다음과 같은 트리가 있다고 가정해보자.

```
     1
    / \
   2   3
  /   / \
 4   2   4
    /
   4
```

이 경우 직렬화된 문자열은 다음과 같이 생성된다.

- 4,#,#
- 2,4,#,#,#
- 4,#,# (중복)
- 2,4,#,#,# (중복)
- 3,2,4,#,#,#,4,#,#

결과적으로 [4]와 [2,4] 서브트리가 중복되어 반환된다.  
이 방식은 모든 서브트리를 고유하게 식별할 수 있으며, 중복된 서브트리를 효율적으로 찾을 수 있다.