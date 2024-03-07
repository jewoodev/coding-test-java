package doit.data.structure.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MakeAscWithStack { //스택과 큐/P81/문제11. 스택으로 오름차순 수열 만들기
    /* 문제를 이해하지 못했다. */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1; //오름차순 수
        boolean result = true;
        for (int i = 0; i <a.length; i++) {
            int su = a[i]; //현재 수열의 수
            if (su >= num) { //현재 수열 값 >= 오름차순 자연수: 값이 같아질 때까지 push() 수행
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else { //현재 수열 값 < 오름차순 자연수: pop()을 수행해 수열 원소를 꺼냄
                int p = stack.pop();
                //스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음
                if (p > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }

        }
        if (result) System.out.println(bf);
    }
}
