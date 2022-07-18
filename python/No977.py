# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/19 19:54:56
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

class Solution:
    def sortedSquares(self, nums):
        size = len(nums)
        left, right, index = 0, size-1, size-1
        rtn = [-1] * size
        while index >= 0:
            lSqure, rSqure = nums[left]*nums[left], nums[right]*nums[right]
            if lSqure < rSqure:
                rtn[index] = nums[right]*nums[right] 
                right = right - 1
            else:
                rtn[index] = nums[left]*nums[left] 
                left = left + 1
            index -= 1
        return rtn