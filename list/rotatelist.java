package list;

public class rotatelist {
	
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode p, q, last = null, prev = null;
        
        int len = 0;        
        for (q = head; q != null; last = q, q = q.next) len++; 
        
        k = k%len;       
        int i = 0;
        
        for (p = head; i < len - k - 1; p = p.next, i++);

        ListNode newhead = p.next;
        last.next = head;
        p.next = null;
        
        if (newhead != null) head = newhead;
        return head;        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6,7,8};
		MyList ll = new MyList(data);
		ll.PrintListAll();	
		
		System.out.println("\n\nJava: reverse node");
		rotatelist test = new rotatelist();
		ListNode res = test.rotateRight(ll.getHead(), 3);
		ll.PrintListNode(res);

	}

}
