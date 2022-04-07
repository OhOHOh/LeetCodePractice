# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/07 10:07:16
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def uniquePaths(self, m, n):
        dp = [[0] * n for _ in range(m)]
        for i in range(m):
            dp[i][0] = 1
        for i in range(n):
            dp[0][i] = 1
        
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]

        return dp[m-1][n-1]
    
    def uniquePaths_dfs(self, m, n):
        def dfs(i, j, m, n):
            '''
            求二叉树叶子节点个数
            '''
            if i>=m or j>=n:
                return 0
            if i==(m-1) and j==(n-1):
                return 1
            return dfs(i+1, j, m, n) + dfs(i, j+1, m, n)
        return dfs(0,0,m,n)


s = Solution()
print(s.uniquePaths(3, 7))
print(s.uniquePaths_dfs(3, 7))