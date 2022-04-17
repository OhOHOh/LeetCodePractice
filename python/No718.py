# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/17 23:01:58
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def findLength(self, nums1, nums2):
        '''
        DP
        dp[i][j]: nums1 中下标 0~i-1 和 nums2 中下标 0~j-1 的2个字符串中最长公共子序列长度为 dp[i][j]
        '''
        m, n = len(nums1), len(nums2)
        dp = [[0]*(n+1) for _ in range(m+1)]
        result = 0

        for i in range(1, m+1):
            for j in range(1, n+1):
                if nums1[i-1] == nums2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                    result = max(result, dp[i][j])
        return result
        
s = Solution()
print(s.findLength(nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]))