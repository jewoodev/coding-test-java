package hanghae.secondWeek;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int[] alpha = new int[26];
        for (int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i) - 'A';
            alpha[idx]++;
        }
        int odd = 0;
        for (int i = 0; i < alpha.length; i++)
            if (alpha[i] % 2 != 0) odd++;

        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        if (odd > 1) {
            System.out.print("I'm Sorry Hansoo");
            return;
        }
        else {
            for (int i = 0; i < alpha.length; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    sb.append((char) (i+65));
                }
            }
            answer.append(sb.toString());
            String end = sb.reverse().toString();
            sb = new StringBuilder();
            for (int i = 0; i < alpha.length; i++) {
                if (alpha[i] % 2 == 1)
                    sb.append((char) (i+65));
            }
            answer.append(sb.append(end));
        }
        System.out.print(answer);
    }
}