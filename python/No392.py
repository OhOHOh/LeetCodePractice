# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/18 22:58:12
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def isSubsequence(self, s, t):
        size1, size2 = len(s), len(t)
        dp = [[False]*(1+size2) for _ in range(1+size1)]
        for i in range(size2+1):
            dp[0][i] = True
        
        for i in range(1, size1+1):
            for j in range(1, size2+1):
                if s[i-1] == t[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = dp[i][j-1]
        return dp[size1][size2]

    def isSubsequence_2(self, s, t):
        size1, size2 = len(s), len(t)
        dp = [[0]*(1+size2) for _ in range(1+size1)]
        for i in range(1, size1+1):
            for j in range(1, size2+1):
                if s[i-1] == t[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = dp[i][j-1]
        return dp[size1][size2] == size1


so = Solution()
print(so.isSubsequence_2(s = "abc", t = "ahbgdc"))
