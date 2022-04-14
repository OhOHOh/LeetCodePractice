# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/13 23:28:53
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def maxProfit_brute(self, prices):
        '''
        暴力解法
        '''
        size = len(prices)
        result = 0
        for i in range(size):
            for j in range(i+1, size):
                if prices[j] >= prices[i]:
                    result = max(result, prices[j]-prices[i])
        return result
    
    def maxProfit_greedy(self, prices):
        '''
        贪心算法, 最左侧的最小值和最右侧的最大值之间差值
        '''
        size = len(prices)
        result = 0
        min_price = 10000000
        for i in range(size):
            min_price = min(min_price, prices[i])
            result = max(result, prices[i]-min_price)
        return result
    
    def maxProfit(self, prices):
        '''
        DP, 
            dp[i][0]: 第i天持有股票时的现金
            dp[i][1]: 第i天不持有股票时的现金
        '''
        size = len(prices)
        dp = [[0,0] for _ in range(size)]
        dp[0][0] = -prices[0]
        dp[0][1] = 0
        
        for i in range(1, size):
            dp[i][0] = max(dp[i-1][0], -prices[i])
            dp[i][1] = max(dp[i-1][1], dp[i-1][0]+prices[i])
        return dp[size-1][1]