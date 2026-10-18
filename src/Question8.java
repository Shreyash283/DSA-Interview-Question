
public class Question8 {
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

    static class Solution {

        int count = 0;
        int result = 0;
        int kthSmallest(TreeNode root, int k) {
            count = 0;
            result = 0;

            inorder(root, k);

            return result;
        }
        void inorder(TreeNode root, int k) {
            if (root == null || count >= k) {
                return;
            }
            inorder(root.left, k);
            if (count >= k) {
                return;
            }
            count++;
            if (count == k) {
                result = root.val;
                return;
            }
            inorder(root.right, k);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        Solution s = new Solution();

        System.out.println(s.kthSmallest(root, 3));
    }
}
