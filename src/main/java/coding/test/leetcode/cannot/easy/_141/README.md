# 141. [Linked List Cycle](https://leetcode.com/problem/linked-list-cycle/)

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.



**Example 1:**

<img src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" alt="img1">

> **Input**: head = [3,2,0,-4], pos = 1 
> **Output**: true 
> **Explanation**: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

**Example 2:**

<img src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png">

> **Input**: head = [1,2], pos = 0
> **Output**: true
> **Explanation**: There is a cycle in the linked list, where the tail connects to the 0th node.

**Example 3:**

<img src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test3.png">

> **Input**: head = [1], pos = -1 
> **Output**: false 
> **Explanation**: There is no cycle in the linked list.


**Constraints:**

- The number of the nodes in the list is in the range [0, 104].
- -105 <= Node.val <= 105
- pos is -1 or a valid index in the linked-list.

<br/>
**Follow up**: Can you solve it using O(1) (i.e. constant) memory?

---

이 문제를 Java로 해결하는 가장 효율적인 방법은 Floyd’s Cycle Detection Algorithm (토끼와 거북이 알고리즘, Slow-Fast Pointer) 을 사용하는 것입니다. 이 방법은 시간 복잡도 𝑂(𝑛), 공간 복잡도 𝑂(1)로 해결할 수 있습니다.

## 풀이 접근 방식

1. **Slow, Fast 포인터를 활용**
   - slow 포인터는 한 번에 한 칸 이동
   - fast 포인터는 한 번에 두 칸 이동
2. **사이클 판별**
   - 만약 fast 포인터가 null 또는 fast.next 가 null 이라면 사이클이 없음 (false)
   - slow == fast 가 되는 순간이 발생하면 사이클이 있음 (true)

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // 한 칸 이동
            fast = fast.next.next;   // 두 칸 이동

            if (slow == fast) {      // 만약 두 포인터가 만나면 사이클이 존재
                return true;
            }
        }

        return false;  // 끝까지 도달했다면 사이클 없음
    }
}
```

## 시간복잡도 & 공간복잡도 분석

- 시간복잡도:𝑂(𝑛)
  - slow와 fast 포인터가 이동하면서 최악의 경우 𝑛개의 노드를 모두 방문함.
- 공간복잡도:𝑂(1)
  - 추가적인 메모리 사용 없이 slow와 fast 포인터만 사용.

## 왜 Floyd’s Algorithm을 사용해야 할까?

1. **해시셋을 이용한 풀이 (O(n) 공간 필요)**
   - 방문한 노드를 HashSet에 저장하는 방법도 있지만, 공간 복잡도가 𝑂(𝑛)이므로 비효율적임.
2. Floyd’s Algorithm 사용 (O(1) 공간)
   - 포인터만 사용하여 추가적인 공간을 사용하지 않음.
