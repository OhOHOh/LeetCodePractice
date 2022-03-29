# -*- coding: UTF-8 -*-
import math
import sys

class Solution:
    def threeSumClosest(self, nums, target):
        if len(nums) <= 3:
            return sum(nums)
        nums = sorted(nums)
        rtn = [nums[0], nums[1], nums[2]]
        record = abs(nums[0]+nums[1]+nums[2]-target)
        for i in range(len(nums)-2):
            if i>0 and nums[i]==nums[i-1]:
                continue
            left, right = i+1, len(nums)-1
            while left < right:
                total = nums[i]+nums[left]+nums[right]
                #print(nums[i],nums[left], nums[right],tmp, sep=', ')
                if total == target:
                    return target
                elif total > target:
                    tmp = abs(total-target)
                    if tmp < record:
                        rtn = [nums[i], nums[left], nums[right]]
                        record = tmp
                    while left<right and nums[right]==nums[right-1]:
                        right -= 1
                    right -= 1
                else:
                    tmp = abs(total-target)
                    if tmp < record:
                        rtn = [nums[i], nums[left], nums[right]]
                        record = tmp
                    while left<right and nums[left]==nums[left+1]:
                        left += 1
                    left += 1
        return sum(rtn)

s = Solution()
print(s.threeSumClosest([-1,2,1,-4], 1))
#print(s.threeSumClosest([1,1,1,0], -100))