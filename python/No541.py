# -*- encoding: utf-8 -*-
'''
@Time    :   2022/05/14 18:25:17
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def reverseStr(self, s, k):
        #if len(s) <= k:
        #    return self.helper(s, 0, len(s)-1)
        s = list(s)
        index = 0
        while index < len(s):
            l, r = index, index+k-1 if index+k-1<len(s) else len(s)-1
            self.helper(s, l, r)
            index = index + 2*k
        return ''.join(s)

    def helper(self, input, l, r):
        while l < r:
            input[l], input[r] = input[r], input[l]
            l = l + 1
            r = r - 1
    

    def reverseStr_2(self, s, k):
        s = list(s)
        for i in range(0, len(s), 2*k):
            s[i: i+k] = self.helper_2(s[i: i+k])
        return ''.join(s)

    def helper_2(self, input):
        l, r = 0, len(input)-1
        while l < r:
            input[l], input[r] = input[r], input[l]
            l = l + 1
            r = r - 1
        return input

s = Solution()
print(s.reverseStr(s = "abcdefg", k = 2))
print(s.reverseStr_2(s = "abcdefg", k = 2))