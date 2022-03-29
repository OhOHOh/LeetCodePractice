# -*- coding: UTF-8 -*-

class Solution:
    def removeDuplicates_1(self, s):
        '''
        双指针
        '''
        res = list(s)
        slow, fast = 0, 0
        while fast < len(res):
            res[slow] = res[fast]
            if slow>0 and res[slow]==res[slow-1]:
                slow -= 1
            else:
                slow += 1
            fast += 1
        return ''.join(res[:slow])
    
    def removeDuplicates(self, s):
        stack = list()
        for item in s:
            if len(stack)==0 or item!=stack[-1]:
                stack.append(item)
            elif item == stack[-1]:
                stack.pop()
        return ''.join(stack)

s = Solution()
print(s.removeDuplicates("abbac"))