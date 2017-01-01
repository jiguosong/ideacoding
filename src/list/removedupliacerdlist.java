package list;

public class removedupliacerdlist {

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;

        ListNode c = head;
        while (c != null && c.next != null && c.val == c.next.val) c = c.next;
        ListNode n = c.next;

        while (c != null && n != null) {
            while (n != null && n.next != null && n.val == n.next.val) n = n.next;
            c.next = n.next;
            c = c.next;
            n = c.next;
        }

        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode c = head;
        ListNode n = head;

        while (c != null && n != null) {
            while (n.next != null && n.val == n.next.val) n = n.next;
            c.next = n.next;
            c = c.next;
            n = n.next;
        }

        return head;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
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

}
