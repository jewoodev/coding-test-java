package doit.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BubbleSortProgram1 { //정렬/버블 소트 프로그램1/P104
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] a = new mData[N];
        for (int i = 0; i < N; i++) {
            a[i] = new mData(Integer.parseInt(br.readLine()), i);
        } //여기까지 배열 초기화 작업을 한다.

        Arrays.sort(a); // a 배열 정렬(O(nlogn) 시간 복잡도)
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < a[i].index - i) max = a[i].index - i; //정렬 전 index - 정렬 후 index 계산의 최댓값 저장하기
        }
        System.out.println(max + 1);
    }

    static class mData implements Comparable<mData> {
        int value;
        int index;

        public mData(int value, int index) {
            super();
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(mData o) { //value 기준 오름차순 정렬
            return this.value - o.value;
        }
    }
}

/**
 * 풀이법 설명을 보고 구현해보려 해도 정렬 전, 후의 인덱스의 이동량의 최대를 어떻게 계산할지 갈피를 못잡았던 문제
 */
//public class BubbleSortProgram1 { //정렬/버블 소트 프로그램1/P104
//    public static void Main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] a = new int[N];
//        for (int i = 0; i < N; i++) {
//            a[i] = Integer.parseInt(br.readLine());
//        } //여기까지 배열 초기화 작업을 한다.
//
//        //버블 정렬을 시작한다.
//        boolean change = false;
//        for (int i = 1; i < N; i++) {
//            for (int j = i; j < N; j++) {
//                if (a[j] < a[j - 1]) {
//                    change = true;
//                    swap(a, j, j-1);
//                }
//            }
//            if (change == false) {
//                break;
//            }
//        }
//        System.out.println(a[N - 1]);
//    }
//
//    private static void swap(int[] a, int i, int j) {
//        int temp = a[i];
//         a[i] = a[j];
//         a[j] = temp;
//    }
//}
