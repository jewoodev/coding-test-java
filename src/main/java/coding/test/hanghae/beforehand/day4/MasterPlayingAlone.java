package coding.test.hanghae.beforehand.day4;

import java.util.*;

//혼자 놀기의 달인
public class MasterPlayingAlone {
    static boolean[] visited;
    static int depth;

    public static int solution(int[] cards) {
        int answer = 1;
        int len = cards.length;
        visited = new boolean[len + 1];
        List<Integer> list = new ArrayList<>(); //박스 그룹, 그룹 안의 박스 수를 값으로 가진다.
        //임의의 상자를 선택해야 하지만, 주어진 순서대로 선택하는 것도 임의의 경우에 포함된다.
        for (int i = 0; i < len; i++) {
            //boolean 배열로 열린 박스를 true로 구현한다.
            if (!visited[i + 1]) {
                depth = 1; //1번 그룹에 박스 개수, open 메서드에서 박스를 열 때마다 증가연산이 이루어진다.
                visited[i + 1] = true;
                open(cards[i], cards);
                list.add(depth); //
            }
        }
        if (list.size() < 2) //박스 그룹이 1번 밖에 없다면
            return 0;
        //두 그룹의 곱이 최대가 되려면 가장 큰 두 그룹이어야 한다.
        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0) * list.get(1);
        return answer;
    }

    private static void open(int x, int[] cards) {
        if (!visited[x]) {
            visited[x] = true;
            depth++;
            open(cards[x - 1], cards);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{8,6,3,7,2,5,1,4}));
    }
}
