package coding.test.programmers._4._60060;

import java.util.*;


class Solution {
    class Trie {
        Trie[] next = new Trie[26];
        int children = 0; // 해당 노드를 지나는 단어 갯수
    }

    public int[] solution(String[] words, String[] queries) {
        Map<Integer, Trie> map = new HashMap<>(); // 정방향 Trie (길이별)
        Map<Integer, Trie> revMap = new HashMap<>(); // 역방향 Trie (길이별)

        for (String w : words) {
            map.putIfAbsent(w.length(), new Trie());
            revMap.putIfAbsent(w.length(), new Trie());
            buildTrie(w, map.get(w.length()));
            buildTrie(new StringBuilder(w).reverse().toString(), revMap.get(w.length()));
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int wc = 0;

            if (map.containsKey(q.length())) {
                if (q.charAt(0) == '?') {
                    wc = count(new StringBuilder(q).reverse().toString(), revMap.get(q.length()), 0);
                } else {
                    wc = count(q, map.get(q.length()), 0);
                }
            }
            answer[i] = wc;
        }

        return answer;
    }

    private int count(String s, Trie node, int idx) {
        char c = s.charAt(idx);

        if (c == '?') {
            return node.children;
        }

        if (node.next[c - 'a'] == null) {
            return 0; // 매칭되는 경로가 없음
        }

        return count(s, node.next[c - 'a'], idx + 1); // 다음 문자로 진행
    }

    private void buildTrie(String w, Trie node) {
        node.children++; // 루트 노드부터 카운트 증가

        for (char c : w.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Trie();
            }

            node = node.next[c - 'a'];
            node.children++; // 각 노드마다 카운트 증가
        }
    }
}

