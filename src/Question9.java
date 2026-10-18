
public class Question9 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        int count = 0;
        int result = 0;

        int kthGreatest(TreeNode root, int k) {
            count = 0;
            reverseInorder(root, k);
            return result;
        }

        void reverseInorder(TreeNode root, int k) {
            if (root == null || count >= k) {
                return;
            }
            reverseInorder(root.right, k);
            if (count >= k) {
                return;
            }
            count++;
            if (count == k) {
                result = root.val;
                return;
            }
            reverseInorder(root.left, k);
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

        System.out.println(s.kthGreatest(root, 3));
    }
}
