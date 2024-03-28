import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//연속된 부분 수열의 합
public class GetPartialSeqSum {
    public static void main(String[] args) {
        String answer = arrayToString(solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5));
        System.out.println(answer);
    }

    public static int[] solution(int[] sequence, int k) {
        ArrayList<Integer[]> process = new ArrayList<>();
        for (int i = 0; i < sequence.length - 1; i++) {
            for (int j = i + 1; j <= sequence.length; j++) {
                int[] temp = Arrays.copyOfRange(sequence, i, j + 1);
                int sum = 0;
                for (int n : temp) {
                    sum += n;
                }
                if (sum == k)
                    process.add(Arrays.stream(temp).boxed().toArray(Integer[]::new));
            }
        }
        Collections.sort(process, (e1, e2) -> e2.length - e1.length);
        int[] lowArr = Arrays.stream(process.get(0)).mapToInt(Integer::intValue).toArray();
        int fN = 0, rN = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (lowArr[0] == sequence[i]) fN = i;
            if (lowArr[1] == sequence[i]) rN = i;
        }
        return new int[]{fN, rN};
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
