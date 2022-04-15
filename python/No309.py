# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/15 20:17:07
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def maxProfit(self, prices):
        '''
        d[i][0]: 表示买入状态
        d[i][1]: 表示两天前就卖出状态, 并且已经度过了冷冻期
        d[i][2]: 表示今天卖出状态
        d[i][3]: 表示处于冷冻期状态
        '''
        size = len(prices)
        if size <= 1:
            return 0
        dp = [[0,0,0,0] for _ in range(size)]
        dp[0][0] = -prices[0]
        
        for i in range(1, size):
            dp[i][0] = max(dp[i-1][0], max(dp[i-1][3], dp[i-1][1]) - prices[i]);
            dp[i][1] = max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        return max(dp[size-1][3], dp[size-1][1], dp[size-1][2])

s = Solution()
print(s.maxProfit([1,2,3,0,2]))