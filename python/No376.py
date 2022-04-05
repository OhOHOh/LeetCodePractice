# -*- coding: UTF-8 -*-

class Solution:
    def wiggleMaxLength(self, nums):
        if len(nums) <= 1:
            return len(nums)
        cur_diff = 0
        pre_diff = 0
        result = 1
        for i in range(len(nums)-1):
            cur_diff = nums[i+1] - nums[i]
            if (cur_diff>0 and pre_diff<=0) or (cur_diff<0 and pre_diff>=0):
                result += 1
                pre_diff = cur_diff
        return result

s = Solution()
print(s.wiggleMaxLength([1,7,4,9,2,5]))