package Offer;

import java.util.Arrays;

/**
 *  输入某二叉树的 前序遍历 和 中序遍历 的结果，请重建出该二叉树
 */

public class No6 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        if (pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);

        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
                break;
            }
        }

        return root;
    }
}
