package coding.test.besuccessfulapplicants.hash.discountevent;

import java.util.*;

class DiscountEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        var map = new HashMap<String, Integer>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        int cnt = 0;
        for (int i = 0; i < discount.length - 9; i++) {
            if (find(i, map, discount)) cnt += 1;
        }

        return cnt;
    }

    private boolean find(int idx, HashMap<String, Integer> realMap, String[] discount) {
        var map = new HashMap<>(realMap);

        for (int i = idx; i < idx + 10; i++) {
            if (map.containsKey(discount[i])) {
                int val = map.get(discount[i]) - 1;
                if (val >= 0) {
                    map.put(discount[i], val);
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        return true;
    }
}
