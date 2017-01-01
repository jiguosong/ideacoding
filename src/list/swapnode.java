package list;

public class swapnode {
	private ListNode reverseListRange(ListNode head, int k1, int k2){
		if (head == null || k1 <= 0 || k2 <=0 || k1 > k2) return null;
		
		ListNode prev, curr;		
		prev = null;		
		curr = head;		
		int count = 1;
		while (curr!= null && count < k1) {
			prev = curr;
			curr = curr.next;
			count++;
		}
		
		// mark where to link when reversing is done 
		ListNode prev_end = prev;
		ListNode curr_start = curr;
		
		while (curr != null && count <= k2) {
			ListNode t = curr.next;
			curr.next = prev;
			prev = curr;
			curr = t;
			count++;
		}
		
		// link together
		if (prev_end != null) prev_end.next = prev; 
		if (curr_start != null) curr_start.next = curr;
		
		// find the right head
		if (k1 == 1) head = prev;
		return head;
	}

	public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        
        int i = 1;
        ListNode p = head;
        ListNode tmp = p;
        ListNode newhead = null;
        while(p != null && p.next != null) {
        	p = p.next.next;
        	tmp = reverseListRange(tmp, i, i+1);
        	if (newhead == null) newhead = tmp;
        	i = i + 2;
        }
        
        return newhead;
    }
	
	public ListNode swapPairs_2(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return head;
		
		ListNode newhead = head.next;

		ListNode prev = null;
		ListNode curr = head;
		ListNode p = curr.next;	
		
		while (curr != null && p != null) {
			ListNode tmp = p.next;
			p.next = curr;
			if (prev != null) prev.next = p;
			curr.next = tmp;
			prev = curr;
			curr = tmp;
			if (tmp != null) p = tmp.next;
		}
		
		return newhead;		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6,7,8};
		MyList ll = new MyList(data);
		ll.PrintListAll();	
		
		System.out.println("\n\nJava: reverse node");
		swapnode test = new swapnode();
		ListNode res = test.reverseListRange(ll.getHead(), 1, 10);
		ll.PrintListNode(res);
		
		System.out.println("\nJava: swap pair node");
		MyList ll2 = new MyList(data);
		//res = test.swapPairs(ll2.getHead());
		res = test.swapPairs_2(ll2.getHead());
		ll2.PrintListNode(res);
	}

}
