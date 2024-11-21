package coding.test.hanghae.thirdweek.failed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class BJ1863 {
//    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 주어질 라인 수
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // 불필요한 x 값
            int y = Integer.parseInt(st.nextToken());
            
            if (y == 0) {
                answer += set.size();
                set.clear();
            }
            else set.add(y);
        }
        answer += set.size();
        System.out.println(answer);
    }

//    private static class Point {
//        int x, y;
//        private Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
}