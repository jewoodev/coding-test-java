# 394. Decode String

문제 링크: [링크](https://leetcode.com/problems/decode-string/description/)

Recursion을 활용해야 할 것 같은데 어떻게 해야할지 고민하다가 끝내 길을 찾지 못한 문제이다. 좋으면서 어려운 문제.

---

자료구조를 별도로 사용하지 않고 조건으로 해당 인덱스의 문자를 판단하고 문자열을 붙여대는 식으로 풀면 로직의 복잡성이 줄어든다.

```java
class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                String inner = decodeString(s);
                for (int i = 0; i < count; i++) {
                    sb.append(inner);
                }
                count = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
```