package doit.sort;

import java.io.*;

public class SortNum2 { //병합 정렬/P128 수 정렬하기2
    private static int[] a, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        a = new int[N]; tmp = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0, N-1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : a) {
            bw.write(i + "\n");
        }
        br.close();
        bw.close();
    }

    private static void mergeSort(int s, int e) {
        if (e - s < 1) return;
        int m = s + (e - s) / 2;
        //재귀 함수로 구현
        mergeSort(s, m);
        mergeSort(m + 1, e);
        for (int i = s; i <= e; i++) {
            tmp[i] = a[i];
        }
        int k = s; //정렬 연산의 결과를 반영할 포인터
        int idx1 = s; //첫 구간을 가리키는 포인터
        int idx2 = m + 1; //다음 구간을 가리키는 포인터
        while (idx1 <= m && idx2 <= e) { //두 그룹을 병합하는 로직
            //양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고,
            //선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
            if (tmp[idx1] > tmp[idx2]) {
                a[k] = tmp[idx2];
                k++;
                idx2++;
            } else {
                a[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }
        while (idx1 <= m) { //한쪽 그룹이 모두 선택된 후 남아 있는 값 정리하기
            a[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while (idx2 <= e) {
            a[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }

    /* 병합 정렬 구현을 어떻게 해야할지 모르겠어서 못 푼 문제, 근데 이전에 푼 풀이가 아래에 있다. 병합 정렬한거 같진 않다. */
/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (num[j] > num [j+1]) {
                    int tmp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = tmp;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i : num) {
            sb.append(i).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
*/
}
