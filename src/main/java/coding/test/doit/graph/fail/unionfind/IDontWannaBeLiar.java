package coding.test.doit.graph.fail.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* P291 문제 52, 백준 1043번. 거짓말쟁이가 되긴 싫어 */
public class IDontWannaBeLiar {
    private static int[] g;
    private static boolean[] knowArr;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //사람 수
        int p = Integer.parseInt(st.nextToken()); //파티 수
        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken()); //진실을 아는 사람 수
        g = new int[n + 1]; //그룹핑 배열
        for (int i = 1; i < n + 1; i++) {
            g[i] = i;
        }
        //진실을 아는 사람을 식별할 배열
        knowArr = new boolean[n + 1];
        for (int i = 0; i < knowCnt; i++) {
            int knowN = Integer.parseInt(st.nextToken());
            knowArr[knowN] = true; //두 번째 라인에서 주어지는 진실을 아는 사람 저장
        }
        ArrayList<Integer>[] partyGraph = new ArrayList[p]; //
        for (int i = 0; i < p; i++) {
            partyGraph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            partyGraph[i].add(Integer.parseInt(st.nextToken()));
        }
        for (ArrayList<Integer> a : partyGraph) {
            if (a.size() == 1) {
                discernPossibilityWithSingle(find(a.get(0)));
            } else {
                discernPossibilityWithMultiple(a);
            }
        }
        System.out.println(answer);
    }

    private static int find(int i) {
        if (g[i] == i) return i;
        else return g[i] = find(g[i]);
    }

    private static void discernPossibilityWithSingle(int i) {
        if (!knowArr[i]) answer++;
    }

    private static void discernPossibilityWithMultiple(ArrayList<Integer> a) {
        for (int i = 1; i < a.size() + 1; i++) {
            union(i, i + 1);
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) g[b] = g[a];
            else g[a] = g[b];
        }
    }
}
