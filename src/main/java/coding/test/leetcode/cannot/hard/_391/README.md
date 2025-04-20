# [391. Perfect Rectangle](https://leetcode.com/problems/perfect-rectangle/description/)

이 문제는 주어진 직사각형들의 집합이 하나의 완벽한 직사각형을 형성하는지 확인하는 문제이다. 완벽한 직사각형이 되기 위해서는 다음 조건들을 만족해야 한다.

1. 모든 직사각형들이 겹치지 않아야 한다.
2. 모든 직사각형들이 합쳐져서 하나의 큰 직사각형을 형성해야 한다.
3. 큰 직사각형의 내부에 빈 공간이 없어야 한다.

해결 방법은 다음과 같다.

1. 모든 직사각형들의 좌표를 분석하여 가장 작은 x, y 좌표와 가장 큰 x, y 좌표를 찾는다. 이는 완벽한 직사각형의 모서리 좌표가 된다.
2. 각 직사각형의 네 모서리 좌표를 저장하고, 각 좌표가 몇 번 나타나는지 카운트한다.
3. 완벽한 직사각형이 되기 위해서는
   - 가장 바깥쪽 모서리 좌표는 정확히 한 번만 나타나야 한다.
   - 내부 모서리 좌표는 짝수 번(2번 또는 4번) 나타나야 한다.
   - 모든 직사각형들의 면적의 합이 전체 직사각형의 면적과 같아야 한다.

위의 설명대로 구현한 코드를 살펴보자.

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) {
            return false;
        }

        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        
        Set<String> set = new HashSet<>();
        int area = 0;

        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);

            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

            String s1 = rect[0] + " " + rect[1];
            String s2 = rect[0] + " " + rect[3];
            String s3 = rect[2] + " " + rect[3];
            String s4 = rect[2] + " " + rect[1];

            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }

        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || 
            !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4) {
            return false;
        }

        return area == (x2 - x1) * (y2 - y1);
    }
}
```

이 코드의 주요 로직을 설명해보겠다.

1. 입력으로 주어진 직사각형들의 좌표를 순회하면서 전체 직사각형의 경계를 찾는다 (x1, y1, x2, y2).
2. 각 직사각형의 면적을 계산하여 총 면적을 구한다.
3. 각 직사각형의 네 모서리 좌표를 문자열로 변환하여 Set에 저장한다. 만약 같은 좌표가 두 번 나타나면 Set에서 제거된다. 이렇게 하면 홀수 번 나타나는 좌표만 Set에 남게 된다.
4. 완벽한 직사각형이 되기 위해서는
   - Set에는 정확히 4개의 좌표만 남아있어야 한다 (바깥쪽 모서리). 
   - 이 4개의 좌표는 전체 직사각형의 네 모서리와 일치해야 한다. 
   - 모든 직사각형들의 면적의 합이 전체 직사각형의 면적과 같아야 한다.
   
이 알고리즘의 시간 복잡도는 O(n)이며, 공간 복잡도도 O(n)이다. 여기서 n은 주어진 직사각형의 갯수다.