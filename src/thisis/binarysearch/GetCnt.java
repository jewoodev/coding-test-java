package thisis.binarysearch;

import java.io.*;
import java.util.StringTokenizer;

public class GetCnt { //p367
    static int[] arr;
    private static int n, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = leftIdx(0, n-1);
        int right = rightIdx(0, n-1);

        int result = (right - left == 0) ? -1 : (right - left);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }

    private static int leftIdx(int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= x) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    private static int rightIdx(int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > x) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}
