package coding.test.doit.data.structure.intervalsum;

import java.io.*;
import java.util.Scanner;

public class CalRemainsumCorrect {  //p52
    /**
     * 문제 자체가 구간 합 값 중에 m으로 나눠떨어지는 경우를 세는 걸 요구하고 있다.
     * 입력이 10^6 이고 이 수에 대해 모든 구간 합을 구해야 하기에 구간 합 배열을 이용해야 1초 의 제한을 지킬 수 있다.
     *
     * # Pseudo code
     * N, M 값 저장하기
     * for(N만큼 반복하기) {
     *     합 배열에 주어진 값에 맞는 값들 저장하기
     * }
     * for(for each 문으로 합 배열 반복하기) {
     *     if(요소가 M으로 나눠떨어지면) 횟수 증가
     * }
     * 결과 출력하기
     *
     * # 의구심
     * 구간 합 배열에서 각 요소들을 제거한 값도 모두 체크해야 하는데 음..
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] s = new long[n];
        long[] c = new long[m];
        long answer = 0;
        s[0] = sc.nextInt();
        for (int i = 1; i < n; i++) { //수열 합 배열 만들기
            s[i] = s[i - 1] + sc.nextInt();
        }
        for (int i = 0; i < n; i++) { //합 배열의 모든 값에 % 연산 수행하기
            int remainder = (int) (s[i] % m);
            if (remainder == 0) answer++; //0~i까지의 구간 합 자체가 0일 때 정답에 더하기
            c[remainder]++; //나머지가 같은 인덱스의 개수 카운팅하기
        }
        for (int i = 1; i < m; i++) {
            if (c[i] > 1) {
                //나머지가 같은 걸 쌍으로 묶는 경우의 수
                answer = answer + (c[i] * (c[i] - 1) / 2);
            }
        }
        System.out.println("answer = " + answer);
    }
}
