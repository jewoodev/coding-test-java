package hanghae.day3.supplement;

//멀쩡한 사각형
public class IntactTriangle {
    public long solution(int w, int h) {
        /* 정사각형이 하나의 1차원 그래프라고 보고 주어진 조건대로의 대각선이 지나는 정수 단위의 좌표를 보면
        너비와 높이를 너비와 높이의 최대공약수로 나눈 값의 배수로 규칙성을 갖는 것을 알 수 있다.
        그렇기 때문에 단위정사각형의 개수는 최대공약수와 같게 되고, 그 크기는
        ((w / gcd) * ((h / gcd) - 1) 의 규칙성을 갖는 것을 알 수 있다.  */
        long gcd = gcd(w, h);
        long answer = ((long) w * h) - ((w / gcd) * ((h / gcd) - 1) * gcd);
        return answer;
    }

    //유클리드 호제법
    private int gcd(int x, int y) {
        if (x % y == 0) return y;
        return gcd(y, x % y);
    }
}
