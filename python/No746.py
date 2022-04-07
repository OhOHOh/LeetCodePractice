# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/07 10:02:49
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def minCostClimbingStairs(self, cost):
        size = len(cost)
        if size == 1:
            return cost[0]
        elif size == 2:
            return min(cost)
        dp = [0] * size
        dp[0] = cost[0]
        dp[1] = cost[1]
        for i in range(2, size):
            dp[i] = min(dp[i-1], dp[i-2]) + cost[i]
        
        return min(dp[size-1], dp[size-2])