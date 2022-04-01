# -*- coding: UTF-8 -*-
'''
每日温度
单调栈
'''
class Solution:
    def dailyTemperatures(self, temperatures):
        result = [0] * len(temperatures)
        stack = [0]
        for i in range(1, len(temperatures)):
            if temperatures[i] <= temperatures[stack[-1]]:
                stack.append(i)
            else:
                while stack and temperatures[i] > temperatures[stack[-1]]:
                    result[stack[-1]] = i - stack[-1]
                    stack.pop()
                stack.append(i)
        return result

s = Solution()
print(s.dailyTemperatures([73,74,75,71,69,72,76,73]))