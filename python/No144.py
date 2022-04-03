# -*- coding: UTF-8 -*-

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def preorderTraversal(self, root):
        rtn = []
        def dfs(root):
            if root:
                rtn.append(root.val)
                dfs(root.left)
                dfs(root.right)
        dfs(root)
        return rtn

    def preorderTraversal_1(self, root):
        if root is None:
            return []
        rtn = []
        stack = list()
        stack.append(root)
        while len(stack) > 0:
            tmp = stack.pop()
            rtn.append(tmp.val)
            if tmp.right:
                stack.append(tmp.right)
            if tmp.left:
                stack.append(tmp.left)
        return rtn