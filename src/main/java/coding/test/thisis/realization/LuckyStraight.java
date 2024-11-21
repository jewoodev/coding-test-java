package coding.test.thisis.realization;

import java.util.Scanner;

public class LuckyStraight { //p321
    static enum Status {
        LUCKY, READY
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] ca = input.toCharArray();
        int itv = ca.length / 2;
        int prev = 0;
        int subseq = 0;
        Status result;

        for (int i = 0; i < itv; i++) {
            prev += ca[i];
        }
        for (int j = itv; j < ca.length; j++) {
            subseq += ca[j];
        }
        if (prev == subseq) result = Status.LUCKY;
        else result = Status.READY;

        System.out.println(result);
    }
}
