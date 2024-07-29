package hanghae.forthweek.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
# 요구사항 정리 #
1. 첫 줄에 N, M, K 가 주어진다.
2. 둘째 줄부터 M개의 줄에 파이어볼 정보가 한 줄에 하나씩 주어진다.
3. K 번 이동 후 남아있는 파이어볼의 질량의 합을 구하라.

# 풀이 논리 #
1.

*/

class BJ20056 {
    private static int N, M, K;
    private static int[] dR = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dC = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 격자의 한 변의 길이
        M = Integer.parseInt(st.nextToken()); // 파이어볼 개수
        K = Integer.parseInt((st.nextToken())); // 이동 횟수
        Queue<Fireball> q = new LinkedList<>(); // 파이어볼을 저장할 큐
        // 같은 좌표에 여러 개 모이게 되는 파이어볼을 체크하기 위한 맵
        Map<int[], List<int[]>> map = new HashMap<>(); // 좌표를 키, (질량, 이동량, 방향)을 갖는 리스트를 Value로 갖는 맵

        // 각 파이어볼을 저장
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1; // 위치
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken()); // 질량
            int s = Integer.parseInt(st.nextToken()); // 이동량
            int d = Integer.parseInt(st.nextToken()); // 방향
            q.offer(new Fireball(r, c, m, s, d));
        }

        /* 이동 로직 시작 */
        for (int i = 0; i < K; i++) {
            while (!q.isEmpty()) {
                // 파이어볼 이동 로직
                Fireball f = q.poll();
                int nR = (N + f.r + dR[f.dir] * (f.move % N)) % N;
                int nC = (N + f.c + dC[f.dir] * (f.move % N)) % N;
//                q.offer(new Fireball(nR, nC, f.mass, f.move, f.dir));
                int[] mapKey = new int[] {nR, nC};
                List mapVal = map.getOrDefault(mapKey, new ArrayList<>());
                mapVal.add(new int[] {f.mass, f.move, f.dir});
                map.put(mapKey, mapVal);
            }

            // 파이어볼 합치는 로직
            for (int[] key : map.keySet()) {
                if (map.get(key).size() >= 2) { // 두 개 이상 위치한 것인지 확인
                    int totalMass = 0;
                    int totalMove = 0;
                    boolean totalDir = false;
                    int totalCnt = 0;
                    for (int[] val : map.get(key)) {
                        totalMass += val[0];
                        totalMove += val[1];
                        totalDir = val[2] % 2 == 0;
                        totalCnt++;
                    }
                    if (totalMass == 0) continue;
                    int resultMass = totalMass / 5;
                    int resultMove = totalMove / totalCnt;
                    int resultDir = totalDir ? 0 : 1;
                    q.offer(new Fireball(key[0], key[1], resultMass, resultMove, resultDir));
                }
                else {
                    int[] val = map.get(key).get(0);
                    q.offer(new Fireball(key[0], key[1], val[0], val[1], val[2]));
                }
            }
            map.clear();
        }

        // K 번 명령이 이루어진 후 남은 파이어볼의 총량
        int answer = 0;
        while (!q.isEmpty()) {
            Fireball f = q.poll();
            answer += f.mass;
        }
        System.out.println(answer);
    }

    private static class Fireball {
        int r, c; // 좌표
        int mass, move, dir; // 질량, 이동값, 방향
        private Fireball(int r, int c, int mass, int move, int dir) {
            this.r = r;
            this.c = c;
            this.mass = mass;
            this.move = move;
            this.dir = dir;
        }
    }
}