package coding.test.backjoon.bronze;

import java.io.*;

class DigitalTv {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int idx = 0; // 커서가 위치한 칸 번호
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            if (arr[i].equals("KBS1")) {
                for (; idx < i; idx++) {
                    sb.append("1"); // KBS1 위치까지 칸 수 이동
                }
                while (!arr[0].equals("KBS1")) {
                    var temp = arr[idx - 1];
                    arr[idx - 1] = arr[idx];
                    arr[idx--] = temp;
                    sb.append("4");
                }
            }
        }

        while (++idx < n) {
            sb.append("1"); // KBS2 위치까지 칸 수 이동
            if (arr[idx].equals("KBS2")) {
                while (!arr[1].equals("KBS2")) {
                    var temp = arr[idx - 1];
                    arr[idx - 1] = arr[idx];
                    arr[idx--] = temp;
                    sb.append("4");
                }
                break;
            }
        }

        System.out.print(sb);
    }
}
