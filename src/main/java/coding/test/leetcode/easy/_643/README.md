# 643. Maximum Average Subarray I

문제 링크: [링크](https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75)

슬라이딩 윈도우 개념을 사용하여 풀었다. 그런데 Runtime 이 너무 느린 편이였다.

---

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double next = 0.0;
        for(int i = 0; i < k; i++) {
            next += nums[i];
        }

        double max = next;

        for(int i = 0; i < nums.length - k; i++) {
            next -= nums[i]; 
            next += nums[i + k];

            if (max < next) {
                max = next;
            }
        }

        return max / k;
    }
}
```

위 방법으로 풀면 시간복잡도를 OlogN으로 줄일 수 있다.
