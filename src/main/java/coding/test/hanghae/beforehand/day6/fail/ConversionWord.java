package coding.test.hanghae.beforehand.day6.fail;

//단어 변환
public class ConversionWord {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (isConvertable(target, words)) {
            for (int i = 0; i < words.length; i++) {
                if (isOneCharDiff(words[i], target)) return i + 2;
            }
        } else {
            return 0;
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
