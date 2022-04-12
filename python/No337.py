# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/12 22:36:46
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.memory = {}
    
    def rob(self, root):
        '''
        dp
        '''
        def rob_tree(root):
            if root is None:
                return (0, 0)
            if root.left is None and root.right is None:
                return (root.val, 0)
            left = rob_tree(root.left)
            right = rob_tree(root.right)
            # 偷当前节点
            val1 = root.val + left[1] + right[1]
            # 不偷当前节点
            val2 = max(left[0], left[1]) + max(right[0], right[1])
            return (val1, val2)

        result = rob_tree(root)
        return max(result[0], result[1])
    

    def rob_dfs_1(self, root):
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return root.val
        # 偷root节点
        val1 = root.val
        if root.left:
            val1 += self.rob_dfs_1(root.left.left) + self.rob_dfs_1(root.left.right) 
        if root.right:
            val1 += self.rob_dfs_1(root.right.left) + self.rob_dfs_1(root.right.right)
        # 不偷root节点
        val2 = self.rob_dfs_1(root.left) + self.rob_dfs_1(root.right)
        return max(val1, val2)
    

    def rob(self, root):
        '''
        记忆化递归, 使用dict保存中间变量
        '''
        if root is None:
            return 0
        if root.left is None and root.right is None:
            return root.val
        if self.memory.get(root) is not None:
            return self.memory.get(root)

        # 偷root节点
        val1 = root.val
        if root.left:
            val1 += self.rob(root.left.left) + self.rob(root.left.right) 
        if root.right:
            val1 += self.rob(root.right.left) + self.rob(root.right.right)
        # 不偷root节点
        val2 = self.rob(root.left) + self.rob(root.right)
        self.memory[root] = max(val1, val2)
        return max(val1, val2)