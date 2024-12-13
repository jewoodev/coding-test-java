# 498. Diagonal Traverse

문제 링크: [링크](https://leetcode.com/problems/diagonal-traverse/description/)

규칙을 찾아내서 그 규칙대로 인덱싱하는 순서(?) 알고리즘을 구현하는 문제라고 파악했는데, 규칙 찾기가... 감이 안잡힌다.

---

## 이동 방향 정의

먼저 이동 방향 두가지가 필요하다.

- 위로 대각선 이동: 행 인덱스 감소(-1), 열 인덱스 증가(+1)
- 아래로 대각선 이동: 행 인덱스 증가(+1), 열 인덱스 감소(-1)

```java
int[][] moveVertical = new int[][]{{-1, 1}, {1, -1}};
```

## 초기 변수 설정

- 행렬의 크기(`m` x `n`)를 계산한다.
- 현재 위치를 나타내는 인덱스(row, col)와 현재 방향을 나타내는 변수(direction)을 초기화한다.

```java
int m = mat.length;
int n = mat[0].length;
int[] arr = new int[m * n];
row = col = 0;
int idx = 0;
int direction = 0;
```

## 반복적으로 대각선 이동

- 행렬의 모든 요소를 읽을 때까지 반복한다.
- 현재 위치의 값을 결과 리스트에 추가한다.
- 다음 위치로 이동한다. (현재 방향에 따라 row, col 업데이트)

```java
while (idx < m * n) {
arr[idx++] = mat[row][col]; // 현재 위치 값을 결과에 입력

row += moveVertical[direction][0];
col += moveVertical[direction][1];
```

## 경계 조건 처리

- 경계를 벗어났을 때, 다음 이동 방향 및 위치를 수정해야 한다.
    - 위로 대각선 이동 중 경계 도달.
        - 첫 행에 도달하면 열을 증가시키고, 방향을 바꿈.
        - 마지막 열에 도달하면 행을 증가시키고, 방향을 바꿈.
    - 아래로 대각선 이동 중 경계 도달.
        - 첫 열에 도달하면 행을 증가시키고, 방향을 바꿈.
        - 마지막 행에 도달하면 열을 증가시키고, 방향을 바꿈.

```java
if (row < 0 || row >= m || col < 0 || col >= n) {
    if (direction == 0) { // 위로 이동 중
        if (col >= n) { // 마지막 열에 도달
            row += 2;
            col -= 1;
        } else if (row < 0) { // 첫 행에 도달
            row = 0;
        }
        direction = 1; // 방향 전환
    } else { // 아래로 이동 중
        if (row >= m) {
            col += 2;
            row -= 1;
        } else if (col < 0) { // 첫 열에 도달
            col = 0;
        }
        direction = 0; // 방향 전환
    }
}
```