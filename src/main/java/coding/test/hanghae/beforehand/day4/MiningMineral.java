package coding.test.hanghae.beforehand.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//광물 캐기
public class MiningMineral {
    static class Mineral {
        private int diamond;
        private int iron;
        private int stone;

        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }

    static int[][] scoreBoard;
    static List<Mineral> list;

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        //최소한의 피로도가 되는 경우를 찾아야 하므로 광물 당 각 곡괭이로 캤을 때 쌓이는 피로도를 계산한다.
        //헷갈리지 않게 배열로 매칭해둔다.
        scoreBoard = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

        int totalPicks = Arrays.stream(picks).sum(); //총 곡괭이의 갯수
        list = new ArrayList<>(); //선택한 곡괭이로 소모될 피로도
        for(int i = 0; i < minerals.length; i+=5) {
            if(totalPicks == 0) break; //곡괭이를 모두 사용한 경우에는 루프 아웃

            int dia = 0, iron = 0, stone = 0;
            for(int j = i; j < i + 5; j++) {
                if(j == minerals.length) break; //5개씩 나눴을 때 마지막 그룹이 5개보다 적을 시 루프 아웃

                String mineral = minerals[j]; //그룹의 광물에 하나씩 접근
                int val = mineral.equals("iron") ? 1 :
                        mineral.equals("stone") ? 2 : 0;

                //그룹의 광물을 각 곡괭이로 캤을 때의 피로도를 축적
                dia += scoreBoard[0][val];
                iron += scoreBoard[1][val];
                stone += scoreBoard[2][val];
            }

            //축적한 값을 그룹 리스트에 저장
            list.add(new Mineral(dia, iron, stone));
            totalPicks--;
        }

        //최소의 피로도를 찾기 위해 가장 피로도를 많이 소모하는 돌 곡괭이를 기준으로 내림차순 정렬
        Collections.sort(list, ((o1, o2) -> (o2.stone - o1.stone)));
        //돌 곡괭이로 피로도가 가장 많이 든 경우가 가장 좋은 곡괭이를 활용해서 피로도를 덜 써야하는 그룹
        for(Mineral m : list) {
            int dia = m.diamond;
            int iron = m.iron;
            int stone = m.stone;

            if(picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2},
                new String[]{"diamond", "diamond", "diamond",
                        "iron", "iron", "diamond", "iron", "stone"}));
    }
}
