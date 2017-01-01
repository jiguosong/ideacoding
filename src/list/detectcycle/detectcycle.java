//package list.detectcycle;
//
//import list.ListNode;
//import list.MyList;
//
//public class detectcycle {
//	public boolean hasCycle(ListNode head) {
//		if (head == null) return false;
//
//		ListNode fast = head;
//		ListNode slow = head;
//
//
//
//		while(fast != null && fast.next != null) {
//			fast = fast.next.next;
//			slow = slow.next;
//			if (fast == slow) return true;
//		}
//
//		return false;
//	}
//
//	public ListNode findFirstCycleNode(ListNode head) {
//		if (head == null) return null;
//
//		ListNode fast = head;
//		ListNode slow = head;
//
//		while(fast != null && fast.next != null) {
//			fast = fast.next.next;
//			slow = slow.next;
//			if (fast == slow) break;
//		}
//
//		if (fast != null && fast.next != null) {
//			slow = head;
//			while(true) {
//				slow = slow.next;
//				fast = fast.next;
//				if (fast == slow) break;
//			}
//			return fast;
//		} else {
//			return null;
//		}
//	}
//
//	// this is from other::duplicates. Same idea
//	// Solution 2:  every item "points" at another node, so this is like a graph. We can find a cycle if there are duplicated node
//	// this is similar to the finding cycle in linked list. We can use fast ans slow
//	public int findDuplicate_cycle(int[] arr) {
//		if(arr == null || arr.length == 0)  return 0;
//
//		int res = 0;
//		int slow_idx = 0;
//		int fast_idx = 0;
//
//		do{
//			slow_idx = arr[slow_idx];
//			fast_idx = arr[arr[fast_idx]];
//		} while(slow_idx != fast_idx);   // assume there is cycle
//
//		while(res != slow_idx) {
//			slow_idx = arr[slow_idx];
//			res = arr[res];
//		}
//
//		return res;
//	}
//
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		detectcycle test = new detectcycle();
//		int[] data = {1,2,3,4,5,6,7,3,9};
//		MyList ll = new MyList(data);
//		ll.PrintListAll();
//		ListNode head = ll.getHead();
//		head.next.next.next.next.next.next = head.next.next;
//		System.out.println();
//		if (true == test.hasCycle(head)) System.out.println("Yes");
//		else System.out.println("No");
//
//		ListNode ans = test.findFirstCycleNode(head);
//		if (ans != null) System.out.println("fisrt cycled node is " + ans.val);
//		else System.out.println("No found");
//
//		int[] A5 = {1,2,3,3,4};
//		int finddupli = test.findDuplicate_cycle(A5);
//		System.out.println("found duplicated one: " + finddupli);
//	}
//
//}
