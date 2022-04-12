# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/12 22:09:44
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def rob(self, nums):
        if len(nums) == 1:
            return nums[0]
        elif len(nums) == 2:
            return max(nums[0], nums[1])
        rtn1 = self.rob_helper(nums[1:])
        rtn2 = self.rob_helper(nums[:-1])
        return max(rtn1, rtn2)

    def rob_helper(self, nums):
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i-2]+nums[i], dp[i-1])
        return dp[-1]