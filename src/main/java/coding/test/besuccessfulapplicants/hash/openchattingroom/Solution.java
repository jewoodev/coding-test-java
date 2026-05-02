package coding.test.besuccessfulapplicants.hash.openchattingroom;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        var map = new HashMap<String, String>();
        var list = new ArrayList<String[]>();

        for (int i = 0; i < record.length; i++) {
            var arr = record[i].split(" ");

            if (arr[0].equals("Leave")) {
                list.add(new String[]{arr[1], "님이 나갔습니다."});
                continue;
            }
            else if (arr[0].equals("Enter")) {
                list.add(new String[]{arr[1], "님이 들어왔습니다."});
            }

            map.put(arr[1], arr[2]);
        }

        var answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            var arr = list.get(i);
            var name = map.get(arr[0]);
            answer[i] = name + arr[1];
        }

        return answer;
    }
}