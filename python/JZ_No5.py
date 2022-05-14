# -*- coding: UTF-8 -*-

class Solution:
    def longestPalindrome(self, s):
        if len(s) == 0:
            return ""
        elif len(s) == 1:
            return s
        max_item = (0,0,0)
        for i in range(len(s)):
            if self.helper(s, i, i)[0] > max_item[0]:
                max_item = self.helper(s, i, i)
            if self.helper(s, i, i+1)[0] > max_item[0]:
                max_item = self.helper(s, i, i+1)
        return s[max_item[1]: max_item[2]+1]

    def helper(self, s, i, j):
        left, right = i, j
        rtn = 1
        while i>=0 and j<len(s) and s[i]==s[j]:
            rtn = j - i + 1
            left, right = i, j
            i, j = i-1, j+1
        return (rtn,left,right)
    
    def longestPalindrome2(self, s):
        '''
        DP, dp[i][j]
        注意遍历的顺序!
        '''
        if len(s) == 0:
            return ""
        elif len(s) == 1:
            return s
        dp = [[False]*len(s) for _ in range(len(s))]
        left, right = 0, 0
        for i in range(len(s)-1, -1, -1):
            for j in range(i, len(s), 1):
                if s[i] == s[j] and (j-i <= 1 or dp[i+1][j-1]):
                    dp[i][j] = True
                    if j-i+1 >= right-left+1:
                        left = i
                        right = j
        return s[left: right+1]
        

s = Solution()
print(s.longestPalindrome2("abac"))
