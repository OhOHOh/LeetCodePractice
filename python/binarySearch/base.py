# -*- encoding: utf-8 -*-
'''
@Time    :   2022/06/21 11:05:26
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

from sklearn.linear_model import ridge_regression

def binarySearch_tample(nums, target):
    left, right = 0, len(nums)-1
    while ...:
        mid = left + int((right-left)/2)
        if nums[mid] == target:
          ...
        elif nums[mid] < target:
          left = ...
        elif nums[mid] > target:
          right = ...
    return ...

def binary_search_base(nums, target):
    '''
    基础的二分搜索, 给定一个排序数组, 搜索target是否在该数组中, 如果存在则返回下标, 否则返回-1
    '''
    left, right = 0, len(nums)-1
    while left <= right:
        mid = left + int((right-left)/2)
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid  - 1
    return -1

def binary_search_left_bound(nums, target):
    '''
    进阶版二分搜索, 找出有序数组中target的左边界
    '''
    left, right = 0, len(nums)-1
    while left <= right:
        mid = left + int((right-left)/2)
        if nums[mid] == target:
            right = mid - 1
        elif nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid - 1
    if left>=len(nums) or nums[left]!=target:
        return -1
    return left

def binary_search_right_bound(nums, target):
    '''
    进阶版二分搜索, 找出有序数组中target的右边界
    '''
    left, right = 0, len(nums)-1
    while left <= right:
        mid = left + int((right-left)/2)
        if nums[mid] == target:
            left = mid + 1
        elif nums[mid] < target:
            left = mid + 1
        elif nums[mid] > target:
            right = mid - 1
    if right<=0 or nums[right]!=target:
        return -1
    return right
