# 402. [Remove K Digits](https://leetcode.com/problems/remove-k-digits/description/)

새로운 수를 스택에 넣기 전에 맨 위의 수가 자신보다 크면, 그걸 꺼내고 자신을 집어넣으며 k를 하나 차감해주는 걸 이어가면 풀 수 있다.

근데 스택에 모든 수를 넣었는데 k가 남는다면, 