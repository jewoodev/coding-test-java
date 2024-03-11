package hanghae.day1;

public class Problem1 { //k 진수에서 소수 개수 구하기 https://school.programmers.co.kr/learn/courses/30/lessons/92335
    public boolean isprime(long n){
        if(n <= 1) return false;
        else if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0)
                return false;
        return true;
    }
    public String toKnum(int n, int k) {
        String res = "";
        while(n > 0) {
            res = n % k + res;
            n /= k;
        }
        return res;
    }
    public int solution(int n, int k) {
        int answer = 0, i, j;
        String s = toKnum(n,k);
        for(i = 0; i < s.length(); i = j) {
            for(j = i + 1; j < s.length() && s.charAt(j) != '0'; j++);
            if(isprime(Long.parseLong(s.substring(i,j))))
                answer++;
        }
        return answer;
    }
}
