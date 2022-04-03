# -*- coding: UTF-8 -*-

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def levelOrderBottom(self, root):
        if root is None:
            return []
        result = []
        q = deque()
        q.append(root)
        tmp = []
        while len(q) > 0:
            level_size = len(q)
            tmp = []
            for i in range(level_size):
                top = q.popleft()
                tmp.append(top.val)
                if top.left:
                    q.append(top.left)
                if top.right:
                    q.append(top.right)
            result.append(tmp)
        result.reverse()
        return result