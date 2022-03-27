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

s = Solution()
print(s.longestPalindrome("abac"))
