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
