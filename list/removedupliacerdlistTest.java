package list;

import org.junit.Test;

/**
 * Created by songjiguo on 1/2/17.
 */
public class removedupliacerdlistTest {
    @Test
    public void deleteDuplicates2() throws Exception {
        removedupliacerdlist test = new removedupliacerdlist();
        int[] data = {1, 2, 2, 2, 5, 6, 8, 8, 9};
        MyList ll = new MyList(data);
        ll.PrintListAll();

        ListNode ans = test.deleteDuplicates(ll.getHead());

        while (ans != null) {
            System.out.print(ans.val);
            ans = ans.next;
        }
    }

    @Test
    public void deleteDuplicates() throws Exception {
        removedupliacerdlist test = new removedupliacerdlist();
        int[] data = {1, 2, 2, 2, 5, 6, 8, 8, 9};
        MyList ll = new MyList(data);
        ll.PrintListAll();

        ListNode ans = test.deleteDuplicates2(ll.getHead());
        while (ans != null) {
            System.out.print(ans.val);
            ans = ans.next;
        }
    }

}