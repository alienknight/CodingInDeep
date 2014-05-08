
public class RemoveDuplicatesList {
    public ListNode deleteDuplicates(ListNode head) {	
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null || head.next==null)
            return head;
        ListNode n = head;
        while(n!=null && n.next!=null) {			//Important
            if(n.val==n.next.val) {
                n.next = n.next.next;
                continue;							//Important
            }
            n = n.next;
        }
        return head;
    }
}
