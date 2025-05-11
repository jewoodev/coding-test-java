## [파일명 정렬](https://school.programmers.co.kr/learn/courses/30/lessons/17686)

이 문제는 파일명을 HEAD, NUMBER, TAIL로 분리하여 정렬하는 문제이다. 주요 요구사항은 다음과 같다.

1. HEAD는 숫자가 아닌 문자로 이루어진 부분
2. NUMBER는 1~5자리의 연속된 숫자
3. TAIL은 나머지 부분
4. 정렬 기준:
    - HEAD 부분을 대소문자 구분 없이 사전순으로 정렬
    - HEAD가 같으면 NUMBER를 숫자 순서로 정렬
    - HEAD와 NUMBER가 같으면 원래 입력 순서 유지

이를 해결하기 위한 Java 코드를 살펴보자.

1. **전체 구조**

```java
public String[] solution(String[] files) {
    Arrays.sort(files, (a, b) -> {
        // 정렬 로직
    });
    return files;
}
```

- `Arrays.sort()`를 사용해 파일명 배열을 정렬한다.
- 람다식을 사용해 정렬 기준을 정의한다.

2. **파일명 분리 메서드**(`split`)

```java
private String[] split(String s) {
    String[] result = new String[2];
    StringBuilder sb = new StringBuilder();
    
    // HEAD 부분 추출
    int i = 0;
    for (i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            break;
        }
        sb.append(c);
    }
    result[0] = sb.toString();
    
    // NUMBER 부분 추출
    sb = new StringBuilder();
    while (i < s.length() && Character.isDigit(s.charAt(i))) {
        sb.append(s.charAt(i++));
    }
    result[1] = sb.length() == 0 ? "0" : sb.toString();
    
    return result;
}
```

- 파일명을 HEAD와 NUMBER 두 부분으로 분리한다.
- StringBuilder를 사용하여 문자열을 효율적으로 처리한다.
- HEAD: 첫 번째 숫자가 나오기 전까지의 모든 문자
- NUMBER: 연속된 숫자들
- NUMBER가 없는 경우 "0"을 기본값으로 설정

3. **정렬 로직**

```java
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
```

- 두 파일명을 비교할 때:
  1. 먼저 HEAD 부분을 대소문자 구분 없이 비교 (toLowerCase() 사용)
  2. HEAD가 같으면 NUMBER 부분을 숫자로 변환하여 비교
  3. HEAD가 다르면 HEAD의 사전순 비교 결과를 반환

이 코드는 파일명 정렬 문제를 해결하는 데 효과적이며, 파일명 분리 메서드를 사용하여 코드를 더 읽기 쉽게 만들어준다.

4. **주요 특징**
   - 효율성: StringBuilder를 사용하여 문자열 연산을 최적화
   - 안정성: NUMBER가 없는 경우에 대한 예외 처리
   - 가독성: 람다식을 사용하여 정렬 로직을 명확하게 표현

5. **시간 복잡도**
   - 정렬: O(n log n)
   - 각 파일명 분리: O(m) (m은 파일명의 길이)
   - 전체 시간 복잡도: O(n log n * m)

6. **예시 동작**

```text
입력: ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]

1. "img12.png" 분석:
   - HEAD: "img"
   - NUMBER: "12"

2. "img10.png" 분석:
   - HEAD: "img"
   - NUMBER: "10"

3. 정렬 결과:
   ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
```

이 해결방법은 문제의 모든 요구사항을 만족하면서도, 코드가 간결하고 이해하기 쉽다. 특히 람다식을 사용한 정렬 로직과 StringBuilder를 활용한 문자열 처리가 코드의 효율성과 가독성을 높이는 데 기여했다.
