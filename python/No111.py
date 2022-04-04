# -*- coding: UTF-8 -*-

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def minDepth(self, root):
        if root is None:
            return 0
        return self.dfs(root)
    
    def dfs(self, root):
        if root is None:
            return 0
        left_h = self.dfs(root.left)
        right_h = self.dfs(root.right)
        if root.left and not root.right:
            return 1+left_h
        if root.right and not root.left:
            return 1+right_h
        return 1+min(left_h, right_h)