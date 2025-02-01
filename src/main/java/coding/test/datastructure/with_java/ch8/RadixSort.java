package coding.test.datastructure.with_java.ch8;

public class RadixSort {
    final static int MAX_SIZE = 100;

    public static void radixSort(int[] arr, int n) {
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) max = arr[i];
        }

        int digitPlace = 1;
        int[] bucket = new int[10];
        int[] output = new int[MAX_SIZE];
        for (int i = 0; i < 10; i++) {
            bucket[i] = 0;
        }

        // 가장 큰 자릿수까지 반복
        while (max / digitPlace > 0) {
            for (int i = 0; i < 10; i++) {
                bucket[i] = 0;
            }
            // 자릿수를 기준으로 데이터를 버킷에 분배
            for (int i = 0; i < n; i++) {
                int index = (arr[i] / digitPlace) % 10;
                bucket[index]++;
            }
            // 버킷 배열 업데이트(누적 갯수로)
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            // 입력 배열을 역순으로 순회하며 데이터를 output 배열에 배치
            for (int i = n - 1; i >= 0; i--) {
                int index = (arr[i] / digitPlace) % 10;
                output[bucket[index] - 1] = arr[i];
                bucket[index]--;
            }
            // output 배열을 입력 배열로 복사
            for (int i = 0; i < n; i++) {
                arr[i] = output[i];
            }
            // 다음 자릿수로 이동
            digitPlace *= 10;
        }
    }
}
