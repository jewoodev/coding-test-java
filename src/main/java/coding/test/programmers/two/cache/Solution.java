package coding.test.programmers.two.cache;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LRUCache cache = new LRUCache(cacheSize);
        int answer = 0;

        for (String c : cities) {
            answer += cache.getOrSet(c);
        }

        return answer;
    }

    class LRUCache {
        private static final int CACHE_MISS = 5;
        private static final int CACHE_HIT = 1;

        class Node {
            Node next;
            Node prev;
            String key;
        }

        int size = 0;
        Map<String, Node> map = new HashMap<>();
        Node head = new Node();
        Node tail = new Node();

        LRUCache(int size) {
            this.size = size;
            head.next = tail;
            tail.prev = head;
        }

        public int getOrSet(String key) {
            if (size == 0) return CACHE_MISS;
            key = key.toLowerCase();

            if (map.containsKey(key)) {
                Node node = map.get(key);
                removeNode(node);
                addToHead(node);

                return CACHE_HIT;
            }

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

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }
    }
}

