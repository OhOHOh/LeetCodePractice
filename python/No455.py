# -*- coding: UTF-8 -*-

class Solution:
    def findContentChildren(self, g, s):
        rtn = 0
        g = sorted(g, reverse=True)
        s = sorted(s, reverse=True)
        index_s = 0
        index_g = 0
        while index_s<len(s) and index_g<len(g):
            if s[index_s] >= g[index_g]:
                rtn += 1
                index_s += 1
                index_g += 1
            else:
                index_g += 1
        return rtn 

s = Solution()
print(s.findContentChildren([1,2], [1,2,3]))