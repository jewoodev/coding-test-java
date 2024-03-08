package doit.number.theory;

import java.io.*;
import java.util.StringTokenizer;

public class GetPrimeNum { /* P217 문제 37 소수 구하기 */
    /* 여기서 배열 앞에서 부터 소수인 수의 배수를 삭제하는 것을 반복해야 하는데, 소수인지 아닌지 판단하는 것부터 시간복잡도를 고려해서 구현하려니까 좋은 방법이 떠오르지 않는다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); //m은 "M 이상"의 M 값
        int n = Integer.parseInt(st.nextToken()); //n은 "N 이하"의 N 값
        if (m == 1) m = 2; //1은 소수가 아니기 때문에 애초에 제거
        int[] a = new int[m - n + 1]; //a는 연산을 위한 배열
        for (int i = 0; i < m - n + 1; i++) {
            a[i] = i + m;
        }
        while (true) {
            for (int i : a) {

            }
        }
    }
*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        br.close();
        int[] a = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            a[i] = i;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (a[i] == 0) continue;
            for (int j = i+i; j <= n; j+=i) { //배수 지우기
                a[j] = 0;
            }
        }

    }
}
