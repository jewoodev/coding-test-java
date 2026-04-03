package coding.test.leetcode.easy;

class AddBinary {
    public String addBinary(String a, String b) {
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        int up = 0;
        var sb = new StringBuilder();

        while (aIdx > -1 || bIdx > -1) {
            int curA = 0, curB = 0;

            if (aIdx == -1) {
                curB = b.charAt(bIdx) - '0';
            } else if (bIdx == -1) {
                curA = a.charAt(aIdx) - '0';
            } else {
                curA = a.charAt(aIdx) - '0';
                curB = b.charAt(bIdx) - '0';
            }

            int cur = curA + curB;
            if (up == 1) {
                cur += up;
                up = 0;
            }
            if (cur > 1) {
                cur -= 2;
                up = 1;
            }

            sb.insert(0, cur);

            if (aIdx > -1) aIdx--;
            if (bIdx > -1) bIdx--;
        }

        if (up == 1) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }
}
