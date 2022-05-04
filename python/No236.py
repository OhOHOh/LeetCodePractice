# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/28 19:38:07
@Author  :   Yu Runshen 

求树中2个节点的最近公共祖先
'''

# here put the import lib
import sys, os

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root, p, q):
        return self.dfs(root, p, q)
    
    def dfs(self, root, p, q):
        if root==q or root==p or root is None:
            return root
        left = self.dfs(root.left, p, q)
        right = self.dfs(root.right, p, q)
        if not left and right:
            return right
        elif left and not right:
            return left
        elif left and right:
            return root
        else:
            return None