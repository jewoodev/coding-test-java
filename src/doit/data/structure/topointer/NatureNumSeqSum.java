package doit.data.structure.topointer;

import java.util.Scanner;

public class NatureNumSeqSum {
    /**
     * 시간 제한 2초, 입력값 최대 10,000,000 -> O(n)
     */
    public static void main(String[] args) { //p56
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int start_idx = 1;
        int end_idx = 1;
        int sum = 1;

        while (end_idx != n) {
            if (sum == n) {
                count++;
                end_idx++;
                sum -= start_idx;
                start_idx++;
                sum += end_idx;
            } else if (sum > n) {
                sum -= start_idx;
                start_idx++;
            } else {
                end_idx++;
                sum += end_idx;
            }
        }
        System.out.println(count);
    }
}
