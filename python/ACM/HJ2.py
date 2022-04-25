# -*- encoding: utf-8 -*-
'''
@Time    :   2022/04/24 15:03:47
@Author  :   Yu Runshen 
'''

# here put the import lib
import sys, os

data = input().lower()
target = input().lower()
result = 0

#print(data)
#print(target)
for item in data:
    #print(item)
    if item == target:
        result += 1
        
print(result)