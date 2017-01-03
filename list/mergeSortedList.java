package list;

public class mergeSortedList {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) return null;
		if (l1 != null && l2 == null) return l1;
		if (l1 == null && l2 != null) return l2;
		
		ListNode head = new ListNode(0);
		ListNode p = l1;
		ListNode q = l2;
		ListNode t = head;
		
		while(p != null && q != null) {
			if (p.val < q.val) {
				t.next = p;
				p = p.next;
			} else {
				t.next = q;
				q = q.next;
			}
			t = t.next;
		}
		
		if (p != null) t.next = p;
		if (q != null) t.next = q;
		return head.next;
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mergeSortedList test = new mergeSortedList();
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(7);
		
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(8);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(10);

		ListNode ans = test.mergeTwoLists(l1, l2);
		
		while (ans != null) {
			System.out.println(ans.val);
			ans = ans.next;
		}


	}

}
