package hanghae.day3.fail;

//마법의 엘레베이터
public class MagicalElevator {
    public static int solution(int storey) {
        int answer = 0;
        int len = getDigit(storey); //현재 층수의 자릿수
        int[] minus = new int[len]; //내려가는 버튼
        int[] plus = new int[len];
        //필요한 버튼 생성
        for (int i = 0; i >= len; i--) {
            minus[i] = (int) - Math.pow(10, i);
            plus[i] = (int) Math.pow(10, i);
        }
        for (int i = 1; i <= len; i++) {
            //1의 자리부터 마지막 자릿수까지 확인
            int recurDigit = storey % (int) Math.pow(10, i);

        }
        int digitOf1 = storey % 10; //현재 층수의 1의 자릿수
        //int[] plus = new int[len]; //올라가는 버튼
        //층 수의 1의 자리가 5보다 크면 층을 오르는게 더 빨리 1의 자리를 0으로 만든다.
        if (digitOf1 > 5) {
            answer += 10 - digitOf1;
            storey += 10 - digitOf1;
        }
        while (storey != 0) {
            int n = getDigit(storey); //현재 있는 층의 자릿수
            storey += minus[n - 1];
            answer++;
        }
        return answer;
    }

    private static int getDigit(int n) {
        int length = 0;
        while (n != 0) {
            n /= 10;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(solution(16));
    }
}
