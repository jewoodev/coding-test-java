package hanghae.day1.supplement.failed;

import java.util.LinkedList;
import java.util.Queue;

//다리를 지나는 트럭 https://school.programmers.co.kr/learn/courses/30/lessons/42583
public class TruckPassingBridge {

    private static int answer;

    public static void main(String[] args) {
        System.out.println(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        answer = 0;
        Queue<Car> onStandBy = new LinkedList<>();
        for (Integer i : truck_weights) {
            onStandBy.offer(new Car(i, 0));
        }
        Queue<Car> onBridge = new LinkedList<>();
        while (!onStandBy.isEmpty()) {
            Car truck = onStandBy.peek();
            if (weight - truck.weight >= 0 && onBridge.size() <= bridge_length) {
                insertCar(onStandBy, onBridge);
            } else {
                moveCar(bridge_length, onBridge);
            }
        }
        while (!onBridge.isEmpty()) {
            moveCar(bridge_length, onBridge);
        }
        return answer;
    }

    private static void insertCar(Queue<Car> onStandBy, Queue<Car> onBridge) {
        Car poll = onStandBy.poll();
        poll.move++;
        if (!onBridge.isEmpty()) {
            onBridge.forEach(c -> c.move++);
        }
        onBridge.offer(poll);
        answer++;
    }

    private static void moveCar(int bridge_length, Queue<Car> onBridge) {
        Car peek = onBridge.peek();
        while (peek.move != bridge_length) {
            onBridge.forEach(c -> c.move++);
            answer++;
            peek = onBridge.peek();
        }
        onBridge.poll();
        answer++;
    }

    static class Car {
        int weight;
        int move;

        public Car(int num, int move) {
            this.weight = num;
            this.move = move;
        }
    }
}
