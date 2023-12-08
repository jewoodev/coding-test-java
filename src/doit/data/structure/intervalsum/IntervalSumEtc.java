package doit.data.structure.intervalsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntervalSumEtc {
    public static void main(String[] args) throws IOException { //p42
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());
        long[] sumArr = new long[suNo+1];
        st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= suNo; i++) {
            sumArr[i] = Integer.parseInt(st.nextToken()) + sumArr[i-1];
        }
        for (int q = 0; q < quizNo; q++) {
            st = new StringTokenizer(bf.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            System.out.println(sumArr[endPoint] - sumArr[startPoint - 1]);
        }
    }
}
