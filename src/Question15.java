// Question 15: Sliding Window Maximum

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Question15 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.peekFirst() <= i - k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[q.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ans = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}