package hanghae.beforehand.day3.fail;

//점 찍기
public class Pointing {
    public static long solution(int k, int d) {
        long answer = 0;
        int a = 0;
        int b = 0;
        boolean[][] visited = new boolean[1_000_000][1_000_000];
        
        while (true) {
            if (a * k <= d && b * k <= d) answer++;
            else break;
            a++; b++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4));
    }
}
