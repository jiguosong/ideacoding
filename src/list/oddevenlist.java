package list;

public class oddevenlist {
	
	public ListNode oddEvenList(ListNode head) {
		if (head == null) return null;
		if (head.next == null || head.next.next == null) return head;
		
		ListNode odd = head;
		ListNode even = head.next;
		ListNode tmp_even_head = head.next;
		ListNode t1 = null;
		ListNode t2 = null;

		while (odd != null && even != null) {
			t1 = even.next;
			if (t1 == null) break;
			t2 = t1.next;
			odd.next = t1;
			even.next = t2;	
			odd = t1;
			even = t2;
		}
	
		odd.next = tmp_even_head;

		return head;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		oddevenlist test = new oddevenlist();
		int[] data = {1,2,3,4,5,6,7,8,9,10,11,12};
		MyList ll = new MyList(data);
		ll.PrintListAll();	
		ListNode ans = test.oddEvenList(ll.getHead());
		
		System.out.println();
		while (ans != null) {
			System.out.print(ans.val);
			ans = ans.next;
		}
		
	}

}
