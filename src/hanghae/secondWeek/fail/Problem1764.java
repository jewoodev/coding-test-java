package hanghae.secondWeek.fail;

import java.io.*;
import java.util.*;

class Problem1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        PriorityQueue<String> xx = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            set1.add(br.readLine());
        for (int i = 0; i < n; i++)
            set2.add(br.readLine());
        for (String s : set1)
            if (set2.contains(s)) xx.offer(s);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(xx.size() + "\n");
        for (String s : xx)
            bw.write(s + "\n");
        br.close();
        bw.close();
    }
}