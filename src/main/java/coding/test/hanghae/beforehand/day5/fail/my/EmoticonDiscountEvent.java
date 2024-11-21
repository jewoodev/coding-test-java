package coding.test.hanghae.beforehand.day5.fail.my;

public class EmoticonDiscountEvent {
    private static int goal1 = 0; //목표1
    private static int goal2 = 0; //목표2

    private static int[] arr;

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        int[] arr = new int[emoticons.length]; //각각의 이모티콘 할인율 배열
        fullSearch(arr, 0, users, emoticons); //완전 탐색 시작

        answer[0] = goal1;
        answer[1] = goal2;

        return answer;
    }

    private static void fullSearch(int[] arr, int start, int[][] users, int[] emoticons){
        if(start == arr.length) { //모든 이모티콘에 할인율 지정이 되었으면
            calculate(arr, users, emoticons); //결과를 계산
            return;
        }

        for (int i = 10; i <= 40; i += 10) { //재귀마다 순서대로 이모티콘에 모든 할인율의 경우를 만드는 루프
            arr[start] = i; //이모티콘에 순서대로 할인율을 저장
            fullSearch(arr, start + 1, users, emoticons); //다음 이모티콘에 루프를 먹이는 재귀
        }
    }

    private static void calculate(int[] arr,int[][] users,int[] emoticons){
        int plus = 0; //플러스 가입 회원 수
        int cost = 0; //총 구입 비용

        for (int[] user : users) { //유저들의 쇼핑 루프
            int discount = user[0]; //유저 할인 하한
            int price = user[1]; //유저 소비 상한
            int sum = 0; //

            for (int i = 0; i < arr.length; i++)
                if (arr[i] >= discount) //구입 가능한지 확인 후
                    sum += (emoticons[i]/100)*(100-arr[i]); //구입

            if (sum >= price) //상한을 넘으면
                plus++; //플러스 가입
            else //아니면
                cost += sum; //구입 결정
        }

        if (plus > goal1) { //이전보다 플러스 가입 수가 증가했으면
            goal1 = plus; //갱신
            goal2 = cost;
        } else if (plus == goal1) { //유지되면서
            if (goal2 < cost) //수익이 늘면
                goal2 = cost; //갱신
        }
    }

    public static void main(String[] args) {
        int[] solution = solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000});
        System.out.println(solution);
    }
}
