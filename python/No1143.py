# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/17 23:11:36
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def longestCommonSubsequence(self, text1, text2):
        m, n = len(text1), len(text2)
        dp = [[0]*(n+1) for _ in range(m+1)]
        result = 0

        for i in range(1, m+1):
            for j in range(1, n+1):
                if text1[i-1] == text2[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
                result = max(result, dp[i][j])
        return result
            
s = Solution()
print(s.longestCommonSubsequence(text1 = "abcde", text2 = "ace"))