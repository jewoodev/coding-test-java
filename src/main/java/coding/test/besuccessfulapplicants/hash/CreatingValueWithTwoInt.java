package coding.test.besuccessfulapplicants.hash;

import java.util.*;

class CreatingValueWithTwoInt {
    public boolean solution(int[] arr, int target) {
        var set = new HashSet<Integer>();

        for (int i : arr) {
            if (set.contains(target - i)) {
                return true;
            }

            set.add(i);
        }

        return false;
    }
}
