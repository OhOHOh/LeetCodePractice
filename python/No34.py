# -*- coding: UTF-8 -*-

class Solution:
    def searchRange(self, nums, target):
        left = self.findLeft(nums, target)
        if left == -1:
            return [-1, -1]
        right = self.findRight(nums, target)
        return [left, right]

    def findLeft(self, nums, target):
        left, right = 0, len(nums)-1
        while left <= right:
            mid = int((left+right)/2)
            if nums[mid] == target:
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        if left>=len(nums) or nums[left]!=target:
            return -1
        return left
    
    def findRight(self, nums, target):
        left, right = 0, len(nums)-1
        while left <= right:
            mid = int((left+right)/2)
            if nums[mid] == target:
                left = mid + 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        if right<0 or nums[right]!=target:
            return -1
        return right

    def findLeft_nouse(self, nums, target):
        '''
        搜索区间: 左闭右开
        不用这种思路!
        '''
        left, right = 0, len(nums)
        while left < right:
            mid = int((left+right)/2)
            if nums[mid] == target:
                right = mid
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid
        if left>=len(nums) or nums[left]!=target:
            return -1
        return left
    def findRight_nouse(self, nums, target):
        '''
        搜索区间: 左闭右开
        不用这种思路!
        '''
        left, right = 0, len(nums)
        while left < right:
            mid = int((left+right)/2)
            if nums[mid] == target:
                left = mid + 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid
        if left == 0 or nums[left-1]!=target:
            return -1
        return left-1
    
    def findMid(self, nums):
        if nums[0] < nums[-1]:
            return -1
        left, right = 0, len(nums)-1
        while left < right:
            mid = int((left+right)/2)
            if nums[mid] > nums[right]:
                left = mid + 1
            elif nums[mid] == nums[right]:
                right = mid
            elif nums[mid] < nums[right]:
                right = mid
        return left
        
s = Solution()
print(s.findLeft([1,2,3], 2))
print(s.findRight([1,2,3], 2))