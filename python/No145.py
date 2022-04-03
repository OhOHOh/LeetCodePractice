# -*- coding: UTF-8 -*-

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def postorderTraversal(self, root):
        result = []
        def dfs(root):
            if root:
                dfs(root.left)
                dfs(root.right)
                result.append(root.val)
        dfs(root)
        return result

    def postorderTraversal_1(self, root):
        if root is None:
            return []
        result = []
        stack = list()
        stack.append(root)
        while len(stack) > 0:
            top = stack.pop()
            result.append(top.val)
            if top.left:
                stack.append(top.left)
            if top.right:
                stack.append(top.right)
        result.reverse()
        return result