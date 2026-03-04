package coding.test.besuccessfulapplicants.array;

import java.util.*;

class MockExam { // https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=java,
    private static int[][] patterns = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
    };
    private static int[] length = {5,8,10};

    public int[] solution(int[] answers) {
        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (patterns[j][i % length[j]] == answers[i]) {
                    scores[j]++;
                }
            }
        }
        int maxScore = Arrays.stream(scores).max().getAsInt();

        List<Integer> scorer = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (maxScore == scores[i])
                scorer.add(i);
        }
        return scorer.stream().mapToInt(i -> i + 1).toArray();
    }
}
