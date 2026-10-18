public class Question7 {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValid(root, null, null);
        }

        private boolean isValid(TreeNode node, Long min, Long max) {
            if (node == null) {
                return true;
            }

            if (min != null && node.value <= min) {
                return false;
            }

            if (max != null && node.value >= max) {
                return false;
            }

            return isValid(node.left, min, (long) node.value)
                    && isValid(node.right, (long) node.value, max);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution sol = new Solution();
        System.out.println(sol.isValidBST(root));
    }
}