package coding.test.leetcode.cannot.Hard._295;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    private Queue<Integer> q;

    public MedianFinder() {
        this.q = new PriorityQueue<>();
    }

    public void addNum(int num) {
        this.q.offer(num);
    }

    public double findMedian() {
        int qSize = this.q.size();
        if (qSize % 2 == 0) {
            int sum = 0;
            for (Integer i : q) {
                sum += i;
            }
            return (double) sum / qSize;
        } else {
            int middleIndex = (int) Math.ceil((double) qSize / 2) - 1;
            Queue<Integer> copyQ = new PriorityQueue<>(q);
            for (int i = 0; i < middleIndex; i++) {
                copyQ.poll();
            }
            return copyQ.poll();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
