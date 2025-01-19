# 358. Rearrange String k Distance Apart

문자열 s와 정수 k가 주어졌을 때, 문자열 s를 각 문자들이 최소 k 거리만큼 떨어지도록 재배치하세요. 여러 결과가 가능하면 한 가지만 출력하고 만약 재배치할 수 없다면 빈 문자열 “”를 리턴합니다.

## Example 

예제 1:
- 입력: s = “aabbcc”, k = 3 
- 출력: “abcabc”

예제 2:
- 입력: s = “aaabc”, “k = 3 
- 출력: “” 
- 설명: a를 3만큼 떨어지게 재배치할 수 없습니다

예제 3:
- 입력: s = “aaadbbcc”, k = 2 
- 출력: “abacabcd”

예제 4:
- 입력: s = “mmpp”, k = 2 
- 출력: “mpmp” 혹은 “pmpm”

예제 5:
- 입력: “programming”, k = 3 
- 출력: “rgmprgmiano”

예제 6:
- 입력: “aab”, k = 2 
- 출력: “aba”

예제 7:
- 입력: “abcdabcdabeeffa”, k = 4 
- 출력: “abedacbfadcbfae”

## 제약사항

- 1 <= s.length <= 3 * 10^5 
- s는 영소문자로만 이루어져있습니다 
- 0 <= k <= s.length





제약사항:
1 <= s.length <= 3 * 10^5
s는 영소문자로만 이루어져있습니다
0 <= k <= s.length

구현할 method:
public String rearrangeString(String s, int k) {
// implementation
}
