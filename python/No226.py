# -*- coding: UTF-8 -*-

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root):
        if root is None:
            return root
        root = self.dfs(root)
        return root
    
    def dfs(self, root):
        if root is None:
            return None
        tmp = root.left
        root.left = self.dfs(root.right)
        root.right = self.dfs(tmp)
        return root
        