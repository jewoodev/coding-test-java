package doit.number.theory;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MakeCocktail {
    /* 어떻게 푸는 건지 모르겠다. 비율 한 쪽이 항상 1로 주어지면 간단한데 그런 조건이 없어서 방법을 못찾겠다 */
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ratio = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int materialNum1 = Integer.parseInt(st.nextToken());
            int materialNum2 = Integer.parseInt(st.nextToken());
            int m1Cnt = Integer.parseInt(st.nextToken());
            int m2Cnt = Integer.parseInt(st.nextToken());
            ratio[materialNum1] =
        }

    }
    */

    /* 책의 풀이, 레전드 문제로 느껴진다 */
    static ArrayList<cNode>[] al;
    static long lcm;
    static boolean visited[];
    static long d[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); //재료 개수
        al = new ArrayList[n]; //인접 리스트
        visited = new boolean[n]; //dfs 탐색 여부 저장 배열
        d = new long[n]; //각 노드 값 저장 배열
        lcm = 1; //최소공배수
        for (int i = 0; i < n; i++) {
            al[i] = new ArrayList<cNode>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            al[a].add(new cNode(b, p, q));
            al[b].add(new cNode(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }
        d[0] = lcm;
        dfs(0);
        long mgcd = d[0];
        for (int i = 1; i < n; i++) {
            mgcd = gcd(mgcd, d[i]);
        }
        for (int i = 0; i < n; i++) {
            bw.write(d[i] / mgcd + " ");
        }
        bw.close();
        br.close();
    }

    private static long gcd(long a, long b) { /* 최대공약수 구하는 메서드 */
        if (b == 0) return a;
        else {
            return gcd(b, a % b);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (cNode i : al[node]) {
            int next = i.getB();
            if (!visited[next]) {
                d[next] = d[node] * i.getQ() / i.getP();
                dfs(next);
            }
        }
    }

    private static class cNode {
        int b; //비율을 계산하는 상대 노드 번호
        int p; //자신(인덱스 번호 노드)의 비율
        int q; //상대 노드의 비율

        public cNode(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
}
