# -*- encoding: utf-8 -*-
'''
@Time    :   2022/05/15 12:06:52
@Author  :   Yu Runshen 

给你一个字符串 s ，颠倒字符串中 单词 的顺序。
'''

# here put the import lib
import sys, os

class Solution:
    def reverseWords_simple(self, s):
        s_list = [i for i in s.split(' ') if len(s)>0]
        return " ".join(s_list[::-1])
    
    
    def reverseWords(self, s):
        # 移除空格
        s_list = self.trim_space(s)
        print(s_list)
        # 反转整个字符串
        self.reverse_string(s_list, 0, len(s_list)-1)
        print(s_list)
        # 逐个反转单词
        self.reverse_each_word(s_list)
        print(s_list)
        return ''.join(s_list)
    
    def trim_space(self, s):
        rtn = []
        left, right = 0, len(s)-1
        while s[left] == ' ':
            left += 1
        while s[right] == ' ':
            right -= 1
        while left <= right:
            if s[left] != ' ':
                rtn.append(s[left])
            elif rtn[-1] != ' ':
                rtn.append(s[left])
            left += 1
        return rtn
    
    def reverse_string(self, s_list, left, right):
        while left < right:
            s_list[left], s_list[right] = s_list[right], s_list[left]
            left += 1
            right -= 1
        
    def reverse_each_word(self, s_list):
        start, end, size = 0, 0, len(s_list)
        while end < size:
            if s_list[end] != ' ':
                end += 1
                continue
            self.reverse_string(s_list, start, end-1)
            start = end + 1
            end = start + 1
        self.reverse_string(s_list, start, end-1)

s = Solution()
#print(s.reverseWords(s = "a good   example"))
print(s.reverseWords("the sky is blue"))
print(s.reverseWords_simple("the sky is blue"))