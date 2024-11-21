package coding.test.thisis.binarysearch;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SearchLyrics {
    public static void main(String[] args) throws IOException {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
//        int[] answer = solution(words, queries);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        bw.write(Arrays.toString(answer));
        bw.close();
    }

//    private static int[] solution(String[] lyrics, String[] queries) {
//        for (String s : queries) {
//
//        }
//    }
}
