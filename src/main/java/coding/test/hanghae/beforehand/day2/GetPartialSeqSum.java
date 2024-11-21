package coding.test.hanghae.beforehand.day2;

//연속된 부분 수열의 합
public class GetPartialSeqSum {
    public static void main(String[] args) {
        String answer = arrayToString(solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5));
        System.out.println(answer);
    }

    public static int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        int left = 0, right = N;
        int sum = 0;
        for(int L = 0, R = 0; L < N; L++) {
            while(R < N && sum < k) {
                sum += sequence[R++];
            }

            if(sum == k) {
                int range = R - L - 1;
                if((right - left) > range) {
                    left = L;
                    right = R - 1;
                }
            }

            sum -= sequence[L];
        }

        int[] answer = {left, right};

        return answer;
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
