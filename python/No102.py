# -*- coding: UTF-8 -*-

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def levelOrder(self, root):
        if root is None:
            return []
        result = []
        q = deque()
        q.append(root)
        level_size = 1
        tmp = []
        while len(q) > 0:
            tmp = []
            level_size = len(q)
            for i in range(level_size):
                top = q.popleft()
                tmp.append(top.val)
                if top.left:
                    q.append(top.left)
                if top.right:
                    q.append(top.right)
            result.append(tmp)
        return result