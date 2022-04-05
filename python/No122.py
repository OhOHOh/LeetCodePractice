# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/05 19:43:20
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def maxProfit(self, prices):
        if len(prices) <= 1:
            return 0
        result = 0
        for i in range(1, len(prices)):
            result += max(prices[i]-prices[i-1], 0)
        return result

s = Solution()
print(s.maxProfit([7,1,5,3,6,4]))