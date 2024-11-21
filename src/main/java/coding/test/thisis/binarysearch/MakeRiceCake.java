package coding.test.thisis.binarysearch;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MakeRiceCake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeSet<Integer> treeSet = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        int max;
        TreeSet<Integer> treeSet2 = (TreeSet<Integer>) treeSet.clone();
        for (int i = 0; i < treeSet.pollLast(); i++) {

        }
        while (treeSet2.higher(m) != null) {
            int a = treeSet.higher(m);
            answer += a % m;
            treeSet.remove(a);
            
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
