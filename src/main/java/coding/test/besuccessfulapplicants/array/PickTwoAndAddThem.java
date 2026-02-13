package coding.test.besuccessfulapplicants.array;

import java.util.*;

class PickTwoAndAddThem { // https://school.programmers.co.kr/learn/courses/30/lessons/12949
    public int[] solution(int[] numbers) {
        Set<Integer> temp = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                temp.add(numbers[i] + numbers[j]);
            }
        }

        return temp.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
