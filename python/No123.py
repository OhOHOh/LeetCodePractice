# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/14 21:49:07
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def maxProfit_dfs(self, prices):
        def dfs(prices, index, hasStock, counts):
            if index==len(prices) or (counts>=2):
                return 0
            # 手里有股票, 可以选择卖或者不卖
            if hasStock>0:
                return max(dfs(prices, index+1, hasStock-1, counts+1)+prices[index], dfs(prices, index+1, hasStock, counts))
            # 手里没有股票, 可以选择买或者不买
            return max(dfs(prices, index+1, hasStock+1, counts)-prices[index], dfs(prices, index+1, hasStock, counts))
        result = dfs(prices, 0, 0, 0)
        return result
    
    def maxProfit(self, prices):
        '''
        DP:
            dp[i][0]: 第i天是无操作状态
            dp[i][1]: 第i天是第一次买入状态
            dp[i][2]: 第i天是第一次卖出状态
            dp[i][3]: 第i天是第二次买入状态
            dp[i][4]: 第i天是第二次卖出状态
        '''
        size = len(prices)
        dp = [[0,0,0,0,0] for _ in range(size)]
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        dp[0][2] = 0
        dp[0][3] = -prices[0]
        dp[0][4] = 0
        for i in range(1, size):
            dp[i][0] = dp[i-1][0]
            dp[i][1] = max(dp[i-1][0]-prices[i], dp[i-1][1])
            dp[i][2] = max(dp[i-1][1]+prices[i], dp[i-1][2])
            dp[i][3] = max(dp[i-1][2]-prices[i], dp[i-1][3])
            dp[i][4] = max(dp[i-1][3]+prices[i], dp[i-1][4])
        return dp[size-1][4]

s = Solution()
print(s.maxProfit_dfs([3,3,5,0,0,3,1,4]))
print(s.maxProfit_dfs([1,2,3,4,5]))
print(s.maxProfit_dfs([7,6,4,3,1]))

print(s.maxProfit([3,3,5,0,0,3,1,4]))
print(s.maxProfit([1,2,3,4,5]))
print(s.maxProfit([7,6,4,3,1]))