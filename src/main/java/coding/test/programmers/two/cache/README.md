## [캐시](https://programmers.co.kr/learn/courses/30/lessons/17680)

LRU 알고리즘을 구현하는 문제는 되게 흔한 편이다. O(1)을 만족하려면 선택지가 많지 않다. 

주요 구현 포인트를 살펴보자. 

1. **데이터 구조**
   - HashMap<String, Node>: O(1) 시간에 캐시 조회를 가능하게 한다.
   - Node 클래스: 양방향 연결 리스트를 구현하여 LRU 순서를 관리한다.
   - head와 tail: 더미 노드로 연결 리스트의 시작과 끝을 표시한다.

2. **핵심 로직**

    ```java
       public int getOrSet(String key) {
       if (size == 0) return CACHE_MISS;
       key = key.toLowerCase();  // 대소문자 구분 없이 처리

       // 캐시 히트
       if (map.containsKey(key)) {
           Node node = map.get(key);
           removeNode(node);
           addToHead(node);
           return CACHE_HIT;
       }

       // 캐시 미스
       if (map.size() == size) {
           Node node = tail.prev;
           map.remove(node.key);
           removeNode(node);
       }

       Node node = new Node();
       node.key = key;
       map.put(key, node);
       addToHead(node);
       return CACHE_MISS;
    }
    ```
3. **시간 복잡도**
   - 조회: O(1) - HashMap 사용
   - 삽입: O(1) - 연결 리스트 조작
   - 삭제: O(1) - 연결 리스트 조작
4. **공간 복잡도**
   - O(cacheSize) - 캐시 크기에 비례
5. **이 구현의 장점**
   - 모든 연산이 O(1) 시간에 수행된다.
   - 대소문자 구분 없이 처리한다.
   - 양방향 연결 리스트를 사용하여 효율적인 노드 이동이 가능하다.
   - 더미 노드(head, tail)를 사용하여 경계 조건 처리가 깔끔하다.

이 구현은 LRU 캐시의 모든 요구사항을 만족하면서도 효율적인 성능을 제공한다. 실제 프로덕션 환경에서도 사용할 수 있는 수준의 구현이라고 볼 수 있다.

--- 

그리고 이 풀이는 head와 tail 노드(더미 노드)를 사용하는데, 이 설계의 의도와 장점을 자세히 살펴보자.

1. **경계 조건 처리의 단순화**
    
    ```java
    LRUCache(int size) {
        this.size = size;
        head.next = tail;
        tail.prev = head;
    }
    ```

    - 더미 노드를 사용함으로써 빈 리스트 상태에서도 head.next와 tail.prev가 항상 존재한다.
    - 이는 첫 번째 노드 추가나 마지막 노드 제거 시 특별한 예외 처리가 필요 없게 된다.
2. **노드 삽입/삭제 연산의 일관성**
    
    ```java
    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    ```

    - 더미 노드가 있기 때문에 모든 노드가 prev와 next를 가진다는 것이 보장된다.
    - 리스트의 시작이나 끝에 있는 노드도 동일한 방식으로 처리할 수 있다.
3. **코드의 안정성 향상**
    - `NullPointerException` 발생 가능성이 크게 줄어든다.
    - 리스트가 비어있는 상태에서도 안전하게 동작한다.
    - 노드 삽입/삭제 시 항상 동일한 패턴의 코드를 사용할 수 있다.
4. **LRU 캐시의 특성에 적합**

    ```java
    if (map.size() == size) {
        Node node = tail.prev;  // 가장 오래된 노드 접근이 매우 간단
        map.remove(node.key);
        removeNode(node);
    }
    ```

    - `tail.prev`로 가장 오래된 노드에 즉시 접근 가능하다.
    - `head.next`로 가장 최근 사용된 노드에 즉시 접근 가능하다.
5. **메모리 효율성**

    - 더미 노드는 단 두 개만 추가되므로 메모리 오버헤드가 미미하다.
    - 이는 코드의 안정성과 가독성 향상이라는 이점에 비하면 매우 작은 비용이다.

이러한 설계는 "Sentinel Node Pattern"이라고도 불리며, 연결 리스트 구현에서 널리 사용되는 패턴입니다. 특히 LRU 캐시와 같이 빈번한 노드 이동과 삽입/삭제가 발생하는 상황에서 그 장점이 더욱 두드러진다.

원형 연결 리스트 방식으로 구현할 수도 있지만, LRU 캐시의 특성상 가장 오래된 노드에 자주 접근해야 하는데, 이 부분에서 현재 구현된 더미 노드 방식이 더 직관적이고 명확하다.