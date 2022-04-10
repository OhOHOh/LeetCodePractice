# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/09 21:36:41
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def change(self, amount, coins):
        dp = [0] * (amount+1)
        dp[0] = 1
        
        for i in range(len(coins)):
            for j in range(coins[i], amount+1):
                dp[j] += dp[j-coins[i]]
        return dp[amount]

s = Solution()
print(s.change(3, [2]))