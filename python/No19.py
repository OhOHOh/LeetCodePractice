# -*- coding: UTF-8 -*-

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head, n):
        if head is None:
            return head
        p, q = head, head
        for i in range(n):
            if q is None:
                return head
            q = q.next
        if q is None:
            return head.next
        while q is not None:
            pre = p
            p = p.next
            q = q.next
        pre.next = pre.next.next
        return head