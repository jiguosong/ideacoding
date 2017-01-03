package list;

public class partitionList {
	
	public ListNode partition(ListNode head, int x) {
		if (head == null) return null;
		if (head.next == null) return head;

		ListNode dummy_head = new ListNode(-1);
		dummy_head.next = head;
		
		ListNode tail, prev, curr;
		tail = null;
		prev = dummy_head;
		curr = head;
		
		while(curr != null && tail == null) {
			if (curr.val >= x) tail = prev;
			prev = curr;
			curr = curr.next;
		}
		
		while(curr != null) {
			if (curr.val < x) {
				prev.next = curr.next;
				curr.next = tail.next;
				tail.next = curr;
				curr = prev.next;
				tail = tail.next;
			} else {
				prev = curr;
				curr = curr.next;
			}			
		}
		
		return dummy_head.next;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		partitionList test = new partitionList();
		
		int[] data = {300,1,2,3,1,2,4,2,234,34};
		MyList ll = new MyList(data);
		ll.PrintListAll();	
		
		ListNode ans = test.partition(ll.getHead(), 7);
		
		System.out.println();
		while (ans != null) {
			System.out.print(ans.val + " ");
			ans = ans.next;
		}
		
		
		
	}

}
