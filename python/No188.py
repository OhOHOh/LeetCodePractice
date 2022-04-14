# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/14 22:41:37
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def maxProfit(self, k, prices):
        size = len(prices)
        dp = [[0]*(2*k+1) for _ in range(size)]
        # 初始化
        for i in range(1, 2*k, 2):
            dp[0][i] = -prices[0]
        for i in range(1, size):
            for j in range(0, 2*k-1, 2):
                dp[i][j+1] = max(dp[i-1][j]-prices[i], dp[i-1][j+1])
                dp[i][j+2] = max(dp[i-1][j+1]+prices[i], dp[i-1][j+2])
        return dp[-1][2*k]