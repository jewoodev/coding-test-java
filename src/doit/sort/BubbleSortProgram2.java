package doit.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 버블 정렬의 swap이 몇 번 일어났는지 병합 정렬로 구해야 할 것 같은데 어떻게 응용해야 할지 감이 안잡히는 문제
* 풀이법을 보고 swap 횟수를 어떻게 계산할지 확인한 후 구현했지만 답이 틀림 */
public class BubbleSortProgram2 {
    private static mData[] tmp;
    private static int n;
    private static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mData[] a = new mData[n];
        tmp = new mData[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = new mData(Integer.parseInt(st.nextToken()), i);
        }

        mergeSort(a, 0, a.length-1);
        System.out.println(result);
    }

    private static void mergeSort(mData[] a, int s, int e) {
        if (e - s < 1) return;
        int m = s + (e - s) / 2;
        mergeSort(a, s, m);
        mergeSort(a, m+1, e);
        if (e + 1 - s >= 0) System.arraycopy(a, s, tmp, s, e + 1 - s);
        int k = s;
        int idx1 = s;
        int idx2 = m + 1;
        while (idx1 <= m && idx2 <= e) {
            if (tmp[idx1].val < tmp[idx2].val) {
                a[k] = tmp[idx1];
                k++;
                idx1++;
            } else {
                a[k] = tmp[idx2];
                result += idx2 - k;
                k++;
                idx2++;
            }
        }
        while (idx1 <= m) {
            a[k] = tmp[idx1];
            k++; idx1++;
        }
        while (idx2 <= e) {
            a[k] = tmp[idx2];
            k++; idx2++;
        }
    }

    private static int calSwapTimes(mData[] a) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += i - a[i].idx;
        }
        return result;
    }

/* 실패한 풀이
    public static void Main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mData[] a = new mData[n];
        tmp = new mData[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = new mData(Integer.parseInt(st.nextToken()), i);
        }

        mergeSort(a, 0, a.length-1);
        System.out.println(calSwapTimes(a));
    }
*/

/* 실패한 풀이
    private static void mergeSort(mData[] a, int s, int e) {
        if (e - s < 1) return;
        int m = s + (e - s) / 2;
        mergeSort(a, s, m);
        mergeSort(a, m+1, e);
        if (e + 1 - s >= 0) System.arraycopy(a, s, tmp, s, e + 1 - s);
        int k = s;
        int idx1 = s;
        int idx2 = m + 1;
        while (idx1 <= m && idx2 <= e) {
            if (tmp[idx1].val < tmp[idx2].val) {
                a[k] = tmp[idx1];
                k++;
                idx1++;
            } else {
                a[k] = tmp[idx2];
                k++;
                idx2++;
            }
        }
        while (idx1 <= m) {
            a[k] = tmp[idx1];
            k++; idx1++;
        }
        while (idx2 <= e) {
            a[k] = tmp[idx2];
            k++; idx2++;
        }
    }

    private static int calSwapTimes(mData[] a) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += i - a[i].idx;
        }
        return result;
    }
*/

    static class mData implements Comparable<mData> {
        int val;
        int idx;

        public mData(int val, int idx) {
            super();
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(mData o) {
            return this.val - o.val;
        }
    }
}
