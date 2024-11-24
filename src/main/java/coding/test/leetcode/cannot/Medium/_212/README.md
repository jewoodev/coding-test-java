# 212. Word Search II

문제 링크: [링크](https://leetcode.com/problems/word-search-ii/description/)

각 words의 첫번째 문자를 찾아서 거기서부터 dfs 탐색을 하면서 만들 수 있는 단어들을 반환하려는게 내 아이디어였는데,   
오답이 자꾸 생겨난다. 

처음엔 board 이차원 배열 인덱스 아웃으로 터지고, 그 다음엔 단어 인덱싱하는데에서 인덱스 아웃으로 터지고,  
그 다음엔 한 번 사용한 문자열이 재사용되면서 오답이 나오는 문제가 생기고,  
이번엔 dfs로 탐색하다가 return 먹으면 돌아간 후에 상하좌우로 매칭되는게 있으면 거기서부터 다시 타고 들어가야 되는데  
그렇게 작동되지 않아서 문제인 것 같다.

문제의 테스트 케이스다.

```java
class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(
                        new char[][]{
                                {'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}
                        },
                        new String[]{"eaafgdcba", "eaabcdgfa"},
                        new ArrayList<>(Arrays.asList("eaafgdcba", "eaabcdgfa"))
                )
        );
    }
}
```

dfs 한 사이클을 돌고 checked를 풀어주지 않아서 문제였다. 이를 수정함으로써 풀렸다.
하지만 `Time Limit Exceeded` 로 터졌다. 