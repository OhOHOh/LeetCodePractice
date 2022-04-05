# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/05 20:12:57
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def eraseOverlapIntervals(self, intervals):
        intervals = sorted(intervals, key=lambda x: x[1])
        count = 1
        board = intervals[0][1]
        for i in range(1, len(intervals)):
            if intervals[i][0] >= board:
                count += 1
                board = intervals[i][1]
        return len(intervals)-count