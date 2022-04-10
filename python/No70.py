# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/06 23:52:52
@Author  :   Yu Runshen 
@License :   (C)Copyright 2017-2018, Liugroup-NLPR-CASIA
'''

# here put the import lib
import sys, os

class Solution:
    def climbStairs(self, n):
        if n == 1:
            return 1
        elif n == 2:
            return 2
        dp = [0] * (n+1)
        dp[1] = 1
        dp[2] = 2
        for i in range(3, n+1):
            dp[i] = dp[i-1] + dp[i-2]
        return dp[n]
    
    def climbStairs_more(self, n, m):
        '''
        爬楼梯进阶版, 如果爬一次可以爬 1,2,3,... m 阶台阶, 请问一共有多少种爬的方式
        其实是一个完全背包问题
        '''
        dp = [0] * (n+1)
        dp[0] = 1
        
        # 遍历背包
        for i in range(n+1):
            # 遍历物品
            for step in range(1, m+1):
                if i >= step:
                    dp[i] += dp[i-step]
        
        return dp[n]

s = Solution()
print(s.climbStairs(4))
print(s.climbStairs_more(4,2))