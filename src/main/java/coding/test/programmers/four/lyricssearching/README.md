## [가사 검색](https://school.programmers.co.kr/learn/courses/30/lessons/60060)

## 문제 해석

이 문제는 주어진 단어들(`words`) 중에서 특정 패턴의 쿼리(`queries`)와 일치하는 단어의 개수를 찾는 문제이다. 쿼리에서 `?`는 와일드카드로, 어떤 문자든 올 수 있다.

예를 들어:
- `"fro??"` → `"frodo"`, `"front"` 등과 매칭
- `"??odo"` → `"frodo"` 등과 매칭

## 핵심 아이디어: Trie 자료구조 활용
### 1. 두 방향 Trie 구조

```java
Map<Integer, Trie> map = new HashMap<>();      // 정방향 Trie (길이별)
Map<Integer, Trie> revMap = new HashMap<>();   // 역방향 Trie (길이별)
```
- **정방향 Trie**: `"fro??"` 같은 앞쪽에 고정 문자가 있는 쿼리 처리
- **역방향 Trie**: `"??odo"` 같은 뒤쪽에 고정 문자가 있는 쿼리 처리

### 2. 길이별 분류

같은 길이의 단어들만 매칭 가능하므로, 길이별로 별도의 Trie를 구성한다.

## 코드 동작 과정
### 1. Trie 구조 정의

```java
class Trie {
    Trie[] next = new Trie[26];  // 26개 알파벳
    int children = 0;            // 이 노드를 지나는 단어 개수
}
```

`children` 필드가 핵심입니다. 각 노드에서 그 노드를 지나는 단어의 개수를 저장한다.

### 2. Trie 구축

```java
private void buildTrie(String w, Trie node) {
    node.children++;  // 루트 노드부터 카운트 증가
    
    for (char c : w.toCharArray()) {
        if (node.next[c - 'a'] == null) {
            node.next[c - 'a'] = new Trie();
        }
        node = node.next[c - 'a'];
        node.children++;  // 각 노드마다 카운트 증가
    }
}
```

각 단어를 삽입할 때, 거쳐가는 모든 노드의 `children` 값을 증가시킨다.

### 3. 쿼리 처리 전략

```java
if (q.charAt(0) == '?') {
    // 앞쪽이 ?로 시작하면 → 역방향 Trie 사용
    wc = count(new StringBuilder(q).reverse().toString(), revMap.get(q.length()), 0);
} else {
    // 앞쪽이 고정 문자면 → 정방향 Trie 사용
    wc = count(q, map.get(q.length()), 0);
}
```

**핵심 아이디어**: 쿼리의 첫 문자가 `?`인지 확인하여 어떤 Trie를 사용할지 결정한다.

### 4. 카운팅 로직

```java
private int count(String s, Trie node, int idx) {
    char c = s.charAt(idx);
    
    if (c == '?') {
        return node.children;  // ?를 만나면 현재 노드의 모든 자식 개수 반환
    }
    
    if (node.next[c - 'a'] == null) {
        return 0;  // 매칭되는 경로가 없음
    }
    
    return count(s, node.next[c - 'a'], idx + 1);  // 다음 문자로 진행
}
```

## 예제로 이해하기

**단어들**: `["frodo", "front", "frost"]` **쿼리**: `"fro??"`

1. **정방향 Trie 구축**:
    ``` 
       root(3) → f(3) → r(3) → o(3) → d(1), n(1), s(1)
    ```

2. **쿼리 처리**:
   - `"fro??"` → 정방향 Trie 사용
   - `f` → `r` → `o` 까지 이동
   - `?` 만남 → 현재 노드의 `children` 값(3) 반환

## 시간 복잡도

- **전처리**: O(N × M) (N: 단어 개수, M: 평균 단어 길이)
- **쿼리 처리**: O(M) per query
- **전체**: O(N × M + Q × M) (Q: 쿼리 개수)

이 방법은 단순한 문자열 매칭(O(N × M × Q))보다 훨씬 효율적이다.

## 핵심 포인트

1. **Trie의 `children` 필드**로 서브트리의 단어 개수를 미리 계산
2. **양방향 Trie**로 앞/뒤 와일드카드 모두 효율적 처리
3. **길이별 분류**로 불필요한 비교 제거
