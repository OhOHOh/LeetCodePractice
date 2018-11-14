public class No129 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, root.val);
        return sum;
    }

    public void dfs(TreeNode root, int num) {
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        if (root.left != null) {
            dfs(root.left, num*10+root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, num*10+root.right.val);
        }
    }
}
