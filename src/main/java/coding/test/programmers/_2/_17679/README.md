## [프렌즈4블록](https://programmers.co.kr/learn/courses/30/lessons/17679)

이런 문제는 원본 배열은 그대로 두고, 복사본을 처리하면서 처리하는게 가장 일반적이다. 제거 작업을 복사본에서 처리하면서 후처리를 할 때 원본을 확인할 필요가 있기 때문이다. 

어떻게 풀이할 수 있는지 살펴보자.

1. **초기 설정**

```java
char[][] map = new char[m][n];
```

입력받은 문자열 배열을 2차원 문자 배열로 변환한다.

2. **메인 로직** (while 루프)

- 게임이 더 이상 진행될 수 없을 때까지 반복한다.

3. **블록 제거 로직**

```java
for (int i = 0; i < m - 1; i++) {
    for (int j = 0; j < n - 1; j++) {
        if (Character.isLetter(map[i][j])
                && map[i][j] == map[i][j + 1]
                && map[i][j] == map[i + 1][j + 1]
                && map[i][j] == map[i + 1][j]) {
            copied[i][j] = '_';
            copied[i][j + 1] = '_';
            copied[i + 1][j] = '_';
            copied[i + 1][j + 1] = '_';
            deleted = true;
        }
    }
}
```

- 2x2 블록이 같은 문자로 이루어져 있는지 확인한다.
- 조건을 만족하면 해당 블록들을 '_'로 표시한다.
- deleted 플래그를 통해 제거된 블록이 있는지 추적한다.

4. **블록 떨어뜨리기 로직**

```java
for (int j = 0; j < map[0].length; j++) {
    Queue<Integer> q = new LinkedList<>();
    for (int i = m - 1; i >= 0; i--) {
        if (map[i][j] == '_') {
            map[i][j] = '!';
            q.add(i);
            answer++;
        } else if (!q.isEmpty()) {
            map[q.poll()][j] = map[i][j];
            q.add(i);
        }
    }
}
```

- 각 열마다 아래에서 위로 순회한다.
- 제거된 블록('_')을 발견하면 큐에 해당 위치를 저장하고 제거된 블록 수를 증가시킨다. 그리고 해당 위치를 '!'로 표시해 재차 조회하지 않도록 만든다.
- 큐가 비어있지 않다면, 위의 블록을 아래로 떨어뜨린다.

5. **보조 메서드**

```java
private char[][] copy(char[][] board) {
    char[][] copied = new char[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
        copied[i] = board[i].clone();
    }

    return copied;
}
```

현재 게임판의 상태를 복사하는 메서드이다.
블록 제거 작업을 수행할 때 원본 데이터를 보존하기 위해 사용된다.
이 풀이의 시간 복잡도는 O(MNK)이다. 여기서:

- M: 보드의 행 수
- N: 보드의 열 수
- K: 블록이 제거되는 횟수

공간 복잡도는 O(MN)이다.

    이 풀이는 다음과 같은 장점이 있다:

- 원본 데이터를 보존하면서 안전하게 블록을 제거할 수 있다.
- 큐를 사용하여 효율적으로 블록을 떨어뜨린다.
- 제거된 블록의 개수를 정확하게 계산할 수 있다.
