package coding.test.doit.data.structure.arrayandlist;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CalAvg { //p38 내 풀이
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] a = new double[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }

        double maxVal = Arrays.stream(a).max().getAsDouble();

        for (int i = 0; i < n; i++) {
            a[i] = a[i] / maxVal * 100;
        }

        double newAvg = Arrays.stream(a).average().getAsDouble();

        System.out.println("newAvg = " + newAvg);
    }
}
