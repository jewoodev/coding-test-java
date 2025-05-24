import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String[]> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (String r : record) {
            String[] arr = r.split(" ");
           
            switch (arr[0]) {
                case "Enter":
                    list.add(arr);
                    map.put(arr[1], arr[2]);
                    break;
                case "Leave":
                    list.add(arr);
                    break;
                case "Change":
                    map.put(arr[1], arr[2]);
                    break;
            }
        }
       
        String[] answer = new String[list.size()];
        int idx = 0;
        for (String[] arr : list) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.get(arr[1])).append("님이 ");
            sb.append("Enter".equals(arr[0]) ? "들어왔습니다." : "나갔습니다.");
            answer[idx++] = sb.toString();
        }
       
        return answer;
    }
}
