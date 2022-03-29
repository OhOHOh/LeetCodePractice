# -*- coding: UTF-8 -*-

from sympy import N


class Solution:
    def __init__(self):
        self.g_rtn = []

    def generateParenthesis(self, n):
        self.dfs(n, n, "")
        return self.g_rtn
    
    def dfs(self, m, n, tmp_res):
        if m == 0:
            self.g_rtn.append(tmp_res+')'*n)
            return
        if m < n:
            self.dfs(m-1, n, tmp_res+'(')
            self.dfs(m, n-1, tmp_res+')')
        elif m == n:
            self.dfs(m-1, n, tmp_res+'(')
        return
s = Solution()
print(s.generateParenthesis(3))