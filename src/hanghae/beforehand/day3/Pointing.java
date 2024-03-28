package hanghae.beforehand.day3;

//점 찍기
public class Pointing {
    public static long solution(int k, int d) {
        long answer = 0;
    /* `x^2 + y^2 = r^2` 원의 방정식을 이용해서 풀이.
       반지름이 d 인 원을 1사분면에 그려 원 안에 찍을 수 있는 점의 개수를 센다. */
        for(int i = 0; i <= d; i += k) {
            long dd = (long) d * d; //r^2
            long ii = (long) i * i; //x^2
            int top = (int) Math.sqrt(dd - ii); //y^2
            answer += (top / k) + 1; //x가 i일 때 원 안에 찍을 수 있는 점의 개수
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4));
    }
}
