package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

class Muster {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();
        int bits = 0;

        int x = Integer.parseInt(br.readLine());

        for (int i = 0; i < x; i++) {
            String[] line = br.readLine().split(" ");
            var cmd = line[0];
            int num = line.length == 2 ? Integer.parseInt(line[1]) : 0;

            if (cmd.equals("add")) {
                bits |= (1 << num);
            } else if (cmd.equals("remove")) {
                bits &= ~(1 << num);
            } else if (cmd.equals("check")) {
                if ((bits & (1 << num)) != 0) {
                    sb.append("1\n");
                } else sb.append("0\n");
            } else if (cmd.equals("toggle")) {
                bits ^= (1 << num);
            } else if (cmd.equals("all")) {
                bits = (1 << 21) - 1;
            } else {
                bits = 0;
            }
        }
        System.out.print(sb);
    }
}
