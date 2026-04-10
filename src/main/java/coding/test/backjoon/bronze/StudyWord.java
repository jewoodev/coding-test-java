package coding.test.backjoon.bronze;

import java.util.*;

class StudyWord {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var input = sc.nextLine();

        int[] cnt = new int[26];

        int maxIdx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                int j = c - 'A';
                if (++cnt[j] > max) {
                    maxIdx = j;
                    max = cnt[maxIdx];
                }
            } else {
                int j = c - 'a';
                if (++cnt[j] > max) {
                    maxIdx = j;
                    max = cnt[maxIdx];
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] == max && maxIdx != i) {
                System.out.println("?");
                return;
            }
            else if (cnt[i] > max) {
                maxIdx = i;
                max = cnt[i];
            }
        }

        System.out.println((char) (maxIdx + 'A'));
    }
}
