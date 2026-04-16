package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

class LiningUp {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Integer> list;
        var sb = new StringBuilder();

        for (int i = 1; i <= p; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            list = new ArrayList<>();
            list.add(Integer.parseInt(st.nextToken()));

            int answer = 0;
            for (; st.countTokens() > 0;) {
                int cur = Integer.parseInt(st.nextToken());
                int idx = list.size() - 1;
                var flag = false;
                while (idx >= 0 && list.get(idx) > cur) {
                    flag = true;
                    idx--;
                }
                if (flag) {
                    answer += list.size() - ++idx;
                    list.add(idx, cur);
                } else list.add(cur);
            }

            sb.append(i).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
