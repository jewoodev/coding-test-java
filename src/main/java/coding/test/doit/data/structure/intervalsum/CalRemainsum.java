package coding.test.doit.data.structure.intervalsum;

import java.io.*;
import java.util.StringTokenizer;

public class CalRemainsum {  //p52
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

    static int[] sumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()); //주어지는 n, m 값 저장
        sumArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sumArr[i] = Integer.parseInt(st.nextToken());
        }

        sumArr = makeSumArr(sumArr);

        for (int elem : sumArr) {
            if (elem % m == 0) answer++;
        }
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    static int[] makeSumArr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i-1];
        }
        return arr;
    }
}
