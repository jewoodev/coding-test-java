package coding.test.doit.sort;

import java.io.*;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        mData[] a = new mData[n];

        for (int i = 0; i < n; i++) {
            a[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(a); //a배열 정렬(O(nlogn) 시간 복잡도)
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < a[i].idx - i) //정렬 전 index - 정렬 후 index 계산의 최댓값 저장하기
                max = a[i].idx - i;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(max+1));
        bw.close();
        br.close();
    }

    private static class mData implements Comparable<mData> {
        int val, idx;

        public mData(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }


        @Override
        public int compareTo(mData o) {
            return this.val - o.val;
        }
    }
}
