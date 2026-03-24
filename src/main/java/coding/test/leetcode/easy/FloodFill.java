package coding.test.leetcode.easy;

import java.util.*;

class FloodFill {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origin = image[sr][sc];
        if (origin == color) return image;

        var q = new ArrayDeque<Point>();

        q.offer(new Point(sr, sc));

        image[sr][sc] = color;
        while (!q.isEmpty()) {
            var cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x - dx[i];
                int ny = cur.y - dy[i];

                if (ny < 0 || nx < 0 || ny >= image.length || nx >= image[0].length)
                    continue;

                if (image[ny][nx] == origin) {
                    image[ny][nx] = color;
                    q.offer(new Point(ny, nx));
                }
            }
        }

        return image;
    }

    private static class Point {
        int x, y;

        private Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
