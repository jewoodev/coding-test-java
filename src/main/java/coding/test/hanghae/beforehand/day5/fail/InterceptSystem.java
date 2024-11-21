package coding.test.hanghae.beforehand.day5.fail;
/*
요격 시스템

어떤 방법으로 개구간을 저장해야할지 모르겠다. 개구간이 확인될 때마다 그 범위에 있는 value를 1씩 증가 시키자니
0.01, 0.001, ... 소수점까지 범위에 포함되도록 구현해야 하는데 이걸 어떻게 할 수 있을까
*/

/*
public class InterceptSystem {
    public int solution(int[][] targets) {
        int answer = 0;
        int maxX = Integer.MIN_VALUE;
        //가장 큰 X좌표를 찾아서
        for (int i = 0; i < targets.length; i++) {
            if (targets[i][1] > maxX)
                maxX = targets[i][1];
        }
        //개구간을 저장할 배열을 생성한다
        double[] a = new double[][maxX];
        for (int[] target : targets) {
            for
        }
        return answer;
    }
}
*/