# -*- encoding: utf-8 -*-
'''
@Time    :   2022/05/14 20:29:50
@Author  :   Yu Runshen 

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
'''

# here put the import lib
import sys, os

class Solution:
    def replaceSpace(self, s):
        # 遍历一遍看下有几个空格,  从而计算出新的字符串的长度
        counter = s.count(' ')
        rtn = list(s)
        rtn.extend(['*'] * (counter*2))
        l, r = len(s)-1, len(rtn)-1
        while counter > 0:
        #while l >= 0:
            if rtn[l] != ' ':
                rtn[r] = rtn[l]
                r = r - 1
            else:
                rtn[r-2: r+1] = '%20'
                r = r - 3
                counter = counter - 1
            l = l - 1
        return ''.join(rtn)

s = Solution()
print(s.replaceSpace(s = "We are happy."))