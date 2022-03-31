# -*- coding: UTF-8 -*-

class Solution:
    def search(self, nums, target):
        if nums[-1] > nums[0]:
            # 完全升序
            return True if self.binary_search(nums, target)!=-1 else False
        #return True if self.helper(nums, target)!=-1 else False
        return True if self.helper_1(nums, target)!=-1 else False
    
    
    def helper(self, nums, target):
        left, right = 0, len(nums)-1
        while left <= right:
            mid = int((left+right)/2)
            if target == nums[mid]:
                return mid
            if nums[mid] == nums[left]:
                left += 1
                continue
            if nums[mid] > nums[left]:
                # mid 落在左区间
                if target<nums[mid] and target>=nums[left]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                # mid 落在右区间
                if target>nums[mid] and target<=nums[right]:
                    left = mid + 1
                else:
                    right = mid -1
        return -1
                    
    
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
    
    def helper_1(self, nums, target):
        left, right = 0, len(nums)-1
        while left <= right:
            mid = int((left+right)/2)
            if nums[mid] == target:
                return mid
            if nums[mid]==nums[left] and nums[mid]==nums[right]:
                left += 1
                right -= 1
                continue
            if nums[mid] >= nums[left]:
                if target>=nums[left] and target<nums[mid]:
                    right = mid - 1
                else:
                    left = left + 1
            else:
                if target<=nums[right] and target>nums[mid]:
                    left = left + 1
                else:
                    right = right - 1
        return -1

s = Solution()
#print(s.search([5,0,1,3],-2))
#print(s.search([3,7,7,0,1,3],7))
print(s.search([1,1,1,1,0,1],0))