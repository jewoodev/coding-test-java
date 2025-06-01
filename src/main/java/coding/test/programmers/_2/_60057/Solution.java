package coding.test.programmers._2._60057;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int cnt = 2; cnt <= s.length() / 2; cnt++) {
            StringBuilder sb = new StringBuilder();

            String cur = "";
            int count = 1, i = 0;
            while (i < s.length()) {
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < cnt; j++) {
                    if (i == s.length()) break;
                    tmp.append(s.charAt(i++));
                }

                String target = tmp.toString();
                if (cur.equals(target)) {
                    count++;
                } else {
                    sb.append(count == 1 ? "" : String.valueOf(count)).append(cur);
                    cur = target;
                    count = 1;
                }
            }
            sb.append(count == 1 ? "" : String.valueOf(count)).append(cur);

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
