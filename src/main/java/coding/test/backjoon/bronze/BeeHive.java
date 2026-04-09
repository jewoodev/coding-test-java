package coding.test.backjoon.bronze;

import java.util.*;

class BeeHive {
    public static void main(String[] args) {
        var target = new Scanner(System.in).nextInt();

        if (target == 1) {
            System.out.println(1);
            return;
        }

        int layer = 1;
        int nums = 6;
        int start = 2;

        while (true) {
            int end = start + (nums * layer++);

            if (target >= start && target < end) {
                break;
            }

            start = end;
        }

        System.out.println(layer);
    }
}
