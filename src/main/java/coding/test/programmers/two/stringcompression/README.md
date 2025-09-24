## [문자열 압축](https://school.programmers.co.kr/learn/courses/30/lessons/60057)

이 문제는 **문자열 압축** 문제로, 주어진 문자열을 가장 짧게 압축하는 방법을 찾아야 한다. 풀이의 접근 방법과 논리를 자세히 살펴보자.

## 문제 접근 방법

### 1. 기본 아이디어
- 문자열을 일정한 단위로 잘라서 **연속으로 반복되는 패턴**을 찾는다.
- 반복되는 패턴은 **숫자 + 패턴** 형태로 압축한다.
- 모든 가능한 단위 길이를 시도해서 **가장 짧은 압축 결과**를 찾는다.

### 2. 핵심 논리

```java
// 초기값: 압축하지 않은 원본 길이
int answer = s.length();

// 1단위는 압축 불가능하므로 2단위부터 시작
// 문자열 길이의 절반까지만 시도 (그 이상은 의미 없음)
for (int cnt = 2; cnt <= s.length() / 2; cnt++) {
```

**왜 `s.length() / 2`까지만 시도할까?**
- 예: 문자열 길이가 10이면, 6단위로 자르면 최대 1개 패턴만 나옴
- 압축 효과가 없으므로 절반까지만 확인하면 충분

### 3. 문자열 분할 및 비교 과정

```java
while (i < s.length()) {
    StringBuilder tmp = new StringBuilder();
    // cnt 길이만큼 문자열을 잘라냄
    for (int j = 0; j < cnt; j++) {
        if (i == s.length()) break;
        tmp.append(s.charAt(i++));
    }
    
    String target = tmp.toString();
```

이 부분에서는:
1. **현재 위치(`i`)에서 `cnt` 길이만큼 문자열을 자른다.**
2. 문자열 끝에 도달하면 중단한다.

### 4. 패턴 압축 로직

```java
if (cur.equals(target)) {
    count++;  // 같은 패턴이 반복되면 카운트 증가
} else {
    // 다른 패턴이 나오면 이전 패턴을 결과에 추가
    sb.append(count == 1 ? "" : String.valueOf(count)).append(cur);
    cur = target;   // 새로운 패턴으로 교체
    count = 1;      // 카운트 초기화
}
```


**압축 규칙:**
- `count == 1`: 한 번만 나타나면 숫자 없이 패턴만 추가
- `count > 1`: 여러 번 반복되면 "숫자 + 패턴" 형태로 추가

### 5. 실행 예시

문자열 `"aabbaccc"`를 2단위로 압축하는 과정:

```
원본: a a b b a c c c
2단위로 분할: "aa" "bb" "aa" "cc" + "c"

1. cur="", target="aa" → cur="aa", count=1
2. cur="aa", target="bb" → 결과에 "aa" 추가, cur="bb", count=1  
3. cur="bb", target="aa" → 결과에 "bb" 추가, cur="aa", count=1
4. cur="aa", target="cc" → 결과에 "aa" 추가, cur="cc", count=1
5. 남은 "c" 처리

최종 결과: "aa" + "bb" + "aa" + "cc" + "c" = "aabbaaccc" (길이: 9)
```

### 6. 최적해 찾기

```java
answer = Math.min(answer, sb.length());
```

모든 단위 길이에 대해 압축을 시도한 후, **가장 짧은 길이**를 선택한다.

## 시간 복잡도

- **외부 루프**: O(n/2) = O(n)
- **내부 문자열 처리**: O(n)
- **전체**: O(n²)

이 알고리즘은 **완전 탐색** 방식으로 모든 가능한 압축 단위를 시도해서 최적해를 찾는 **브루트 포스** 접근법이다.