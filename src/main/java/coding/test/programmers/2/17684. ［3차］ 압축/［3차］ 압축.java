import java.util.*;


class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int idx = 27;
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) (i + 'A')), (i + 1));
        }
       
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            sb.append(msg.charAt(i++));


            int tmp = 0;
            while (i < msg.length() && map.containsKey(sb.toString())) {
                tmp = map.get(sb.toString());
                sb.append(msg.charAt(i++));
            }
           
            if (i == msg.length()) {
                if (map.containsKey(sb.toString())) {
                    list.add(map.get(sb.toString()));
                } else {
                    list.add(tmp);
                    list.add(map.get(String.valueOf(msg.charAt(i - 1))));
                }
                break;
            }
            list.add(tmp);
            map.put(sb.toString(), idx++);
            i--;
            sb = new StringBuilder();
        }
       
        return list.stream().mapToInt(l -> l).toArray();
    }
}
