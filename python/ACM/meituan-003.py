# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/23 20:10:08
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

n, m = map(int, input().split())
data = []
for i in range(n):
    tmp_value, weight = map(int, input().strip().split())
    value = tmp_value + weight*2
    data.append([value, i+1])
data = sorted(data, key=lambda x: (-x[0], x[1]))
data = [x[1] for x in data]
print(' '.join(map(str, data[:m])))