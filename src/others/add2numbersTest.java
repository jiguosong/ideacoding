package others;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class add2numbersTest {

	@Test
	public void test() {
		add2numbers tester = new add2numbers();

		ListNode l1 = new ListNode(2);
    	l1.next = new ListNode(4);
    	l1.next.next = new ListNode(3);
    	
    	ListNode l2 = new ListNode(5);
    	l2.next = new ListNode(6);
    	l2.next.next = new ListNode(4);
    	
    	ListNode l3 = tester.addTwoNumbers(l1, l2);
    	            	
        // assert statements
        assertEquals("val must be ", 7, l3.val);
        assertEquals("val must be ", 0, l3.next.val);
        assertEquals("val must be ", 8, l3.next.next.val);
	}

}
