
public class SwapNodesInPairs {  //第24题
	
	public class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
    }
	
	public ListNode swapPairs(ListNode head) {
		int count = 0;
		if(head==null || head.next==null) {
			return head;
		}
		ListNode p=head, q=head.next, tmp=p;;
		while(p!=null && q!=null) {
			p.next = q.next;
			q.next = p;
			if(count == 0) {
				head = q;
			}
			
			count++;
			p = p.next;
			if(p != null) {
				q = p.next;
				if(q != null) {
					tmp.next = q;
					tmp = p;
				}				
			}
			
		}
		return head;
	}
	
	//递归的算法！！！
	public ListNode swapPairsRecursion(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode n = head.next;
		head.next = swapPairsRecursion(head.next.next);
		n.next = head;
		
		return n;
	}
	
}
