package doit.data.structure.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class GetOkenNum { //스택과 큐/P86/문제12. 오큰수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //n은 수열의 원소 갯수
        int[] a = new int[n]; //a는 수열 배열
        int[] ans = new int[n]; //ans는 정답 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> myStack = new Stack<>();
        myStack.push(0); //연산을 위해 빈 스택에 최초 값을 세팅
        for (int i = 1; i < n; i++) {
            //현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
            while (!myStack.empty() && a[myStack.peek()] < a[i]) {
                ans[myStack.pop()] = a[i]; //정답 배열에 오큰수를 현재 수열로 저장하기
            }
            myStack.push(i); //신규 데이터 push
        }
        //반복문 수행 후인데도 스택이 비어있지 않다면
        while (!myStack.empty()) {
            ans[myStack.pop()] = -1; //스택에 쌓인 index에 -1을 넣고
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    /* 아이디어를 생각해내지 못하고 해매다가 책의 핵심아이디어까지 보고 다시 시도 */
/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //n은 수열의 원소 갯수
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }
    }
*/

    /* 이번 시도도 실패 */
/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //n은 수열의 원소 갯수
        Stack<Element> okenSeq = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int newVal = Integer.parseInt(st.nextToken());
            pushToOkenSeq(okenSeq, newVal);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(okenSeq.pop().oken + " ");
        }
        System.out.println(sb);
    }

    private static void pushToOkenSeq(Stack<Element> okenSeq, int newVal) {
        Element topElem = okenSeq.empty() ? null : okenSeq.peek();
        okenSeq.push(new Element(newVal, -1));
        if (topElem != null && topElem.val < newVal) topElem.oken = newVal;
    }

    private static class Element {
        int val;
        int oken;

        public Element(int val, int oken) {
            this.val = val;
            this.oken = oken;
        }
    }
*/
}
