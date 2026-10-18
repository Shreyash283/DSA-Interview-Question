public class Question6 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    static class Maxpath {
        private int maxSum;

        public int maxPathSum(TreeNode root) {
            maxSum = Integer.MIN_VALUE;
            calculateMaxGain(root);
            return maxSum;
        }

        private int calculateMaxGain(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftGain = Math.max(0, calculateMaxGain(node.left));
            int rightGain = Math.max(0, calculateMaxGain(node.right));
            int currentPathSum = node.val + leftGain + rightGain;

            maxSum = Math.max(maxSum, currentPathSum);

            return node.val + Math.max(leftGain, rightGain);
        }
    }

    public static void main(String[] args) {
        // Tree: [-10, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Maxpath m1 = new Maxpath();
        int result = m1.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + result);
    }
}