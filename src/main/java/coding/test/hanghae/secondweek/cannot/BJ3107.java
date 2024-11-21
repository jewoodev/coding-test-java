package coding.test.hanghae.secondweek.cannot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ3107 {
    static String input;
    static String[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine(); // 입력 받은 문자열

        // "::" 로 된 부분은 "0000"이 연속으로 있는 부분이 압축 된 것
        // 이 부분을 ":zero:" 이 부분으로 대체해서 나중에 "0000"을 갯수만큼 넣을 것임
        if(input.contains("::")) {
            input = input.replace("::", ":zero:");
        }
        // ipArr 배열에 ":" 를 기준으로 자른 문자열을 넣음
        arr = input.split(":");

        LinkedList<String> resultList = new LinkedList<>();

        // 각 자리를 4자리로 만들어 resultList에 넣음
        for (String str : arr) {
            StringBuilder sb = new StringBuilder();
            // "::" 가 맨 앞에 있으면 그 자리는 빈 상태가 된다
            // 이 부분은 그냥 넘어감
            if (str.isEmpty()) continue;
            else sb.append(str);
            while (sb.length() < 4) {
                sb.insert(0, "0");
            }
            resultList.add(sb.toString());
        }

        // 8 자리로 만듦
        String[] answer = new String[8]; // 최종 주소값을 저장할 배열
        // "0000" 이 들어가야 할 갯수
        int replaceCnt = 8 - resultList.size() + 1;
        int idx = 0;
        for (String s : resultList) {
            // :: 를 "0000"로 필요한 만큼 채움
            if (s.equals("zero")) {
                while (replaceCnt-- > 0) {
                    answer[idx] = "0000";
                    idx++;
                }
            }
            // "0000" 가 아닌 값을 넣음
            else {
                answer[idx] = s;
                idx++;
            }
        }

        // 출력 형식을 만듦
        StringBuilder sb = new StringBuilder();
        sb.append(answer[0]);
        for (int i = 1; i < answer.length; i++) {
            sb.append(":").append(answer[i]);
        }

        System.out.println(sb);
    }

}