package coding.test.thisis.dynamic.failed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AntWarrior {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] storage = new int[n];

        for (int i = 0; i < n; i++) {
            storage[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i += 2) {
            
        }
    }
}
