# -*- coding: UTF-8 -*-

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head):
        '''
        递归方式
        '''
        def reverse(pre, cur):
            if cur is None:
                return pre
            tmp = cur.next
            cur.next = pre
            return reverse(cur, tmp)
        return reverse(None, head)
    
    def reverseList_1(self, head):
        '''
        双指针法
        '''
        if head is None or head.next is None:
            return head
        pre, cur = None, head
        while cur is not None:
            tmp = cur.next
            cur.next = pre
            pre = cur
            cur = tmp
        return pre