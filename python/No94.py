# -*- coding: UTF-8 -*-

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorderTraversal(self, root):
        '''
        中序遍历, 迭代
        '''
        if root is None:
            return []
        result = []
        stack = list()
        cur = root
        while cur or len(stack) > 0:
            if cur:
                stack.append(cur)
                cur = cur.left
            else:
                top = stack[-1]
                stack.pop()
                result.append(top.val)
                cur = top.right
        return result
            
    def inorderTraversal_1(self, root):
        result = []
        def dfs(root):
            if root:
                dfs(root.left)
                result.append(root.val)
                dfs(root.right)
        dfs(root)
        return result