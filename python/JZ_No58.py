# -*- encoding: utf-8 -*-
'''
@Time    :   2022/05/15 16:39:11
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def reverseLeftWords(self, s, n):
        size = len(s)
        n = n % size
        s_list = list(s)
        self.reverse_string(s_list, 0, n-1)
        self.reverse_string(s_list, n, size-1)
        self.reverse_string(s_list, 0, size-1)
        return ''.join(s_list)


    def reverse_string(self, s_list, left, right):
        while left < right:
            s_list[left], s_list[right] = s_list[right], s_list[left]
            left += 1
            right -= 1
        return None

s = Solution()
print(s.reverseLeftWords(s = "abcdefg", n = 2))