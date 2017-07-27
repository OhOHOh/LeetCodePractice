
public class MergeKSortedLists {
	
	public class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	 }
	
	public ListNode mergeKLists(ListNode[] lists) {
		int len = lists.length;
		return partion(lists, 0, len-1);		
	}
	private ListNode partion(ListNode[] lists, int start, int end) {
		if(start == end) {
			return lists[start];
		}
		if(start < end) {
			int q = (start + end) / 2;
			ListNode l1 = partion(lists, start, q);
			ListNode l2 = partion(lists, q+1, end);
			return mergeTwo(l1, l2);
		} else {
			return null;
		}	
	}
	private ListNode mergeTwo(ListNode l1, ListNode l2) { //从小到大的顺序
		if(l1 == null) {
			return l2;
		} 
		if(l2 == null) {
			return l1;
		}
		
		if(l1.val < l2.val) {
			l1.next = mergeTwo(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwo(l1, l2.next);
			return l2;
		}
		
//		ListNode ans = new ListNode(0);
//		ListNode pre = ans;
//		while(l1 != null && l2 != null) {
//			if(l1.val < l2.val) {
//				pre.next = l2;
//				pre = l2;
//				l2 = l2.next;
//			} else {
//				pre.next = l1;
//				pre = l1;
//				l1 = l1.next;
//			}
//		}
//		if(l1 != null) {
//			pre = l1;
//		}
//		if(l2 != null) {
//			pre = l2;
//		}		
//		return ans;
		
	}
}
