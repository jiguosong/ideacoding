package list;

public class intersectionList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		
		ListNode p1 = headA, p2 = headB;
		int len1 = 0, len2 = 0;
		int diff = 0;
		
		while (p1 != null) {
			p1 = p1.next;
			len1++;
		}
		while (p2 != null) {
			p2 = p2.next;
			len2++;
		}
		
		if (len1 > len2) {  // A is longer
			diff = len1 - len2;
			p1 = headA;
			p2 = headB;
		} else {   // B is longer
			diff = len2 - len1;
			p1 = headB;
			p2 = headA;
		}
		
		// p1 is longer list, and diff is the offset
		len1 = 0;
		while(p1 != null) {
			p1 = p1.next;
			len1++;
			if (len1 == diff) break;
		}
		
		while (p1 != null && p2 != null) {
			if (p1.val == p2.val) return p1;
			p1 = p1.next;
			p2 = p2.next;
		}	
		
		return null;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		intersectionList test = new intersectionList();
		
		int[] data = {1,2,3,4,5,6,7,8};
		MyList ll = new MyList(data);
			
		int[] data2 = {9,8,7,6,5};
		MyList ll2 = new MyList(data2);
			
		
		ListNode headA = ll.getHead();
		ListNode headB = ll2.getHead();
		headB.next.next.next.next.next = headA.next.next.next;
		
		ListNode ans = test.getIntersectionNode(headA, headB);
		ll.PrintListAll();
		System.out.println();
		ll2.PrintListAll();
		System.out.println();
		System.out.println(ans.val);
	}

}
