package coding.test.leetcode.cannot.hard._295;

import java.util.*;

class MedianFinder {

    private int index = 0;
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        index++;
        if (index % 2 == 0) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
            minHeap.offer(maxHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (index % 2 != 0) {
            return maxHeap.peek();
        } else {
            int fromMax = maxHeap.peek();
            int fromMin = minHeap.peek();
            return (fromMin + fromMax) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
