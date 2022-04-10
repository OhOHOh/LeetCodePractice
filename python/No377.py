# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/10 17:34:39
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def combinationSum4(self, nums, target):
        dp = [0] * (target+1)
        dp[0] = 1
        
        for i in range(target+1):
            for j in range(len(nums)):
                if i >= nums[j]:
                    dp[i] += dp[i-nums[j]]
        
        return dp[target]

s = Solution()
print(s.combinationSum4([1,2,3], 4))