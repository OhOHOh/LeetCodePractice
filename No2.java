/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class No2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int plus = 0;
        ListNode result;
        ListNode p = new ListNode(-1);
        result = p;

        // first
        while(l1 != null && l2 != null) {
            ListNode tmp = new ListNode((l1.val + l2.val)%10 + plus);
            plus = l1.val + l2.val > 9 ? 1 : 0;
            p.next = tmp;
            p = tmp;
            l1 = l1.next;
            l2 = l2.next;
        }
        // second
        while(l1 != null) {
            ListNode tmp = new ListNode((plus + l1.val) % 10);
            plus = (plus + l1.val) / 10;
            p.next = tmp;
            p = tmp;
            l1 = l1.next;
        }
        while(l2 != null) {
            ListNode tmp = new ListNode((plus + l2.val) % 10);
            plus = (plus + l2.val) / 10;
            p.next = tmp;
            p = tmp;
            l1 = l2.next;
        }
        // third
        if (plus == 1) {
            ListNode tmp = new ListNode(1);
            p.next = tmp;
        }

        return result.next;
    }
    public ListNode addTwoNumbers_right(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while(l1 != null || l2 != null || carry == 1) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode temp = new ListNode(sum);
            prev.next = temp;
            prev = temp;
            head.val++;

            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        return head.next;
    }
}