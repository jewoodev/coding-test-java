package hanghae.secondWeek.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Problem28432 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        int target = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.equals("?")) target = i;
            list.add(s);
        }
        String prev = list.get(target - 1);
        char s = prev.charAt(prev.length() - 1);
        char e = list.get(target+1).charAt(0);
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String st = br.readLine();
            if (!list.contains(st))
                if (st.charAt(0) == s && st.charAt(st.length()-1) == e)
                    System.out.print(st);
        }
    }
}