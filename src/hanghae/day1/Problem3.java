package hanghae.day1;

import java.util.ArrayList;
import java.util.List;

public class Problem3 { //모음사전 https://school.programmers.co.kr/learn/courses/30/lessons/84512
    private static String[] a = {"A", "E", "I", "O", "U"};
    private static List<String> all;
    public int solution(String word) {
        int answer = 0;
        all = new ArrayList<>();
        recursion(word, "", 0);

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    static void recursion(String word, String str, int depth) {
        all.add(str);
        if (depth == 5) return;
        for (String s : a) {
            recursion(word, str + s, depth + 1);
        }
    }
}
