package doit.data.structure.arrayandlist;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CalAvg2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp > max) max = temp;
            sum += temp;
        }

        System.out.println("result = " + (sum * 100.0 / max / n));
    }
}
