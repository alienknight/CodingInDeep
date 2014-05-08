import java.util.*;
public class NthToEnd {
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int length = 1;
	        if(head==null) return head;
	        if(n==0) return head;
	        ListNode test = head;
	        ListNode result = head;
	        while(test.next!=null)
	        {
	            test = test.next;
	            length++;
	        }
	        if(length==n) return head.next;
	        for(int i=0;i<length-n-1;i++)
	        {
	            result = result.next;
	        }
	        if(result.next!=null)
	            result.next = result.next.next;
	        else
	            return null;
	        return head;
	    }
}
/*
public ListNode removeNthFromEnd(ListNode head, int n) {
// use two pointers,fast pointer forward n steps first
ListNode re=head,fast=head,slow=head;
for(int i=0;i<n;i++) fast=fast.next;
if(fast==null) return head.next; //head node need to be removed
while(fast.next!=null){
    fast=fast.next;
    slow=slow.next;
}
slow.next=slow.next.next;
return head;
}
*/