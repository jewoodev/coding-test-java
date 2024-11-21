package coding.test.hanghae.beforehand.day5.fail;
/*
양궁대회

어떻게 풀어야 할지 모르겠다.
 */
public class ArcheryCompetition {
    public static void main(String[] args) {
        int n = 5;
        int[] info = new int[]{2,1,1,1,0,0,0,0,0,0,0};
        System.out.println(solution(n, info));
    }

    public static int[] solution(int n, int[] info) {
        int[] answer = {};
        for (int i = info.length - 1; i < 0; i--) {
            if (info[i] != 0 && i != 0) {

            }
        }
        return answer;
    }
}
