package list;

public class MyList {
	private ListNode head;
	
	public MyList(int[] a) {
		if (a.length == 0 || a == null) return;
		head = new ListNode(a[0]);
		ListNode p = head;
		for (int i = 1; i < a.length; i++) {
			ListNode tmp = new ListNode(a[i]);
			p.next = tmp;
			p = p.next;
		}	
		p = null; // tail
	}
	
	MyList() {
	}
	
	public void PrintListAll() {
		if (head == null) return;
		
		ListNode p = head;
		System.out.print("[ ");
		for (; p != null; p = p.next) System.out.print(p.val + " ");
		System.out.print("]");
	}
	
	public void PrintListNode(ListNode node) {
		if (node == null) return;
		
		ListNode p = node;
		System.out.print("[ ");
		for (; p != null; p = p.next) System.out.print(p.val + " ");
		System.out.print("]");
	}
	
	public ListNode getHead() {
		return head;
	}
	
}
