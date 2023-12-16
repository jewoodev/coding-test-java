package thisis.binarysearch;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class FindComponent {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.valueOf(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            if (treeSet.contains(Integer.parseInt(st.nextToken()))) {
                bw.write("yes ");
            } else bw.write("no ");
        }
        bw.close();
        br.close();
    }
}
