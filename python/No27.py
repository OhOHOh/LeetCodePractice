# -*- coding: UTF-8 -*-

class Solution:
    def removeElement(self, nums, val):
        if len(nums) == 0 or nums is None:
            return nums
        left, right = 0, len(nums)-1
        while left < right:
            while left<right and nums[right]==val:
                right -= 1
            while left<right and nums[left]!=val:
                left += 1
            tmp = nums[left]
            nums[left] = nums[right]
            nums[right] = tmp
        return nums
    
    def removeElement_1(self, nums, val):
        '''
        快慢指针
        '''
        slow, fast = 0, 0
        while fast < len(nums):
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1
                fast += 1
            else:
                fast += 1
        return nums

s = Solution()
print(s.removeElement([0,1,2,2,3,0,4,2], 2))
print(s.removeElement_1([0,1,2,2,3,0,4,2], 2))