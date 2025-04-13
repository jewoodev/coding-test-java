# [3185. Count Pairs That Form a Complete Day II](https://leetcode.com/problems/count-pairs-that-form-a-complete-day-ii/description/)

`hours[i] + hours[j]` 의 합이 24의 배수 (즉, 24, 48, 72, …)가 되는 (i, j) 쌍의 수를 세는 문제이다. 단, i < j 여야 한다.

어떤 수 `a`와 `b`의 합이 24의 배수가 되려면,

```
a % 24 + b % 24 ≡ 0 (mod 24)
```

즉, a % 24와 b % 24의 합이 24의 배수여야 한다. 이를 바탕으로, 각 시간값을 24로 나눈 나머지를 기준으로 쌍을 찾는다.


```java
class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long result = 0;
        int[] cnt = new int[24];
        for (int h : hours) {
            result += cnt[(24 - h % 24) % 24];
            cnt[h % 24]++;
        }
        return result;
    }
}
```

## 코드 설명

```java
int[] cnt = new int[24];
```

cnt[i]는 hours 배열에서 hour % 24 == i인 값이 지금까지 몇 번 나왔는지를 저장합니다.

```java
for (int h : hours) {
    result += cnt[(24 - h % 24) % 24];
    cnt[h % 24]++;
}
```

`h % 24`가 현재 나머지라고 할 때, 이를 완전한 하루(24의 배수)로 만들기 위해 더해야 하는 값은 `target = (24 - h % 24) % 24` 이다.

이미 앞에서 등장했던 값들 중에 `target` 나머지를 가진 값이 몇 개인지 `cnt[target]`에서 가져와 현재 `h`와 쌍을 이룰 수 있는 조합 수만큼 `result`에 더해줍니다.

마지막으로 `cnt[h % 24]++` 를 통해 현재 값을 기록합니다.

## 🧠 예제 시뮬레이션

예: `hours = [12, 12, 30, 24, 24]`

- 각 값의 `mod 24`: [12, 12, 6, 0, 0]
- `12 + 12 = 24` → 12와 12는 서로를 보완 
- `0 + 0 = 0` → 이미 0이 등장한 후 0이 또 등장하면 쌍을 이룸

`cnt[(24 - h % 24) % 24]`로 바로 보완되는 값의 개수를 알 수 있어 효율적이다.

## ⏱️ 시간 복잡도

**O(n)**: 배열을 한 번 순회하면서 계산

**공간 복잡도**: O(1) (cnt 배열의 크기는 고정: 24)

## ✅ 정리된 설명

이 코드는 각 시간 값을 24로 나눈 나머지를 기준으로, 이전에 등장한 값들과의 조합 중 합이 24의 배수가 되는 경우를 빠르게 찾아낸다.

이때 (i, j)에서 i < j를 만족시키기 위해, 현재 값을 기준으로 이전까지 등장한 값만 세므로 중복 카운팅도 방지된다.

시간 복잡도는 O(n)으로 매우 효율적이며, 문제 조건을 완벽히 만족하는 풀이다.