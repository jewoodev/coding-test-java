package coding.test.besuccessfulapplicants.hash.receivereportresults;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        var idxMap = new HashMap<String, Integer>();
        var receiveMap = new HashMap<String, Set<String>>();

        for (int i = 0; i < id_list.length; i++) {
            idxMap.put(id_list[i], i);
        }

        for (int i = 0; i < report.length; i++) {
            var re = report[i].split(" ");
            receiveMap.computeIfAbsent(re[1], key -> new HashSet<>()).add(re[0]);
        }

        int[] answer = new int[id_list.length];
        for (var whoReport : receiveMap.values()) {
            if (whoReport.size() >= k) {
                for (var id : whoReport) {
                    answer[idxMap.get(id)]++;
                }
            }
        }

        return answer;
    }
}
