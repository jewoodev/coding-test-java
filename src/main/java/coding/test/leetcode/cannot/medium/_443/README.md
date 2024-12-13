# 443. String Compression

문제 링크: [링크](https://leetcode.com/problems/string-compression/description/)

알고보니 별도의 자료구조를 사용하지 않고 구현해야 하는데 어떻게 해야 가능한지 모르겠다.

---

입력 배열에서 인덱스를 두 개 사용해, 하나는 읽기 포인터(`read`)로 반복되는 문자를 탐색하고, 다른 하나는 쓰기 포인터(`write`)로 압축된 문자를 저장하는 것으로 별도의 자료구조를 사용하지 않고 구현하는게 가능하다.

