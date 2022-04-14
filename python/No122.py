# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/05 19:43:20
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def maxProfit_greedy(self, prices):
        if len(prices) <= 1:
            return 0
        result = 0
        for i in range(1, len(prices)):
            result += max(prices[i]-prices[i-1], 0)
        return result
    
    def maxProfit(self, prices):
        if len(prices) <= 1:
            return 0
        dp = [(0,0) for _ in range(len(prices))]
        dp[0][0] = -prices[0]
        dp[0][1] = 0
        
        for i in range(1, len(prices)):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]-prices[i]) 
            dp[i][1] = max(dp[i-1][1], dp[i-1][0]+prices[i])
        return dp[len(prices)-1][1]

s = Solution()
print(s.maxProfit([7,1,5,3,6,4]))