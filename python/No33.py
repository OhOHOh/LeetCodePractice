# -*- coding: UTF-8 -*-

class Solution:
    def search(self, nums, target):
        if nums[-1] > nums[0]:
            # 完全升序
            return self.binary_search(nums, target)
        if target == nums[-1]:
            return len(nums)-1
        if target > nums[-1]:
            # target只可能落在左边区间
            return self.helper_left(nums, target)
        else:
            # target只可能落在右边区间
            return self.helper_right(nums, target)
    
    def binary_search(self, nums, target):
        '''
        标准二分查找
        '''
        left, right = 0, len(nums)-1
        while left <= right:
            mid = int((left+right)/2)
            if target == nums[mid]:
                return mid
            if target > nums[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return -1
    
    def helper_left(self, nums, target):
        '''
        target只可能落在左边区间
        '''
        left, right = 0, len(nums)-1
        while left <= right:
            mid = int((left+right)/2)
            if target == nums[mid]:
                return mid
            if target > nums[mid]:
                if nums[mid] > nums[-1]:
                    left = mid + 1
                else:
                    right = mid - 1
            else:
                right = mid - 1
        return -1

    def helper_right(self, nums, target):
        '''
        target只可能落在右边区间
        '''
        left, right = 0, len(nums)-1
        while left <= right:
            mid = int((left+right)/2)
            if target == nums[mid]:
                return mid
            if target > nums[mid]:
                left = mid + 1
            else:
                if nums[mid] > nums[-1]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1

s = Solution()
#print(s.search([5,0,1,3],-2))
print(s.search([3,7,7,0,1,3],7))