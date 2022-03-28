# -*- coding: UTF-8 -*-

class Solution:
    def maxArea_1(self, height) -> int:
        """
        暴力求解
        """
        if len(height) <= 1:
            return 0
        max_rtn = 0
        for i in range(len(height)-1):
            for j in range(i+1, len(height)):
                area = min(height[i], height[j]) * (j-i)
                max_rtn = max(max_rtn, area)
        return max_rtn

    def maxArea(self, height):
        if len(height) <= 1:
            return 0
        max_rtn = 0
        left, right = 0, len(height)-1
        while left < right:
            area = min(height[left], height[right]) * (right-left)
            max_rtn = max(area, max_rtn)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return max_rtn

s = Solution()
print(s.maxArea([5,2,100,10]))