package hanghae.day2.fail;

import java.util.ArrayList;
import java.util.List;

//큰 수 만들기
public class MakeBigNum {

    private static String[] arr;
    private static List<String> all;
    private static boolean[] visited;

    public static void main(String[] args) {

    }

    private static String solution(String number, int k) {
        String answer = "";
        int inputLength = number.length();
        arr = new String[inputLength];
        all = new ArrayList<>();
        visited = new boolean[9_999_999];
        for (int i = 0; i < inputLength; i++) {
            arr[i] = number.substring(i,i);
        }
        StringBuilder sb;
        dfs(arr, "", k);

        return answer;
    }

    private static void dfs(String[] arr, String start, int depth) {
        for (int i = 0; i < arr.length; i++) {
            String thisTurn = start + arr[i];
            int idx = Integer.parseInt(thisTurn);
            if (!visited[idx]) {
                visited[idx] = true;
                all.add(String.valueOf(thisTurn));
                dfs(arr, thisTurn, 0);
            }
        }
    }
}
