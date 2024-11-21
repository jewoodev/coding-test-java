package coding.test.doit.data.structure.intervalsum;

import java.io.*;
import java.util.StringTokenizer;

public class IntervalSum2 { //p47 내 풀이, 틀렸다
    /**
     * 1024 * 1024 * 100,000
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int quiryNum = Integer.parseInt(st.nextToken());

        int[][] graph = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < quiryNum; i++) {
            st = new StringTokenizer(br.readLine());
            int sumResult = 0;
            int[] startPoint = assign1Dimen(2, new int[2], st);
            int[] endPoint = assign1Dimen(2, new int[2], st);

            for (int j = startPoint[1]; j < endPoint[1] + 1; j++) {
                for (int k = startPoint[0]; k < endPoint[0] + 1; k++) {
                    sumResult += graph[k][j];
                }
            }
            System.out.println("sumResult = " + sumResult);
        }
        br.close();
        bw.close();
    }

    private static int[] assign1Dimen(int x, int[] intArr, StringTokenizer st) {
        for (int i = 0; i < x; i++) {
            intArr[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        return intArr;
    }
}
