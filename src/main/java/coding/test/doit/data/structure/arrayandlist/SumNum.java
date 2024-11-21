package coding.test.doit.data.structure.arrayandlist;

import java.io.IOException;
import java.util.Scanner;

public class SumNum { //p35

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();

        int sum = 0;

        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0'; // cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적하기
        }
        System.out.println(sum);
    }
}
