package coding.test.backjoon.bronze;

import java.io.*;
import java.util.*;

public class Aliquot { // https://www.acmicpc.net/problem/1037, 수학
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] aliquotArr = new int[num];
        for (int i = 0; i < num; i++) {
            aliquotArr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(aliquotArr[0] * aliquotArr[num - 1]);
    }
}