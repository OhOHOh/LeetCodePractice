# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/23 19:56:14
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

# 测试单行输入
#line = input()
#data = line.strip().split()
#data = list(map(int, data))

# 测试多行输入
num = int(input().strip())
data = []
for _ in range(num):
    data.append(list(map(int, input().strip().split())))

print(data)