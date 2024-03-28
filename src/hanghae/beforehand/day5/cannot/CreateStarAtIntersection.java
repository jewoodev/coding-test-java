package hanghae.beforehand.day5.cannot;


import java.util.ArrayList;
import java.util.List;

/*
교점에 별 만들기

최대 공약수나 최소 공배수로 풄 수 있을까 생각이 났다. 각 방정식이 모두 동일한 해로 풀리는 것을 찾아야 하는데
gcd나 lcm를 식마다 어떻게 적용할지도 의문이다.
 */
public class CreateStarAtIntersection {
    /*
     1. 좌표 문제를 만나면 좌표 클래스를 이용하자.
     */
    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    /*
     2. 교차점을 구할 수 있는 함수를 만들어줍시다.
     */
    private static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        //long 타입으로 변환하지 않으면 여기서 10만 * 10만 = 100억으로 오버플로우가 나서 int형 MAX_VALUE로 치환된다.
        double x = (double)(b1*c2 - b2*c1) / (a1*b2 - a2*b1);
        double y = (double)(a2*c1 - a1*c2) / (a1*b2 - a2*b1);

        if((x % 1 != 0) || (y % 1 != 0)) {
            return null;
        }
        return new Point((long)x, (long)y);
    }

    public String[] solution(int[][] line) {

        List<Point> points = new ArrayList<>();

        /*
         3. Polong 타입 배열에 정수 교차점을 모두 저장
         */
        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j <line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }


        /*
         4. polongs 배열을 순회하며 x와 y 최대, 최소값을 구해서
         */
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        for (int i = 0; i < points.size(); i++) {
            maxX = Math.max(maxX, points.get(i).x);
            minX = Math.min(minX, points.get(i).x);
            maxY = Math.max(maxY, points.get(i).y);
            minY = Math.min(minY, points.get(i).y);
        }

        /*
        5. 모든 별을 포함하는 최소 사각형을 만든다.
         */
        int xLength = (int) (maxX - minX + 1);
        int yLength = (int) (maxY - minY + 1);

        char[][] map = new char[yLength][xLength];

        /*
        6. 교점에 별 찍기, 먼저 모든 좌표를 그려준 후
         */
        for (int i = 0; i < yLength; i++) {
            for (int j = 0; j < xLength; j++) {
                map[i][j] = '.';
            }
        }

        //교점에 별을 찍는다. 배열로 구현하는 행렬은 y 축의 부호가 반대이다.
        for (int i = 0; i < points.size(); i++) {
            int x = (int) (points.get(i).x - minX);
            int y = (int) (maxY - points.get(i).y);
            map[y][x] = '*';
        }

        String[] answer = new String[map.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(map[i]);
        }

        return answer;
    }
}
