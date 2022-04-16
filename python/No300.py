# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/16 21:25:48
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def lengthOfLIS(self, nums):
        size = len(nums)
        result = 1
        dp = [1] * size

        for i in range(1, size):
            for j in range(0, i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j]+1)
            result = max(result, dp[i])
        return result

s = Solution()
print(s.lengthOfLIS([10,9,2,5,3,7,101,18]))