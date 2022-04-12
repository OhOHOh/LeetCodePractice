# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/12 18:03:35
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def rob(self, nums):
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-2]+nums[i], dp[i-1])

        return dp[-1]