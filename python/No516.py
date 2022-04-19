# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/19 23:15:23
@Author  :   Yu Runshen 
最长回文子序列, 注意与 最长回文子串 的区别!
'''

# here put the import lib
import sys, os

class Solution:
    def longestPalindromeSubseq(self, s):
        size = len(s)
        result = 0
        dp = [[0]*size for _ in range(size)]
        # 初始化
        for i in range(size):
            dp[i][i] = 1
        # 遍历
        for i in range(size-1, -1, -1):
            for j in range(i+1, size):
                if s[i] == s[j]:
                    if i+1 == j:
                        dp[i][j] = 2
                    else:
                        dp[i][j] = dp[i+1][j-1] + 2
                else:
                    dp[i][j] = max(dp[i+1][j], dp[i][j-1])
                result = max(result, dp[i][j])
        return result

s = Solution()
print(s.longestPalindromeSubseq(s = "cbbd"))