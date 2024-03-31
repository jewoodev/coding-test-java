package hanghae.secondWeek.wrong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//ENTER가 나올 때마다 SET을 CLEAR해줘야 하고 SET으로 이전 출연 여부를 체크하는 등의 구현 필요성을 설명만 읽고 파악하지 못한 문제
//제출하면서 고쳤다.
class Problem25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean enter = false;
        int cnt = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                set.clear();
                enter = true;
                continue;
            }
            if (enter && !set.contains(s)) {
                cnt++;
                set.add(s);
            }
        }
        System.out.print(cnt);
    }
}