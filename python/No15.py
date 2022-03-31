# -*- coding: UTF-8 -*-

class Solution:
    def threeSum(self, nums):
        if len(nums) <= 2:
            return []
        rtn = []
        nums = sorted(nums)
        if nums[0] > 0 or nums[-1] < 0:
            return rtn
        for i in range(len(nums)-2):
            if nums[i] > 0:
                break
            if i>0 and nums[i]==nums[i-1]:
                continue
            left, right = i+1, len(nums)-1
            while left < right:
                total = nums[i] + nums[left] + nums[right]
                if total == 0:
                    rtn.append([nums[i], nums[left], nums[right]])
                    while left<right and nums[left]==nums[left+1]:
                        left += 1
                    while left<right and nums[right]==nums[right-1]:
                        right -= 1
                    left += 1
                    right -= 1
                elif total > 0:
                    right -= 1
                else:
                    left += 1
        return rtn