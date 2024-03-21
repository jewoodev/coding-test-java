package doit.graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class IDontWannaBeLiar {
    private static int[] parent;
    private static int[] trueP;
    private static ArrayList<Integer>[] party;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //사람 수
        int m = Integer.parseInt(st.nextToken()); //파티 개수
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken()); //진실을 아는 사람 수
        result = 0;
        trueP = new int[t]; //진실을 아는 사람 데이터
        for (int i = 0; i < t; i++) { //진실을 아는 사람 저장하기
            trueP[i] = Integer.parseInt(st.nextToken());
        }
        party = new ArrayList[m];
        for (int i = 0; i < m; i++) { //파티 데이터 저장하기
            party[i] = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partySize; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i; //대표 노드를 자기 자신으로 초기화하기
        }
        for (int i = 0; i < m; i++) { //각 파티에 참여한 사람들을 1개의 그룹으로 만들기
            int firstPerson = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(firstPerson, party[i].get(j));
            }
        }
        for (int i = 0; i < m; i++) { //각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없다
            boolean isPossible = true;
            int cur = party[i].get(0);
            for (int j = 0; j < trueP.length; j++) {
                if (find(cur) == find(trueP[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) result++;
        }
        System.out.println(result);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

//    private static boolean checkSame(int a, int b) {
////        a = find(a);
////        b = find(b);
////        return a == b;
////    }
}
