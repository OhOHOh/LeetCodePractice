# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/11 21:44:54
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def numSquares(self, n):
        dp = [n+1] * (n+1)
        dp[0] = 0
        
        # 创建物品list
        nums = [i**2 for i in range(1, n+1) if i**2<=n]
        
        # 遍历物品
        for i in nums:
            # 遍历背包
            for j in range(n+1):
                if j >= i:
                    dp[j] = min(dp[j-i]+1, dp[j])
        return dp[n]

s = Solution()
print(s.numSquares(11))