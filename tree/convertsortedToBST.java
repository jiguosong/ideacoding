package tree;

import java.util.Iterator;
import java.util.List;

import list.MyList;

public class convertsortedToBST {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) return null;
		TreeNode root = null;
		root = sortedArrayToBST_helper(num, 0, num.length-1);		
		return root;
	}
	
	private TreeNode sortedArrayToBST_helper(int[] num, int start, int end) {
		if (start > end) return null;
		
		int mid = start + (end-start)/2;
		TreeNode root = new TreeNode(num[mid]);
		
		root.left = sortedArrayToBST_helper(num, start, mid-1);
		root.right = sortedArrayToBST_helper(num, mid+1, end);
		
		return root;
	}
	
	static ListNode h;
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		TreeNode root = null;
		
		int len = 0;
		h = head;
		ListNode p = head;
		while(p != null) {
			p = p.next;
			len++;
		}
		root = sortedListToBST_helper(0, len-1);
		return root;
	}
	
	private TreeNode sortedListToBST_helper(int start, int end) {
		if (start > end) return null;
		
		int mid = start + (end - start)/2;
		
		TreeNode left = sortedListToBST_helper(start, mid-1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;		
		TreeNode right = sortedListToBST_helper(mid+1, end);
		
		root.left = left;
		root.right = right;		
		return root;
	}
	
	public ListNode buildList(int[] a) {
		if (a.length == 0 || a == null) return null;
		ListNode head = new ListNode(a[0]);
		ListNode p = head;
		for (int i = 1; i < a.length; i++) {
			ListNode tmp = new ListNode(a[i]);
			p.next = tmp;
			p = p.next;
		}	
		p = null; // tail
		
		return head;
	}
	
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		convertsortedToBST test = new convertsortedToBST();
		int[] num = {1,2,3,4,5,6};
		TreeNode root = test.sortedArrayToBST(num);

		AllTraverseTree traverse = new AllTraverseTree();
		List<List<Integer>> ans = traverse.levelOrder(root);	
		Iterator<List<Integer>> it = ans.iterator();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}

		int[] data = {1,2,3,4,5,6,7,8,9,10,11,12};
		ListNode head = test.buildList(data);
		ListNode kk = head;
		System.out.println();
		while(kk != null){
			System.out.print(kk.val);
			kk = kk.next;
		}
		
		TreeNode root2 = test.sortedListToBST(head);
		ans = traverse.levelOrder(root2);	
		it = ans.iterator();
		System.out.println();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}
		
		
	}

}
