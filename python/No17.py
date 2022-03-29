# -*- coding: UTF-8 -*-

class Solution:
    def letterCombinations(self, digits):
        KEY = {'2': ['a', 'b', 'c'],
               '3': ['d', 'e', 'f'],
               '4': ['g', 'h', 'i'],
               '5': ['j', 'k', 'l'],
               '6': ['m', 'n', 'o'],
               '7': ['p', 'q', 'r', 's'],
               '8': ['t', 'u', 'v'],
               '9': ['w', 'x', 'y', 'z']}
        if digits == "":
            return []
        rtn = [""]
        for num in digits:
            rtn = [pre+cur for pre in rtn for cur in KEY[num]]
        return rtn

s = Solution()
print(s.letterCombinations("23"))
