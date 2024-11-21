package coding.test.thisis.binarysearch;

import java.io.*;
import java.util.StringTokenizer;

public class FindFixedPoint {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = binarySearch(0, n-1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    private static int binarySearch(int start, int end) {
        if (start >= end) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] == mid) return mid;
        else if (arr[mid] > mid) {
            return binarySearch(start, mid - 1);
        } else {
             return binarySearch(mid + 1, end);
        }
    }
}
