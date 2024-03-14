package hanghae.day4.fail;

//광물 캐기
//한번 선택한 곡괭이는 사용할 수 없을 때까지 사용한다는 조건을 잊고 구현하지 않았다.
//고쳐서 풀 수 있을 것 같지만 더 간단 명료하게 걷어낸 풀이가 있을 거라 생각해 다른 풀이로 공부한다.
public class MiningMineral {
    public static int solution(int[] picks, String[] minerals) {
        int dia = picks[0];
        int iron = picks[1];
        int stone = picks[2];
        int dUsed = 0;
        int iUsed = 0;
        int sUsed = 0;
        int tired = 0;
        for (String mineral : minerals) {
            //광물이 diamond이고
            if (mineral == "diamond") {
                //다이아몬드 곡괭이가 있으면 피로도 1
                if (dia > 0) {
                    tired++;
                    dUsed++;
                }
                //아니면 5, 25
                else if (iron > 0) {
                    tired += 5;
                    iUsed++;
                } else if (stone > 0) {
                    tired += 25;
                    sUsed++;
                //곡괭이를 다 사용했으면 루프를 벗어남
                } else {
                    break;
                }
            //광물이 철이고
            } else if (mineral == "iron") {
                //철 곡괭이가 있으면 피로도 1
                if (iron > 0) {
                    tired++;
                    iUsed++;
                //아니면 1, 5
                } else if (dia > 0) {
                    tired++;
                    dUsed++;
                } else if (stone > 0) {
                    tired += 5;
                    sUsed++;
                } else {
                    break;
                }
            //광물이 돌이면
            } else {
                //어떤 곡괭이든 피로도 1
                if (stone > 0) {
                    tired++;
                    sUsed++;
                } else if (iron > 0) {
                    tired++;
                    iUsed++;
                } else if (dia > 0) {
                    tired++;
                    dUsed++;
                } else {
                    break;
                }
            }//광물 체크 if
            if (dUsed == 5) {
                dia--;
                dUsed = 0;
            }
            if (iUsed == 5) {
                iron--;
                iUsed = 0;
            }
            if (sUsed == 5) {
                stone--;
                sUsed = 0;
            }//곡괭이 사용 횟수 if
        }//for
        return tired;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2},
                new String[]{"diamond", "diamond", "diamond",
                        "iron", "iron", "diamond", "iron", "stone"}));
    }
}
