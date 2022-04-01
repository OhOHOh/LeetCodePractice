# -*- coding: UTF-8 -*-
from collections import deque

class MyQueue1:
    def __init__(self):
        self.queue = list()
    def m_push(self, num):
        while self.queue and self.queue[-1] < num:
            self.queue.pop()
        #while self.queue and self.queue[0] <= num:
        #    self.queue.pop(0)
        self.queue.append(num)

    def m_pop(self, num):
        if self.queue[0] == num:
            return self.queue.pop(0)
        
    def m_front(self):
        return self.queue[0]

class MyQueue:
    '''
    使用 deque 来实现一个单调栈!
    '''
    def __init__(self):
        self.queue = deque()
    def m_push(self, num):
        while self.queue and self.queue[-1] < num:
            self.queue.pop()
        #while self.queue and self.queue[0] <= num:
        #    self.queue.pop(0)
        self.queue.append(num)

    def m_pop(self, num):
        if self.queue[0] == num:
            return self.queue.popleft()
        
    def m_front(self):
        return self.queue[0]

class Solution:
    def maxSlidingWindow(self, nums, k):
        rtn = []
        queue = MyQueue()
        for i in range(k):
            queue.m_push(nums[i])
        rtn.append(queue.m_front())
            
        for i in range(k, len(nums)):
            queue.m_pop(nums[i-k])
            queue.m_push(nums[i])
            rtn.append(queue.m_front())
        return rtn

s = Solution()
#print(s.maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3))
#print(s.maxSlidingWindow([1,3,1,2,0,5], 3))
print(s.maxSlidingWindow([-7,-8,7,5,7,1,6,0], 4))