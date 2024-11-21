package coding.test.hanghae.thirdweek.failed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
입력값 정수 N 이 주어지고 N개의 숫자가 주어지는데, 각각이 풍선이며 순서대로 1번 ~ N번 풍선이라는 설정이다.
각 풍선 안에 주어진 숫자가 들어가 있다.
1번 풍선과 N번 풍선은 이어져 있다. 즉, 원형으로 세워져 있다.
1번을 터트리고 나온 번호만큼 이동해서 터트리는 것을 반복한다. 터진 순서대로 풍선의 번호를 나열하라.
=======================================================
1. 원형으로 구현된 리스트 써본 적이 없어서 그냥 ArrayList랑 while로 구현하려고 했는데 문제에서 이동한 다음 터트려서 이걸 구현하려면 재귀를 써야 하나 싶다.
2. 재귀로 풀어보려 했는데 이 방식도 구현할 길이 바로 보이지 않는다. 구현 방식을 좀 비틀어야 할 것 같다. 좀 지금과는 다르게 해야 한다.

다시 정리해보자.
예제의 터지는 순서를 봐보자.
1. 3(1) 2(2) 1(3) -3(4) -1(5) -> 1번 풍선(3)을 list에서 삭제하기 전의 list에서 3을 이동해야 한다. 그래서 -3이 다음 풍선이 된다. 4번 풍선을 찾고 나서 삭제한다.
2. 2(2) 1(3) -3(4) -1(5) -> 이제 4번 풍선을 터트려야 하는데 터트리기 전의 list에서 -3을 이동해야 한다. 그래서 5번 풍선이 된다.
3. 2(2) 1(3) -1(5)
4. 2(2) 1(3)
5.
*/

class BJ2346 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력값 정수 N
        List<Balloon> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) { // 풍선 정보 저장
            list.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        int idx = 0; // 현재 위치
        int nIdx = 0; // 터뜨리기 전에 찾을 위치
        Balloon b = list.get(idx);
        while (true){
            sb.append(b.num).append(" "); // 터트릴 풍선의 번호를 나열하고
            nIdx = idx + b.move; // 다음 풍선의 위치를 찾은 후
            // 찾은 위치가 범위를 벗어나지 않으면
            if (nIdx >= 0 && nIdx < list.size()) {
                idx = nIdx; // 그대로 풍선 안의 숫자를 만큼 이동한다.
            } else { // 벗어나면
                if (nIdx < 0) { // 그 중에 음수로 벗어나면
                    idx = nIdx + list.size(); // 끝으로 넘어간다.
                } else if (nIdx >= list.size()) { //그 중에 양수로 벗어나면
                    idx = nIdx - list.size(); // 앞으로 넘어간다.
                }
            }
            b = list.get(idx);
            list.remove(idx); // 터트린다.
            if (list.size() < 1) break; // 다 터트렸으면 루프 아웃
        }
        System.out.print(sb);
    }

    private static class Balloon {
        int num; // 풍선의 번호
        int move; // 풍선 안의 숫자
        private Balloon(int num, int move) {
            this.num = num;
            this.move = move;
        }
    }
}
