# -*- coding: UTF-8 -*-

class Solution:
    def maxSubArray(self, nums):
        result = nums[0]
        cur_sum = 0
        for i in range(len(nums)):
            cur_sum += nums[i]
            result = max(result, cur_sum)
            if cur_sum <= 0:
                cur_sum = 0
        return result

s = Solution()
print(s.maxSubArray([5,4,-1,7,8]))