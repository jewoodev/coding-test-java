package doit.data.structure.intervalsum;

import java.io.IOException;
import java.util.Scanner;

public class IntervalSum {
    public static void main(String[] args) throws IOException { //p44 내 풀이
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] givenNum = new int[n];
        int [] resultArr = new int[m];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            givenNum[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int startPoint = sc.nextInt();
            int endPoint = sc.nextInt();
            int sumResult = 0;

            for (int j = startPoint-1; j < endPoint; j++) {
                sumResult += givenNum[j];

                if (j == endPoint-1){
                    resultArr[idx] = sumResult;
                    idx += 1;
                }
            }
        }

        for (int i : resultArr) {
            System.out.println(i);
        }
    }
}
