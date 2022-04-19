# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/19 19:54:56
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def countSubstrings(self, s):
        size = len(s)
        result = 0
        dp = [[False]*size for _ in range(size)]
        # 初始化
        for i in range(size):
            dp[i][i] = True
            result += 1
        # 遍历
        for i in range(size-1, -1, -1):
            for j in range(i+1, size):
                if s[i] == s[j]:
                    if i+1 == j:
                        dp[i][j] = True
                        result += 1
                    elif dp[i+1][j-1]:
                        dp[i][j] = True
                        result += 1
                else:
                    dp[i][j] = False
        return result

s = Solution()
print(s.countSubstrings(s = "aac"))