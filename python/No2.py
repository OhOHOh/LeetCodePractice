# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        acc, mod = 0, 0
        p1, p2 = l1, l2
        rtn = ListNode()
        r = rtn
        while p1 or p2 or acc:
            sum = (p1.val if p1 else 0) + (p2.val if p2 else 0) + acc
            mod = sum-10 if sum>=10 else sum
            r = self._add_node(r, mod)
            acc = 1 if sum>=10 else 0
            p1 = p1.next if p1 else None
            p2 = p2.next if p2 else None
        
        return rtn.next
    
    def _add_node(self, head, val):
        new_node = ListNode(int(val), None)
        head.next = new_node
        return new_node
    def build_list_node(self, arr):
        head = ListNode()
        tmp = head
        for item in arr:
            tmp = self._add_node(tmp, int(item))
        return head.next
    def printf(self, head):
        tmp = []
        item = head
        while item:
            tmp.append(str(item.val))
            item = item.next
        print(' '.join(tmp))

c = Solution()
#A = c.build_list_node([9,9,9,9])
#B = c.build_list_node([9,9])
A = c.build_list_node([2,4,3])
B = c.build_list_node([5,6,4])
c.printf(A)
c.printf(B)
c.printf(c.addTwoNumbers(A, B))