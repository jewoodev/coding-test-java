package thisis.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakeRiceCake2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] rc = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            rc[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(rc);

        int answer = binarySearch(rc, m, 0, rc[rc.length - 1]);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static int binarySearch(int[] arr, int m, int start, int end) {
        int max = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            //떡 자르기, 절단기 길이보다 짧은 떡은 0 처리
            int cutting = 0;
            for (int i : arr) {
                cutting += Math.max((i - mid), 0);
            }
            if (cutting == m) return mid; //자른 떡이 요청받은 길이와 같다면 정답
            else if (cutting < m) { //자른 떡이 가져가야 하는 길이보다 작음, 절단기 길이 줄이기
                end = mid - 1;
            } else { //자른 떡이 가져가야 하는 길이보다 김, 절단기 길이 늘리기
                start = mid + 1;
                max = mid;
            }
        }
        //자투리 떡을 주게되는 차선책
        return max;
    }
}
