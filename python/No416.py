# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/09 11:04:25
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def canPartition(self, nums):
        sum0 = sum(nums)
        if sum0 % 2 == 1:
            return False
        target = int(sum0/2)
        dp = [0] * (target+1)
        
        for i in range(len(nums)):
            for j in range(target, nums[i]-1, -1):
                if j >= nums[i]:
                    dp[j] = max(dp[j], dp[j-nums[i]]+nums[i])
                #else:
                #    dp[j] = dp[j]
        return dp[target]==target

s = Solution()
print(s.canPartition([1,5,11,5]))