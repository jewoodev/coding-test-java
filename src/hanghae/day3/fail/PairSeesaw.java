package hanghae.day3.fail;

//시소 짝꿍
public class PairSeesaw {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{100,180,360,100,270}));
    }

    /* 최대공약수가 아니라 최소공배수를 이용해서 풀어야 된다는 걸 깨달았다. 근데 최소공배수 구하는 알고리즘이 생각 안나기도 하고 다른 풀이가 궁금해졌다. */
    public static long solution(int[] weights) {
        long answer = 0;
        //투 포인터로 weights를 순회
        for (int i = 0; i < weights.length - 1; i++) {
            for (int j = i + 1; j < weights.length; j++) {
                //두 사람의 무게가 같으면
                if (weights[i] == weights[j])
                    answer++;
                //아니면
                else {
                    //토크를 이용해 무게를 맞출 수 있는지 확인, 최대공약수 이용
                    int gcd = gcd(weights[i], weights[j]);
                    int quotient1 = weights[i] / gcd;
                    int quotient2 = weights[j] / gcd;
                    if (quotient1 >= 2 && quotient2 >= 2 && quotient1 <= 4 && quotient2 <= 4)
                        answer++;
                }
            }
        }
        return answer;
    }

    //유클리드 호제법
    private static int gcd(int x, int y) {
        if (x % y == 0) return y;
        else
            return gcd(y, x % y);
    }
}
