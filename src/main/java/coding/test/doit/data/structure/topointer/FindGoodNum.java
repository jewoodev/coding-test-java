package coding.test.doit.data.structure.topointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindGoodNum {
    /**
     * 2초 / 2,000 -> O(nlogn)
     */
    public static void main(String[] args) throws IOException { //p63
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //수의 개수
        int result = 0;
        Long[] a = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken()); //배열에 주어지는 수 저장
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            Long find = a[i];
            int j = 0;
            int k = n - 1;
            //투 포인터 알고리즘
            while (j < k) {
                if (a[j] + a[k] == find) {
                    //find는 서로 다른 두 수의 합이어야 함을 체크
                    if (j != i && k != i) {
                        result++;
                        break;
                    } else if (j == i) {
                        j++;
                    } else if (k == i) {
                        k--;
                    }
                } else if (a[k] + a[j] < find) {
                    j++;
                } else k--;
            }
        }
        System.out.println(result);
        br.close();
    }
}
