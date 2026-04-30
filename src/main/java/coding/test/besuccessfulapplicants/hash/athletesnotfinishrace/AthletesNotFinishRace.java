package coding.test.besuccessfulapplicants.hash.athletesnotfinishrace;

import java.util.*;

class AthletesNotFinishRace {
    public String solution(String[] participant, String[] completion) {
        var map = new HashMap<String, Integer>();
        for (String p : participant) {
            int val = map.getOrDefault(p, 0);
            map.put(p, ++val);
        }

        for (String c : completion) {
            int val = map.get(c);
            if (val == 1) {
                map.remove(c);
            }
            else {
                map.put(c, --val);
            }
        }

        return map.keySet().iterator().next();
    }
}
