# -*- encoding: utf-8 -*-
'''
@Time    :   2022/05/14 17:16:49
@Author  :   Yu Runshen 

编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
'''

# here put the import lib
import sys, os

class Solution:
    def reverseString(self, s):
        """
        Do not return anything, modify s in-place instead.
        """
        l, r = 0, len(s)-1
        while l < r:
            tmp = s[l]
            s[l] = s[r]
            s[r] = tmp
            #s[l], s[r] = s[r], s[l]
            l = l + 1
            r = r - 1