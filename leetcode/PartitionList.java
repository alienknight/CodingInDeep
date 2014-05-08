public class PartitionList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode s = new ListNode(0);
        ListNode s1 = s;
        ListNode l = new ListNode(0);
        ListNode l1 = l;
        while(head!=null) {
            ListNode next = head.next;			//Important
            if(head.val<x) {
                s.next = head;
                s = s.next;
            }
            else {
                l.next = head;
                l = l.next;
                l.next=null;					//Important
            }
            head = next;
        }
        s.next = l1.next;
        return s1.next;
	}
}
