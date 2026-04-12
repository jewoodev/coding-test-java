package coding.test.backjoon.silver;

import java.util.*;

class StoneGame {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n % 2 == 0) System.out.print("CY");
        else System.out.print("SK");
    }
}
