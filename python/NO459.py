# -*- encoding: utf-8 -*-
'''
@Time    :   2022/05/16 23:57:31
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def repeatedSubstringPattern(self, s):
        return s in (s+s)[1:-1]