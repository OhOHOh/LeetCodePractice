# -*- coding: UTF-8 -*-

class Solution:
    def combine(self, n, k):
        self.result = []
        self.tmp = []
        self.dfs(n, k, 1)
        return self.result
    
    
    def dfs(self, n, k, startIndex):
        if len(self.tmp) == k:
            self.result.append(self.tmp[:])
            return
        for i in range(startIndex, n+2-(k-len(self.tmp))):
            self.tmp.append(i)
            self.dfs(n, k, i+1)
            self.tmp.pop()

s = Solution()
print(s.combine(4,2))