# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/20 23:06:47
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def minSubArrayLen(self, target, nums):
        result = sys.maxsize
        i = 0
        sum = 0
        
        for j in range(len(nums)):
            sum += nums[j]
            while sum >= target:
                length = j - i + 1
                result = min(result, length)
                sum -= nums[i]
                i += 1
        return 0 if result==sys.maxsize else result

s = Solution()
print(s.minSubArrayLen(target = 7, nums = [2,3,1,2,4,3]))