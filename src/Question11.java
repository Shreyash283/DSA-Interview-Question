// Question 11: Find Median from Data Stream

import java.util.Collections;
import java.util.PriorityQueue;

public class Question11 {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public Question11() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.add(num);
        } else {
            large.add(num);
        }

        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        } else if (large.size() > small.size()) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        Question11 tracker = new Question11();

        tracker.addNum(1);
        tracker.addNum(2);
        System.out.println(tracker.findMedian());

        tracker.addNum(3);
        System.out.println(tracker.findMedian());
    }
}