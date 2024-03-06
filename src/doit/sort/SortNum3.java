package doit.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SortNum3 { //기수 정렬/P139 수 정렬하기 3
    private static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        radixSort(a, 5);
        for (int i : a) {
            bw.write(a + "\n");
        }
        bw.close();
    }

    private static void radixSort(int[] a, int maxSize) {
        int[] output = new int[a.length];
        int jaritsu = 1;
        int count = 0;
        while (count != maxSize) {
            int[] bucket = new int[10];
            for (int i = 0; i < a.length; i++) {
                bucket[(a[i] / jaritsu) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i-1];
            }
            for (int i = a.length-1; i >= 0; i--) {
                output[bucket[(a[i] / jaritsu % 10)] - 1] = a[i];
                bucket[(a[i] / jaritsu) % 10]--;
            }
            for (int i = 0; i < a.length; i++) {
                a[i] = output[i];
            }
            jaritsu *= 10;
            count++;
        }
    }



    /* 실패한 풀이, 못 풀었다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        radixSort(a);
        Arrays.stream(a)
                .forEach(System.out::println);
    }

    /* 어떻게 구현할지 감이 안집힌다. 시작은 1의 자릿수로 정렬하면 되지만 끝은 들어오는 숫자 중 가장 큰 자릿수의 수가 뭔지 어떻게 구하는게 효율적일까? 실패 * /
    private static void radixSort(int[] a) {
        Queue<Integer> q = new LinkedList<>();
        int biggestRadix = (int) Math.log10(Arrays.stream(a).max().getAsInt()) + 1;
        for (int k = 1; k <= biggestRadix; k++) {
            for (int i = 0; i < 10; i++) {
                for (int j : a) {
                    if (j % (10 * k) == i) {
                        q.offer(j);
                    }
                }
            }
        }
    }
*/
}
