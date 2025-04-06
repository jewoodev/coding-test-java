package coding.test.others.topologysort;

import java.util.*;

public class Solution {
    static String[] getLoadFactors(String[] service_list, String entrypoint) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> loadMap = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (String sl : service_list) {
            String[] arr = sl.split("=");
            String from = arr[0];
            map.putIfAbsent(from, new HashSet<>());
            loadMap.put(from, 0);

            if (arr.length == 1) continue;
            String[] toArr = arr[1].split(",");

            for (String to : toArr) {
                map.get(from).add(to);
                loadMap.put(to, 0);
                indegree.put(to, indegree.getOrDefault(to, 0) + 1);
            }
        }

        loadMap.put(entrypoint, 1);
        Queue<String> q = new LinkedList<>();
        q.add(entrypoint);

        while (!q.isEmpty()) {
            String from = q.poll();

            if (map.containsKey(from)) {
                for (String to : map.get(from)) {
                    loadMap.put(to, loadMap.get(from) + loadMap.get(to));
                    indegree.put(to, indegree.get(to) - 1);
                    if (indegree.get(to) == 0) {
                        q.add(to);
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : loadMap.entrySet()) {
            if (!map.containsKey(e.getKey()) || e.getValue() == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(e.getKey()).append("*").append(e.getValue());
            result.add(sb.toString());
        }
        Collections.sort(result);

        return result.toArray(new String[result.size()]);
    }
}
