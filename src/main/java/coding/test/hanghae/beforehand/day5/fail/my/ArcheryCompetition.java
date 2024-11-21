package coding.test.hanghae.beforehand.day5.fail.my;
/*
양궁대회

어떻게 풀어야 할지 모르겠다.
 */
public class ArcheryCompetition {
    static int N, maxMinus;
    static int[] arr;
    static int[] answer = { -1 };

    public static int[] solution(int n, int[] info) {
        N = n; //라이언이 쏠 수 있는 화살 수
        maxMinus = -1; //두 화살 점수의 차이
        arr = new int[11]; //라이언이 화살을 맞추는 경우들을 재귀적으로 저장할 배열
        dfs(info, 0, 0);

        return answer;
    }

    //idx는 점수 0~10까지 접근, cnt는 사용한 화살 수
    private static void dfs(int[] apeach, int idx, int cnt) {
        if (idx == 11) { //점수 접근을 다 했으면
            //화살 다 썼는지 확인하고 다 썼으면 점수 계산
            if (cnt == N) {
                int apScore = 0, liScore = 0;
                for (int i = 0; i < 11; i++) {
                    if(apeach[i] == 0 && arr[i] == 0) {
                        continue;
                    }
                    if (apeach[i] >= arr[i])
                        apScore += 10 - i;
                    else
                        liScore += 10 - i;
                }

                if (liScore > apScore) {
                    //라이언이 가장 큰 차이로 이기는 경우
                    if (liScore - apScore > maxMinus) {
                        maxMinus = liScore - apScore;
                        answer = arr.clone(); //answer는 현재까지 최적의 상황
                    }
                    //라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우
                    else if (liScore - apScore == maxMinus) {
                        for (int i = 10; i >= 0; i--) { //낮은 점수부터 확인했을 때
                            if (answer[i] < arr[i]) { //이번 경우가 낮은 점수를 더 많이 맞췄다면
                                answer = arr.clone(); //최적의 상황으로 갱신한다
                                return;
                            }
                            else if (answer[i] > arr[i])
                                return; //그게 아니라면 갱신하지 않는다.
                        }
                    }
                }
            }
            return;
        }

        //둘다 0으로 점수 받기 포기
        if(apeach[idx] == 0) {
            dfs(apeach, idx + 1, cnt);
        }

        //어피치 이기기
        if(cnt + 1 + apeach[idx] <= N) { //현재까지 사용한 화살 수+1에 어피치 화살 수를 더해도 전체 화살 수가 넘지 않으면
            arr[idx] = apeach[idx] + 1;
            dfs(apeach, idx + 1, cnt + 1 + apeach[idx]);
            arr[idx] = 0;
        }

        //어피치한테 지기
        if(apeach[idx] != 0) {
            for(int i = 0; i <= apeach[idx]; i++) {
                arr[idx] = i;
                dfs(apeach, idx + 1, cnt + i);
                arr[idx] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int n = 5;
        int[] info = new int[]{2,1,1,1,0,0,0,0,0,0,0};
        System.out.println(solution(n, info));
    }
}
