# [level 2] [3차] 압축 - 17684 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/17684) 

## 1. 기본 개념

LZW 압축은 다음과 같은 원리로 작동한다.

- 사전에 초기 단어들을 미리 등록
- 입력 문자열을 순차적으로 처리하면서 가장 긴 매칭 문자열을 찾음
- 매칭된 문자열의 인덱스를 출력하고 새로운 문자열을 사전에 추가

## 2. 코드 분석

1. **초기화 부분**
   ```java
	Map<String, Integer> map = new HashMap<>();
	int idx = 27;
	for (int i = 0; i < 26; i++) {
		map.put(String.valueOf((char) (i + 'A')), (i + 1));
	}
	```

   - A부터 Z까지의 단일 문자를 1 ~ 26번 인덱스로 초기화
   - 다음 추가될 문자열은 27번부터 시작
2. **압축 로직**
	```java
	StringBuilder sb = new StringBuilder();
	int i = 0;
	while (true) {
		sb.append(msg.charAt(i++));

		int tmp = 0;
		while (i < msg.length() && map.containsKey(sb.toString())) {
			tmp = map.get(sb.toString());
			sb.append(msg.charAt(i++));
		}
	}
	```

   - `StringBuilder`를 사용해 현재 처리 중인 문자열을 저장
   - 현재 문자열이 사전에 있는 동안 계속 다음 문자를 추가
   - `tmp`에 마지막으로 매칭된 문자열의 인덱스를 저장
3. **결과 처리**
	```java
	if (i == msg.length()) {
		if (map.containsKey(sb.toString())) {
			list.add(map.get(sb.toString()));
		} else {
			list.add(tmp);
			list.add(map.get(String.valueOf(msg.charAt(i - 1))));
		}
		break;
	}
	```

	- 문자열 끝에 도달했을 때의 처리
	- 마지막 문자열이 사전에 있으면 그 인덱스를 추가
	- 없으면 마지막 매칭된 문자열과 마지막 문자의 인덱스를 각각 추가
4. **새로운 문자열 등록**
	```java
	list.add(tmp);
	map.put(sb.toString(), idx++);
	i--;
	sb = new StringBuilder();
	```

	- 매칭된 문자열의 인덱스를 결과 리스트에 추가
	- 현재 문자열을 사전에 새로 등록
	- 인덱스를 하나 되돌리고 새로운 문자열 처리를 시작

## 3. 예시 : "KAKAO" 처리 과정
1. "K" 처리
   - "K"는 사전에 있음 (11번)
   - "KA"는 없으므로 11을 출력하고 "KA"를 27번으로 등록
2. "A" 처리
   - "A"는 사전에 있음 (1번)
   - "AK"는 없으므로 1을 출력하고 "AK"를 28번으로 등록
3. "KA" 처리
   - "KA"는 사전에 있음 (27번)
   - "KAO"는 없으므로 27을 출력하고 "KAO"를 29번으로 등록
4. "O" 처리
   - "O"는 사전에 있음 (15번)
   - 마지막 문자이므로 15를 출력

결과: [11, 1, 27, 15]

## 4. 성능 분석
- 시간 복잡도: O(n), n은 입력 문자열의 길이
- 공간 복잡도: O(n), 사전의 크기가 입력에 따라 증가
- 메모리 사용: 83MB
- 실행 시간: 4.02ms

이 알고리즘은 문자열을 효율적으로 압축하면서도 원본을 완벽하게 복원할 수 있는 무손실 압축 방식이다.