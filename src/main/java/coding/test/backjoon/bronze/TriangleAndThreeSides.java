package coding.test.backjoon.bronze;

import java.io.*;
import java.util.*;

class TriangleAndThreeSides {
    public String solution(String input) {
        var st = new StringTokenizer(input);

        int[] sides = new int[3];
        var set = new HashSet<Integer>();
        for (int i = 0; i < 3; i++) {
            var s = Integer.parseInt(st.nextToken());
            sides[i] = s;
            set.add(s);
        }


        Arrays.sort(sides);
        if (sides[2] >= sides[0] + sides[1]) {
            return "Invalid";
        }

        if (set.size() == 1) return "Equilateral";
        if (set.size() == 2) return "Isosceles";
        if (set.size() == 3) return "Scalene";
        else return "Impossible";
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();

        while (true) {
            var st = new StringTokenizer(br.readLine());

            int[] sides = new int[3];
            var set = new HashSet<Integer>();
            boolean flag = false;
            for (int i = 0; i < 3; i++) {
                var s = Integer.parseInt(st.nextToken());

                if (s == 0) {
                    flag = true;
                    break;
                }

                sides[i] = s;
                set.add(s);
            }
            if (flag) break;

            Arrays.sort(sides);
            if (sides[2] >= sides[0] + sides[1]) {
                sb.append("Invalid").append("\n");
                continue;
            }

            if (set.size() == 1) {
                sb.append("Equilateral").append("\n");
            }
            else if (set.size() == 2) {
                sb.append("Isosceles").append("\n");
            }
            else {
                sb.append("Scalene").append("\n");
            }
        }

        System.out.print(sb);
    }
}
