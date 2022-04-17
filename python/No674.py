# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/17 22:49:22
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def findLengthOfLCIS(self, nums):
        size = len(nums)
        if size == 1:
            return 1
        result = 0
        dp = [1] * size
        for i in range(1, size):
            if nums[i] > nums[i-1]:
                dp[i] = dp[i-1] + 1
                result = max(result, dp[i])
        return result

s = Solution()
print(s.findLengthOfLCIS([1,3,5,4,7]))