public class Question4 {

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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null) {
                return root;
            }
            return (left != null) ? left : right;
        }
    }

    static void testLCA(Solution sol, TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = sol.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " & " + q.val + " -> " + ans.val);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Solution sol = new Solution();


        testLCA(sol, root, root.left, root.right);
        testLCA(sol, root, root.left, root.left.right.right);
        testLCA(sol, root, root.left.left, root.left.right.right);
    }
}