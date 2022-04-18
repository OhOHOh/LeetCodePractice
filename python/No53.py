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
    
    def maxSubArray_dp(self, nums):
        size = len(nums)
        result = max(nums)
        dp = [0] * size
        dp[0] = nums[0]
        
        for i in range(1, size):
            dp[i] = max(dp[i-1]+nums[i], nums[i])
            result = max(result, dp[i])
        return result 

s = Solution()
print(s.maxSubArray([5,4,-1,7,8]))