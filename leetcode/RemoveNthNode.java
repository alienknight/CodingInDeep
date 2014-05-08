
public class RemoveNthNode {
	public ListNode removeNthFromEnd(ListNode head, int n) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
	    if(n<1 || head==null)
	        return head;
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode slow = dummy;
	    ListNode fast = dummy;
	    for(int i=0;i<n;i++) {
	        fast = fast.next;
	        if(fast==null)
	            return null;
	    }
	    while(fast.next!=null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    slow.next = slow.next.next;
	    return dummy.next;
	}
}
