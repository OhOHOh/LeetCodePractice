# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/09 12:15:06
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def lastStoneWeightII(self, stones):
        target = int(sum(stones)/2)
        dp = [0] * (target+1)

        for i in range(len(stones)):
            for j in range(target, stones[i]-1, -1):
                if j >= stones[i]:
                    dp[j] = max(dp[j], dp[j-stones[i]]+stones[i])
        
        return sum(stones)-dp[target]-dp[target]

s = Solution()
print(s.lastStoneWeightII([2,7,4,1,8,1]))