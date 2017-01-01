package list;

public class removeNendnode {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return null;        
        int len = 0;
        ListNode p = head;
        
        while (p != null) {
        	len++;
        	p = p.next;
        }        
        n = n%len;
        p = head;          
        for (int i = 0; i < len - n - 1; i++) {
        	p = p.next;
        }
        if (p.next != null) p.next = p.next.next;
       
        if (n == 0) return head.next;
        else return head;
    }
	
	// assume n is smaller than lenth
	public ListNode removeNthFromEnd_useptr(ListNode head, int n) {
		if (head == null || n <= 0) return null;
		ListNode first = head;
		ListNode second = head;
		ListNode prev = null;
		
		for (int i = 0; i < n && first != null; i++) first = first.next;
		
		while (first != null) {
			first = first.next;
			prev = second;
			second = second.next;
		}
		
		if (prev == null) head = head.next;
		else prev.next = prev.next.next;
		
		return head;	
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Java: removeNthNode");
		int[] data = {1,2,3,4,5};
		MyList ll = new MyList(data);
		ll.PrintListAll();
		
		removeNendnode test = new removeNendnode();
		ListNode res = test.removeNthFromEnd(ll.getHead(), 5);
		System.out.println(" ");
		ll.PrintListNode(res);

		removeNendnode test2 = new removeNendnode();
		ListNode res2 = test2.removeNthFromEnd_useptr(ll.getHead(), 5);
		System.out.println(" ");
		ll.PrintListNode(res2);

	}

}
