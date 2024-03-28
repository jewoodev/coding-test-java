package hanghae.beforehand.day5.fail;

/*
이모티콘 할인행사

어떤 논리로 조건을 만족시키는 할인율을 찾아야 할지 그럴듯한 방안이 떠오르지 않는다
우선순위가 첫 번째, 두 번째가 있는데 이해되기로는 첫 번째 조건을 우선하기만 하면 되는 것 같지만
예시를 보면 플러스 가입을 한 명 시키면 한 명은 매출을 올리는 식으로 두 가지 모두 증가시키면서 최대가 되는
경우를 찾아야 한다. 이렇게 정리하면서 이해해보니 완전 탐색을 해야할 것 같은데,
그래선지 정답 풀이법을 보면 완전 탐색으로 풀었다. 시간 복잡도는 현재 제한 사항에서 100*4^7이 나온다고 한다.

 */
public class EmoticonDiscountEvent {
    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        int maxRate = Integer.MIN_VALUE; //유저들이 원하는 할인율 중 가장 큰 것
        for (int[] user : users)
            if (user[0] > maxRate)
                maxRate = user[0]; //루프를 돌며 maxRate를 찾는다

        //maxRate로 할인될 때 조건대로 가입 여부와 비용을 계산
        for (int i = 0; i < users.length; i++) {
            int limit = users[i][1]; //유저가 갖는 각각의 구입 한계치
            int cost = 0; //유저가 쇼핑하며 누적되는 비용

            for (int j = 0; j < emoticons.length; j++) {
                cost += emoticons[j] / 100 * maxRate; //순서대로 이모티콘을 구입한다.

                if (cost > limit) //유저의 한도치를 넘으면 구입을 모두 취소하고 플러스에 가입한다
                    answer[0] += 1;

                if (j == emoticons.length - 1) //모두 구입해도 한도치를 넘지 않으면
                    answer[1] += cost; //구입한다
            }

        }


        return answer;
    }

    private static class User {
        int emoticon; //구매한 이모티콘
        int expense; //이모티콘 구매 비용
        int joinPlus; //이모티콘 플러스 가입 여부

        public User(int emoticon, int expense, int joinPlus) {
            this.emoticon = emoticon;
            this.expense = expense;
            this.joinPlus = joinPlus;
        }
    }

    public static void main(String[] args) {
        int[] solution = solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000});
        System.out.println(solution);
    }
}
