package coding.test.hanghae.beforehand.day3;

//숫자 카드 나누기
public class DivideNumberCard {
    public static int solution(int[] arrayA, int[] arrayB) {
        long gcd1 = 0, gcd2 = 0; //두 사람의 최대공약수
        boolean isValid1 = false, isValid2 = false; //1, 2번 조건을 만족하는지 여부
        int len = arrayA.length;
        //첫 조건부터 확인, 첫 사람의 최대공약수를 구해서
        for (int i = 1; i < len; i++)
            gcd1 = gcd(arrayA[0], arrayA[i]);
        for (int i = 0; i < len; i++) {
            //두 번째 사람의 카드가 나뉘어지는지 확인
            if (gcd1 == 1) { //1이면 조건 만족x
                break;
            } else {
                if (arrayB[i] % gcd1 == 0) {
                    isValid1 = false;
                    break;
                } else {
                    continue;
                }
            }
        }
        //다음 조건 확인, 두 번째 사람의 최대공약수를 구해서
        for (int i = 1; i < len; i++)
            gcd2 = gcd(arrayB[0], arrayB[i]);
        for (int i = 0; i < len; i++) {
            //첫 번째 사람의 카드가 나뉘어지는지 확인
            if (gcd2 == 1) { //1이면 조건 만족x
                break;
            } else {
                if (arrayA[i] % gcd2 == 0) {
                    isValid2 = true;
                    break;
                } else {
                    continue;
                }
            }
        }

        //1 조건을 만족하면 그 최대공약수를 반환
        if (isValid1 && !isValid2) {
            return (int) gcd1;
        //2 조건을 만족하면 그 최대공약수를 반환
        } else if (isValid2 && !isValid1) {
            return (int) gcd2;
        } else
            return 0;
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) return b;
        else return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10,17}, new int[]{5,20}));
    }
}
