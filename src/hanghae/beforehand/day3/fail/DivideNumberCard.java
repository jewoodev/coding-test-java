package hanghae.beforehand.day3.fail;

//숫자 카드 나누기
public class DivideNumberCard {
    /**
     * @param arr : int 배열
     * @param num : int
     * @return arr의 요소 중 num으로 나눠떨어지는 게 없는지 여부
     */
    public static boolean notDivisible(int[] arr, int num){
        for(int n : arr)
            if(n % num == 0)
                return false;
        return true;
    }

    //유클리드 호제법
    public static int gcd(int a, int b) {
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
    public static int solution(int[] arrayA, int[] arrayB) {
        // 0. 입력 및 초기화
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        // 1. 각 배열의 최대공약수 구하기
        for(int i =1; i< arrayA.length;i++){
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 2. 서로의 배열을 나눌 수 없는지 확인
        if(notDivisible(arrayB, gcdA))
            if(answer < gcdA)
                answer = gcdA;

        if(notDivisible(arrayA, gcdB))
            if(answer < gcdB)
                answer = gcdB;

        // 3. 최댓값 반환
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{10,17}, new int[]{5,20}));
    }
}
