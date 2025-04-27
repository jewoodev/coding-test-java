## [1604. Alert Using Same Key-Card Three or More Times in a One Hour Period](https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/description/)

해시맵을 사용해 각 직원이 카드키 사용 기록을 Value로 갖도록 입력값을 저장해두고 룩업해가며 필터링하는 방식으로 풀이할 수 있다.

문제의 핵심은 다음과 같다.


1. 각 직원의 카드키 사용 시간을 기록하고
2. 1시간 이내에 3번 이상 사용된 경우를 찾아내는 것입니다.

가장 효율적인 접근 방법은 다음과 같습니다:

1. HashMap을 사용하여 각 직원의 사용 기록을 저장
2. 각 직원의 사용 시간을 정렬
3. 슬라이딩 윈도우 기법을 사용하여 1시간 이내에 3번 이상 사용된 경우를 확인

이를 구현한 코드를 확인해보자.


```java
import java.util.*;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        // 1. 각 직원별로 시간을 분 단위로 변환하여 저장
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            int minutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
            
            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(minutes);
        }
        
        List<String> result = new ArrayList<>();
        
        // 2. 각 직원별로 시간을 정렬하고 1시간 이내 3번 이상 사용 확인
        for (String name : map.keySet()) {
            List<Integer> times = map.get(name);
            Collections.sort(times);
            
            // 슬라이딩 윈도우로 1시간 이내 3번 이상 사용 확인
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 60) {
                    result.add(name);
                    break;
                }
            }
        }
        
        // 3. 결과를 사전순으로 정렬
        Collections.sort(result);
        return result;
    }
}
```

이 솔루션의 주요 특징과 시간 복잡도를 설명해보겠다.

1. **시간 복잡도**
    - 입력 데이터를 HashMap에 저장: O(N)
    - 각 직원의 시간 정렬: O(M log M) (M은 각 직원의 사용 횟수)
    - 슬라이딩 윈도우로 확인: O(M)
    - 결과 정렬: O(K log K) (K는 경고 대상 직원 수)
    - 전체 시간 복잡도: O(N + M log M)

2. **공간 복잡도**
    - HashMap에 모든 데이터 저장: O(N)

3. **주요 구현 포인트**
    - 시간을 분 단위로 변환하여 비교를 용이하게 함
    - 슬라이딩 윈도우 기법을 사용하여 효율적으로 1시간 이내 사용 확인
    - HashMap을 사용하여 직원별 데이터를 빠르게 조회

이 구현은 문제의 요구사항을 효율적으로 만족시키면서도, 코드의 가독성과 유지보수성을 고려한 방식이이다.