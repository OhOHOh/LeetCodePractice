# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/10 22:33:55
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def coinChange(self, coins, amount):
        '''
        给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
        计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
        你可以认为每种硬币的数量是无限的。
        '''
        dp = [amount+1] * (amount+1)
        dp[0] = 0
        
        for i in range(len(coins)):
            for j in range(amount+1):
                if j>=coins[i] and dp[j-coins[i]]!=(amount+1):
                    dp[j] = min(dp[j], dp[j-coins[i]]+1)
        
        return dp[amount] if dp[amount]!=(amount+1) else -1
