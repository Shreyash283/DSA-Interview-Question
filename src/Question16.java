// Question: Rotting Oranges

import java.util.LinkedList;
import java.util.Queue;

public class Question16 {

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount = freshCount + 1;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] d : directions) {
                    int newR = r + d[0];
                    int newC = c + d[1];

                    if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2; // Sada diya
                        freshCount = freshCount - 1;
                        queue.add(new int[]{newR, newC});
                    }
                }
            }

            minutes = minutes + 1;
        }
        if (freshCount == 0) {
            return minutes;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid1));

        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println(orangesRotting(grid2));
    }
}