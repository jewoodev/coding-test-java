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
            int last = 1;
            list.add(Integer.parseInt(st.nextToken()));

            int answer = 0;
            for (; st.countTokens() > 0;) {
                int cur = Integer.parseInt(st.nextToken());
                if (list.get(last - 1) > cur) {
                    answer += list.size();
                    list.add(0, cur);
                } else {
                    list.add(last++, cur);
                }
            }

            sb.append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
