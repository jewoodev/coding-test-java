package coding.test.programmers.two.sortfilename;

import java.util.Arrays;


class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            String[] splitA = split(a);
            String[] splitB = split(b);

            String nameA = splitA[0].toLowerCase();
            String nameB = splitB[0].toLowerCase();

            if (nameA.equals(nameB)) {
                int numA = Integer.valueOf(splitA[1]);
                int numB = Integer.valueOf(splitB[1]);

                return numA - numB;
            }

            return nameA.compareTo(nameB);
        });

        return files;
    }

    private String[] split(String s) {
        String[] result = new String[2];
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                break;
            }
            sb.append(c);
        }
        result[0] = sb.toString();

        sb = new StringBuilder();
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            sb.append(s.charAt(i++));
        }
        result[1] = sb.length() == 0 ? "0" : sb.toString();

        return result;
    }
}
