package coding.test.hanghae.beforehand.day6;

import java.util.LinkedList;
import java.util.Queue;

//단어 변환
public class ConversionWord {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        if (!isConvertable(target, words)) return 0;

        q.offer(begin);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String current = q.poll();
                if (current.equals(target)) return answer;
                for (int j = 0; j < words.length; j++) {
                    if (!visited[j] && isOneCharDiff(current, words[j])) {
                        visited[j] = true;
                        q.offer(words[j]);
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    private boolean isOneCharDiff(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int diffCnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
                if (diffCnt > 1) return false;
            }
        }
        return true;
    }

    private boolean isConvertable(String target, String[] words) {
        for (String word : words)
            if (target.equals(word)) return true;
        return false;
    }
}
