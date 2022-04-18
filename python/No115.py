# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/18 23:32:41
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def numDistinct(self, s, t):
        m, n = len(s), len(t)
        dp = [[0]*(n+1) for _ in range(m+1)]
        # 初始化
        for i in range(m+1):
            dp[i][0] = 1
        # 遍历
        for i in range(1, m+1):
            for j in range(1, n+1):
                if s[i-1] == t[j-1]:
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]
        return dp[m][n]

s = Solution()
print(s.numDistinct(s = "babgbag", t = "bag"))