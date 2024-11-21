package coding.test.doit.data.structure.slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DnaPassword { //슬라이딩 윈도우/P67 DNA 비밀번호
    /* 책의 풀이 */

    private static int checkArr[], myArr[], checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); //S는 문자열의 크기
        int P = Integer.parseInt(st.nextToken()); //P는 부분 문자열의 크기
        int Result = 0; //Result는 유효 비밀번호의 갯수
        char[] A = new char[S]; //DNA 문자열
        A = br.readLine().toCharArray(); //입력
        checkArr = new int[4]; //checkArr는 비밀번호 체크 배열
        myArr = new int[4]; //myArr는 현재 상태 배열
        checkSecret = 0; //checkSecret은 최소 갯수를 만족하는 비밀번호의 문자 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken()); //비밀번호 체크 배열 입력
            if (checkArr[i] == 0) checkSecret++; //최소 갯수가 0이면 바로 조건을 만족한다.
        }

        for (int i = 0; i < P; i++) { //초기 부분 문자열의 처리
            Add(A[i]);
        }
        if (checkSecret == 4) Result++;

        //슬라이딩 윈도우 처리
        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) Result++; //4자릿수와 관련된 크기가 모두 충족될 때 유효한 비밀번호
        }
        System.out.println(Result);
        br.close();
    }


    private static void Add(char c) { //새로 들어온 문자를 처리하는 함수
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }

    private static void Remove(char c) { //제거되는 문자를 처리하는 함수
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }
}


    /* 구현할 엄두도 내지 못한 문제
    * 손으로 풀어보기 2번까지 보고 꽤 긴 시간 디버깅해서 답은 구했지만 시간 복잡도를 만족시키지 못했다.*/
/*
    public static void Main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //n은 DNA 문자열의 길이
        int p = Integer.parseInt(st.nextToken()); //p는 부분 문자열의 길이
        char[] s = br.readLine().toCharArray(); //s는 DNA 문자열, 문자열 저장
        st = new StringTokenizer(br.readLine());
        int[] check = new int[4]; //check는 비밀번호 체크 배열
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }
        int ct = n - p; //ct는 윈도우가 이동할 횟수
        int cnt = 0; //cnt는 유효한 비밀번호 갯수
        for (int i = 0; i <= ct; i++) {
            int[] now = new int[4]; //now는 현재 상태 배열
            for (int j = i; j < p + i; j++) {
                switch (s[j]){
                    case 'A':
                        now[0]++;
                        break;
                    case 'C':
                        now[1]++;
                        break;
                    case 'G':
                        now[2]++;
                        break;
                    case 'T':
                        now[3]++;
                        break;
                }
            }
            boolean isValid = false;
            for (int j = 0; j < 4; j++) {
                if (now[j] >= check[j]) isValid = true;
                else {
                    isValid = false;
                    break;
                }
            }
            if (isValid) cnt++;
        }
        System.out.println(cnt);
    }
*/

