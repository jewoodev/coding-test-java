package coding.test.besuccessfulapplicants.array;

import java.util.*;

class LengthOfVisit { // https://school.programmers.co.kr/learn/courses/30/lessons/49994
    private static Map<Character, int[]> movingDirector = new HashMap<>();
    private static Set<String> visited = new HashSet<>();

    public int solution(String dirs) {
        initDirector();
        int x = 0, y = 0;
        for (int i = 0; i < dirs.length(); i++) {
            var curIndicator = dirs.charAt(i);
            var curDirection = movingDirector.get(curIndicator);
            int nx = x + curDirection[0];
            int ny = y + curDirection[1];

            if (isValidMoving(nx, ny)) {
                visited.add(x + " " + y + " " + nx + " " + ny);
                visited.add(nx + " " + ny + " " + x + " " + y);
                x = nx;
                y = ny;
            }
        }
        return visited.size() / 2;
    }

    private static void initDirector() {
        movingDirector.put('U', new int[]{1,0});
        movingDirector.put('D', new int[]{-1,0});
        movingDirector.put('L', new int[]{0,-1});
        movingDirector.put('R', new int[]{0,1});
    }

    private static boolean isValidMoving(int x, int y) {
        return x >= -5 && x <= 5 && y >= -5 && y <= 5;
    }
}
