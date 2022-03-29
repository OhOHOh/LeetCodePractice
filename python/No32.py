# -*- coding: UTF-8 -*-

class Solution:
    def longestValidParentheses(self, s):
        if len(s) <= 1:
            return 0
        dp = [0] * len(s)
        max_rtn = 0
        for i in range(1, len(s)):
            if s[i] == ')':
                pre = i - dp[i-1] - 1
                if pre>=0 and s[pre]=='(':
                    dp[i] = dp[i-1] + 2
                if pre > 0:
                    dp[i] += dp[pre-1]
                max_rtn = max(max_rtn, dp[i])
        return max_rtn

s = Solution()
print(s.longestValidParentheses("()()))))()()("))