package coding.test.doit.data.structure.topointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JoomongsCommand {
    /**
     * 시간 2초, 연산 최대값 15,000^2, 입력최대값 10,000,000
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int materialNum = Integer.parseInt(br.readLine());
        int neededNum = Integer.parseInt(br.readLine());
        int[] a = new int[materialNum]; //재료 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < materialNum; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int i = 0;
        int j = materialNum - 1;
        int count = 0;
        while (i < j) {
            if (a[i] + a[j] < neededNum) {
                i++;
            } else if (a[i] + a[j] > neededNum) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        br.close();
    }
}
