package coding.test.leetcode.cannot.medium._735;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean exploded = false;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (Math.abs(asteroid) > stack.peek()) {
                    stack.pop(); // 이전 소행성 폭발
                } else if (Math.abs(asteroid) == stack.peek()) {
                    stack.pop(); // 둘 다 폭발
                    exploded = true;
                    break;
                } else {
                    exploded = true; // 현재 소행성 폭발
                    break;
                }
            }

            if (!exploded) {
                stack.push(asteroid);
            }
        }

        // 스택을 배열로 변환하여 결과 반환
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}