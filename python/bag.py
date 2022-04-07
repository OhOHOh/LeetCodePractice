# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/07 19:53:25
@Author  :   Yu Runshen 
背包问题
'''

# here put the import lib
from re import L
import sys, os

class Solution:
    def bag_0_1(self, weight, value, bag_content):
        dp = [[0] * (bag_content+1) for _ in range(len(weight))]
        # 初始化
        for i in range(len(weight)):
            dp[i][0] = 0
        for i in range(weight[0], bag_content+1):
            dp[0][i] = value[0]
        
        #遍历dp数组
        for i in range(1, len(weight)):
            for j in range(1, bag_content+1):
                if j >= weight[i]:
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i])
                else:
                    dp[i][j] = dp[i-1][j]
        return dp[len(weight)-1][bag_content]

    def bag_0_1_other(self, weight, value, bag_content):
        dp = [0] * (bag_content+1)

        for i in range(len(weight)):
            for j in range(bag_content, -1, -1):
                if j >= weight[i]:
                    dp[j] = max(dp[j], dp[j-weight[i]]+value[i])
                else:
                    dp[j] = dp[j]
        return dp[bag_content]


s = Solution()
print(s.bag_0_1([1,3,4], [15,20,30], 6))
print(s.bag_0_1_other([1,3,4], [15,20,30], 6))