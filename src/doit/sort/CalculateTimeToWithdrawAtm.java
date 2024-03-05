package doit.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CalculateTimeToWithdrawAtm { //삽입 정렬/P115 ATM 인출 시간 계산하기
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        } //정렬을 하기 위한 배열 초기화 완료

        for (int i = 1; i < n; i++) { //삽입 정렬
            int insertPoint = i;
            int insertValue = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) {
                    insertPoint = j + 1;
                    break;
                }
                if (j == 0) {
                    insertPoint = 0;
                }
            }
            for (int j = i; j > insertPoint; j--) {
                a[j] = a[j - 1];
            }
            a[insertPoint] = insertValue;
        }
        s[0] = a[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i-1] + a[i];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + s[i];
        }
        System.out.println(sum);
    }


    /**
     * 삽입 정렬로 풀 방법이 떠오르지 않아 빠르게 포기한 것이 아쉬운 문제, 기본 제공되는 sort()로 풀기는 풀었다.
     */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine()); //n은 인출할 사람의 수
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = Integer.parseInt(st.nextToken());
//        } //여기까지 정렬하기 위한 배열 초기화 완료
//
//        Arrays.sort(a);
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i + 1; j++) {
//                sum += a[j];
//            }
//        }
//        System.out.println("sum = " + sum);
//    }
}
