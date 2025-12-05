package coding.test.backjoon.silver;

import java.util.*;
import java.io.*;

public class LCDTest { // https://www.acmicpc.net/problem/2290, DP
    private static int s, m;
    private static StringBuilder ans = new StringBuilder();
    private static final int[][] c = {
            {1,1,1,0,1,1,1},
            {0,0,1,0,0,1,0},
            {1,0,1,1,1,0,1},
            {1,0,1,1,0,1,1},
            {0,1,1,1,0,1,0},
            {1,1,0,1,0,1,1},
            {1,1,0,1,1,1,1},
            {1,0,1,0,0,1,0},
            {1,1,1,1,1,1,1},
            {1,1,1,1,0,1,1}
    };
    private static String n;

    public static void main(String[] args) throws IOException {
        init();
        makeOutput(m, n, ans, s);
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        n = st.nextToken();
        m = n.length();
        br.close();
    }

    private static void makeOutput(int m, String n, StringBuilder ans, int s) {
        for (int i = 0; i < 5; i++) {
            if (i == 0 || i == 2 || i == 4) {
                for (int j = 0; j < m; j++) {  // 각 숫자마다
                    int cur = n.charAt(j) - '0';
                    if (j != 0) ans.append(" ");  // 숫자 사이 공백
                    ans.append(" ");  // 왼쪽 여백

                    // 해당 위치에 가로선이 필요한지 체크
                    if ((i == 0 && c[cur][0] == 1) ||    // 상단선
                            (i == 2 && c[cur][3] == 1) ||    // 중간선
                            (i == 4 && c[cur][6] == 1)) {    // 하단선
                        for (int k = 0; k < s; k++)
                            ans.append("-");  // s개의 '-' 출력
                    } else {
                        for (int k = 0; k < s; k++)
                            ans.append(" ");  // 공백으로 채움
                    }
                    ans.append(" ");  // 오른쪽 여백
                }
                ans.append("\n");
            }
            else {
                for (int l = 0; l < s; l++) {  // s번 반복 (행의 높이)
                    for (int j = 0; j < m; j++) {  // 각 숫자마다
                        int cur = n.charAt(j) - '0';
                        if (j != 0) ans.append(" ");

                        // 왼쪽 세로선 체크
                        if ((i == 1 && c[cur][1] == 1) ||  // 상단 왼쪽
                                (i == 3 && c[cur][4] == 1))    // 하단 왼쪽
                            ans.append("|");
                        else
                            ans.append(" ");

                        for (int k = 0; k < s; k++)
                            ans.append(" ");  // 가운데 공백

                        // 오른쪽 세로선 체크
                        if ((i == 1 && c[cur][2] == 1) ||  // 상단 오른쪽
                                (i == 3 && c[cur][5] == 1))    // 하단 오른쪽
                            ans.append("|");
                        else
                            ans.append(" ");
                    }
                    ans.append("\n");
                }
            }
        }
    }

    private static void print() {
        System.out.print(ans);
    }
}
