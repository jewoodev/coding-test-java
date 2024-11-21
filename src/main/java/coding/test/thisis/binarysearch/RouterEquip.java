package coding.test.thisis.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RouterEquip {

    private static int[] arr;
    private static int n;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int maxItv = arr[n -1] - arr[0];

        int answer = binarySearch(0, maxItv);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static int binarySearch(int start, int end) {
        int result = 0;
        while (start <= end) {
            int cnt = 1;
            int prv_home = arr[0]; //previous home position
            int mid = (start + end) / 2; //the middle
            //공유기 설치 과정
            for (int i = 0; i < n; i++) {
                if (arr[i] - prv_home >= mid) {
                    cnt++;
                    prv_home = arr[i];
                }
            }

            if (cnt >= c) { //집 사이 거리를 적당히 설정했을 때
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
