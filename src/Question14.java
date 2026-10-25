// Question 14: Largest Rectangle in Histogram

import java.util.Stack;

public class Question14 {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currHeight;
            if (i == n) {
                currHeight = 0;
            } else {
                currHeight = heights[i];
            }

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w;

                if (stack.isEmpty()) {
                    w = i;
                } else {
                    w = i - stack.peek() - 1;
                }

                int area = h * w;
                if (area > maxArea) {
                    maxArea = area;
                }
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights1));

        int[] heights2 = {2, 4};
        System.out.println(largestRectangleArea(heights2));
    }
}