package hanghae.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack();
        int result = 0;
        for (int j = 0; j < i; j++) {
            int seq = Integer.parseInt(br.readLine());
            if (seq == 0) {
                result -= stack.pop();
            } else {
                result += seq;
                stack.push(seq);
            }
        }
        System.out.println(result);
    }
}
