# -*- coding: UTF-8 -*-
'''
柱状图中最大的矩形
'''

class Solution:
    def largestRectangleArea(self, heights):
        '''
        单调栈
        栈内元素对应的 heights 是从大到小(从栈顶到栈底)
        '''
        stack = [0]
        result = heights[0]
        heights = [0] + heights + [0]
        for i in range(1, len(heights)):
            if heights[stack[-1]] < heights[i]:
                stack.append(i)
            elif heights[stack[-1]] == heights[i]:
                stack[-1] = i
            else:
                while stack and heights[stack[-1]] > heights[i]:
                    mid_index = stack[-1]
                    stack.pop()
                    if stack:
                        w = i - stack[-1] - 1
                    else:
                        w = 1
                    result = max(result, w*heights[mid_index])
                stack.append(i)
        return result

    def dp(self, heights):
        '''
        尝试使用动态规划
        '''
        size = len(heights)
        result = heights[0]
        minLeft, minRight = [0] * size, [0] * size

        minLeft[0] = -1
        for i in range(1, size):
            if heights[i] > heights[i-1]:
                minLeft[i] = i - 1
            else:
                tmp = i - 1
                while tmp>=0 and heights[i] <= heights[tmp]:
                    tmp = minLeft[tmp]
                minLeft[i] = tmp

        minRight[size-1] = size
        for i in range(size-2, -1, -1):
            if heights[i] > heights[i+1]:
                minRight[i] = i + 1
            else:
                tmp = i + 1
                while tmp<size and heights[i] <= heights[tmp]:
                    tmp = minRight[tmp]
                minRight[i] = tmp
        
        for i in range(size):
            h = heights[i]
            w = minRight[i] - minLeft[i] - 1
            result = max(result, h*w)
        return result
            

s = Solution()
print(s.largestRectangleArea([1,1]))
print(s.dp([1,1]))