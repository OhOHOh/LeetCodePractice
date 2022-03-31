# -*- coding: UTF-8 -*-
import heapq

class Solution:
    def topKFrequent(self, nums, k):
        map_ = {}
        for i in nums:
            map_[i] = map_.get(i, 0) + 1
        pri_que = [] #小顶堆

        for key, freq in map_.items():
            heapq.heappush(pri_que, (freq, key))
            if len(pri_que) > k:
                heapq.heappop(pri_que)
        result = [0] * k
        for i in range(k-1, -1, -1):
            result[i] = heapq.heappop(pri_que)[1]
        return result