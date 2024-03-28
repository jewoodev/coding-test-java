package doit.sort;

import java.util.Scanner;

public class SortDigitPlaceDesc { //선택 정렬/P109 내림차순으로 자릿수 정렬하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] a = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            a[i] = Integer.parseInt(str.substring(i, i+1));
        }
        for (int i = 0; i < str.length(); i++) {
            int max = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (a[j] > a[max]) max = j; //내림차순이므로 최댓값을 찾음
            }
            if (a[i] < a[max]) {
                int temp = a[i];
                a[i] = a[max];
                a[max] = temp;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.print(a[i]);
        }
    }

    /**
     * 문자열을 인덱싱해서 int 배열로 만들어 sort() 한 후에 출력하려고 했는데, 문자열 인덱싱에서 막힘.
     */
//    public static void Main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer("");
//        int[] N = new int[];
//        int length = input.length();
//
//        for (int i = 0; i < length; i++) {
//            N[i] = Integer.parseInt(input.codePointAt(i));
//        }
//        Arrays.sort(N);
//        StringBuilder sb = new StringBuilder();
//        for (int i : N) {
//            sb.append(i);
//        }
//        System.out.println(sb.toString());
//    }
}
