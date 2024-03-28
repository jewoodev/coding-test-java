package doit.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GetNumOfNth { //퀵 정렬/P121 K번째 수 구하기
    private static int n;
    private static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //n은 주어지는 수의 개수
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); //k는 구해야할 수는 몇번째인지에 대한 값

        st = new StringTokenizer(br.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        } //정렬할 수를 담은 배열
        quickSort(0, n - 1, k - 1);
        System.out.println(a[k - 1]);
    }

    /**
     * 퀵 정렬 메서드
     *
     * @param s : 퀵 정렬의 시작점(인덱스)
     * @param e : 퀵 정렬의 종료점(인덱스)
     * @param k : 구하려는 값의 인덱스
     */
    private static void quickSort(int s, int e, int k) {
        if (s < e) {
            int pivot = partition(s, e);
            if (pivot == k) return;
            else if (k < pivot) quickSort(s, pivot -1, k);
            else quickSort(pivot + 1, e, k);
        }
    }

    private static int partition(int s, int e) {
        if (s + 1 == e) {
            if (a[s] > a[e]) swap(s, e);
            return e;
        }
        int m = (s + e) / 2;
        swap(s, m); //중앙값을 1번째 요소와 swap
        int pivot = a[s];
        int i = s + 1, j = e;
        while (i <= j) {
            while (j >= s + 1 && pivot < a[j]) j--; //피벗보다 작은 수가 나올 때까지 j--
            while (i <= e && pivot > a[i]) i++; //피벗보다 큰 수가 나올 때까지 i++
            if (i <= j) swap(i++, j--);
        }
        //피벗 데이터를 나눠진 두 그룹의 경계 index에 저장하기
        a[s] = a[j];
        a[j] = pivot;
        return j;
    }

    /**
     * 두 인덱스의 요소의 값을 스왑해주는 메서드
     * @param i : 바뀔 인덱스
     * @param j : 바뀔 인덱스
     */
    private static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

//    private static void quickSort(int s, int e, int k) {
//        int pIdx = getPivotIdx(a);
//        while (s < e) {
//            if (a[s] < a[pIdx]) {
//                swap(a[s], a[s+1]);
//                s++;
//            }
//            if (a[e] > a[pIdx]) {
//                swap(a[e], a[e-1]);
//                e--;
//            }
//        }
//    }

//    private static int getPivotIdx(int[] a) {
//        return a.length / 2;
//    }


    /* 피벗 정렬 구현 시도 중에 start 요소와 end 요소가 만나는 지점에서 행해져야 하는 연산을 구현하지 못한 문제. */
    /*
    private static int n;
    private static int[] a;

    public static void Main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //n은 주어지는 수의 개수
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); //k는 구해야할 수는 몇번째인지에 대한 값

        st = new StringTokenizer(br.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        } //정렬할 수를 담은 배열

        quickSort(a);
    }

    public static void quickSort(int[] intArr) {
        for (int i = 0; i < n - 1; i++) {
            int pivot = intArr[n - 1];
            while (true) {
                if (intArr[i] < pivot) swap(intArr[i], intArr[i+1]);
                if (intArr[n-1-i] > pivot) swap(intArr[n-1-i], intArr[n-2-i]);
                if ()
            }
        }
    }

    private static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    */

    /*
    === 슈도 코드 ===
    N(숫자의 갯수) K(K번째 수)
    A(숫자 데이터 저장 배열)
    for(N만큼 반복하기) {
        A 배열 저장하기
    }
    퀵 소트 실행하기
    K번째 데이터 출력하기

    [별도의 함수 구현 부분]
    퀵 소트 함수(시작, 종료, K) {
        피벗 구하기 함수(시작, 종료)
        if (피벗 == K) 종료
        else if (K < 피벗) 퀵 소트 수행하기(시작, 피벗 - 1, K)
        else 퀵 소트 수행하기(피벗 + 1, 종료, K)
    }
    피벗 구하기 함수(시작, 종료) {
        데이터가 2개인 경우는  바로 비교하여 정렬
        M(중앙값)
        중앙값을 시작 위치와 swap
        pivot을 시작 위치 값 A[S(시작)]로 지정
        i(시작점), j(종료점)
        while(i <= j) {
            피벗보다 큰 수가 나올 때까지 i++
            피벗보다 작은 수가 나올 때까지 j++
            찾은 i와 j 데이터를 swap
        }
        피벗 데이터를 나눠진 두 그룹의 경계 index에 저장하기
        경계 index 리턴
    }
    */
}
