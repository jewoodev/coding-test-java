package coding.test.hanghae.thirdweek.failed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
# 요구사항 정리 #
1. 기둥 높이가 N개 주어진다. 지붕의 어떤 부분도 오목한 부분이 없게 만들어야 한다.
2. 주어지는 기둥 높이로 만들 수 있는 최소 크기의 창고를 구하라

# 풀이 논리 #
1. 주어지는 기둥의 위치 값을 멤버 변수 x(수평 위치), y(기둥 높이)를 갖는 Pillar 객체를 만든다.
2. 높이 순으로 정렬을 한 후에 좌우를 탐색했을 때 좌우에서 다음으로 높이가 큰 기둥에 맞춰 지붕을 만든다.
3. 지붕이 오목해지지 않도록 두 기둥 사이에 두 기둥 높이보다 작은 기둥이 있다면 두 기둥 중 더 작은 기둥을 기준으로 지붕 높이를 맞춘다.
*/

class BJ2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Pillar> list = new ArrayList<Pillar>(); // 기둥 배열
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Pillar(x, y));
        }
        Collections.sort(list, (p1, p2) -> p2.y - p1.y);
        for (int i = 0; i < N - 1; i++) {
            for (int j = 2; j < N; j++) {
                if (list.get(i).x < list.get(i + 1).x)
                    if (list.get(i).x < list.get(j).x && list.get(j).x < list.get(i + 1).x)
                        list.remove(j);
                else
                    if (list.get(i + 1).x < list.get(j).x && list.get(j).x < list.get(i).x)
                        list.remove(j);
            }
        }

    }

    private static class Pillar {
        int x, y;
        private Pillar(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}