# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/12 17:38:57
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

from sympy import true

class Solution:
    def wordBreak(self, s, wordDict):
        dp = [False] * (len(s)+1)
        dp[0] = True

        for i in range(len(s)+1):
            for j in range(i+1, len(s)+1):
                if dp[i] and s[i:j] in wordDict:
                    dp[j] = True
        return dp[-1]

    def wordBreak_2(self, s, wordDict):
        dp = [False] * (len(s)+1)
        dp[0] = True
        
        #for word in wordDict:
        #    for j in range(len(word), len(s)+1):
        #        dp[j] = dp[j] or dp[j-len(word)]
        for i in range(1, len(s)+1):
            for word in wordDict:
                if i >= len(word):
                    dp[i] = dp[i] or (dp[i-len(word)] and s[i-len(word):i]==word)
        return dp[-1]
    
    def wordBreak_3(self, s, wordDict):
        def backtracking(s, wordDict, startindex):
            if startindex >= len(s):
                return True
            for i in range(startindex+1, len(s)):
                word = s[startindex: i]
                if word in wordDict and backtracking(s, wordDict, i+1):
                    return true
            return False
        return backtracking(s, wordDict, 0)

s = Solution()
print(s.wordBreak_3(s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]))