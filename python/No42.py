# -*- coding: UTF-8 -*-
'''
接雨水
'''

class Solution:
    def trap(self, height):
        '''
        单调栈, 从行方向来计算水量
        '''
        rtn = 0
        stack = list()
        stack.append(0)
        for i in range(1, len(height)):
            if height[stack[-1]] > height[i]:
                stack.append(i)
            elif height[stack[-1]] == height[i]:
                stack[-1] = i
            else:
                while stack and height[stack[-1]] < height[i]:
                    mid = stack.pop()
                    if stack:
                        h = min(height[i], height[stack[-1]]) - height[mid]
                        w = i - stack[-1] - 1
                        rtn += h * w
                stack.append(i)
        return rtn
                    

    def trap_1(self, height):
        '''
        DP, 列计算水量
        '''
        maxLeft = [0] * len(height)
        maxRight = [0] * len(height)

        maxLeft[0] = height[0]
        for i in range(1, len(height)):
            maxLeft[i] = max(maxLeft[i-1], height[i])
        maxRight[-1] = height[-1]
        for i in range(len(height)-2, -1, -1):
            maxRight[i] = max(maxRight[i+1], height[i])

        rtn = 0
        for i in range(1, len(height)-1):
            h = min(maxLeft[i], maxRight[i]) - height[i]
            if h > 0:
                rtn += h
        return rtn
s = Solution()
print(s.trap([2,1,0,2,1,0,1,3,2,1,2,1]))
