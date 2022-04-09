# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/09 16:09:21
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def findTargetSumWays(self, nums, target):
        '''
        DP
        '''
        sum0 = sum(nums)
        if (target+sum0) % 2 != 0 or abs(sum0)<abs(target):
            return 0
        bagsize = int((target+sum0) / 2)
        dp = [0] * (bagsize+1)
        dp[0] = 1

        for i in range(len(nums)):
            for j in range(bagsize, nums[i]-1, -1):
                dp[j] += dp[j-nums[i]]
        return dp[bagsize]
        

    def findTargetSumWays_1(self, nums, target):
        sum0 = sum(nums)
        if (target+sum0) % 2 != 0 or sum0 < target:
            return 0
        bagsize = int((target+sum0) / 2)
        result = []
        path = []
        self.backtracking(nums, bagsize, path, 0, 0, result)
        return len(result)
    
    def backtracking(self, nums, target, path, sum, startIndex, result):
        if sum == target:
            result.append(path)
        
        for i in range(startIndex, len(nums)):
            sum += nums[i]
            path.append(nums[i])
            self.backtracking(nums, target, path, sum, i+1, result)
            sum -= nums[i]
            path.pop()

s = Solution()
#print(s.findTargetSumWays([1,2,2,1,1], 3))
print(s.findTargetSumWays([100], -200))