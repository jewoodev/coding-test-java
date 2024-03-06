package doit.sort;

public class CountSort { //계수 정렬 구현
    public static void main(String[] args) {
        int[] data = {3, 5, 1, 4, 1, 2, 2, 3, 2, 7};
        int[] cnt = new int[10];
        System.out.println("계수 정렬 전");
        for (int i : data) {
            System.out.print(data[i] + " ");
        }
        System.out.println("\n\n 정렬 전 cnt 값");
        for (int i : cnt) {
            System.out.print(i + " ");
        }
        for (int i = 0; i < 10; i++) {
            cnt[data[i]]++;
        }
        System.out.println("\n\n 정렬 후 cnt 값");
        for (int i : cnt) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n 계수 정렬된 값");
        for (int i = 0; i < 10; i++) {
            if (cnt[i] != 0) {
                int j = 0;
                while (j < cnt[i]) {
                    System.out.print(i + " ");
                    j++;
                }
            }
        }
    }
}
