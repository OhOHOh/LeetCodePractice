# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/09 17:14:10
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def findMaxForm(self, strs, m, n):
        dp = [[0] * (n+1) for _ in range(m+1)]

        for k in range(len(strs)):
            ones = strs[k].count('1')
            zeros = strs[k].count('0')
            for i in range(m, zeros-1, -1):
                for j in range(n, ones-1, -1):
                    dp[i][j] = max(dp[i][j], dp[i-zeros][j-ones]+1)
        return dp[m][n]