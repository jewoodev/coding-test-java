package coding.test.hanghae.beforehand.day3;

//마법의 엘레베이터
public class MagicalElevator {
    public static int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int digit = storey % 10; //1의 자리
            storey = storey / 10; //1의 자리를 제거한 수
            if (digit == 5) { //1의 자리가 5와 같을 때
                if (storey % 10 >= 5) { //10의 자리가 5보다 크면
                    answer += 10 - digit; //올라가는게 효율적
                    storey++;
                } else //5보다 작으면
                    answer += digit; //내려가는게 효율적
            } else if (digit > 5) { //1의자리가 5보다 작으면
                answer += 10 - digit; //내려가는게 효율적
                storey++;
            } else //1의 자리가 5보다 크면
                answer += digit; //올라가는게 효율적
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(16));
    }
}
