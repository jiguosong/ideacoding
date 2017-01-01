package list;

public class reorderlist {
	
/*	Given a singly linked list L: L0→L1→ ... →Ln-1→Ln,
	reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→...
*/	
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode fast, slow, prev_slow;
        fast = head;
        slow = head;
        prev_slow = null;        
        
        // find the partition node
        while (fast != null && fast.next != null) {
        	fast = fast.next.next;
        	prev_slow = slow;
        	slow = slow.next;
        }
        if (prev_slow != null) prev_slow.next = null;
        
        // slow now should be the middle (odd or even)
        // do the reverse here
        ListNode second_head = reverse_list(slow);  
              
        // do the merge here (interleaving merging)
        ListNode first_head = head;
        while(first_head != null && second_head != null) {
        	ListNode tmp1 = first_head.next;
        	ListNode tmp2 = second_head.next;        	
        	first_head.next = second_head; 
        	if (tmp1 == null) break;
        	second_head.next = tmp1;
        	first_head = tmp1;
        	second_head = tmp2;        	
        }        
    }
	

	// very first failure on the interview with Qualqummn, fuck!! 
	private ListNode reverse_list(ListNode head){
		if (head == null) return null;
		
		ListNode prev, curr;
		prev = null;
		curr = head;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6,7,8};
		MyList ll = new MyList(data);
		ll.PrintListAll();	
		
		System.out.println("\n\nJava: reorder list");
		reorderlist test = new reorderlist();
		test.reorderList(ll.getHead());
		ll.PrintListAll();
	}

}
