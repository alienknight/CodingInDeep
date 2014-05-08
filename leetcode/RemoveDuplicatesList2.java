public class RemoveDuplicatesList2 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
	    ListNode re,tail,pre=head,cur=head;       
	    re = new ListNode(0);
	    tail=re;        
	    while(cur!=null&&cur.next!=null){
	        while(cur.next!=null&&cur.val==cur.next.val) cur=cur.next;
	        if(pre==cur){  //distinct value                
	            tail.next=pre;
	            tail=tail.next;
	        }                                         
	        pre=cur.next;
	        cur=cur.next;          
	    }
	    tail.next=cur; //add the last value
	    return re.next; //dump the dummy node
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode t = new ListNode(1);
		head.next = t;
		deleteDuplicates(head);
	}
}

/*
 *     public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode cur = head;
        boolean dul = false;
        ListNode dummy = new ListNode(0);
        dummy.next = cur;
        ListNode n = dummy;
        while(cur!=null && cur.next!=null) {
            if(cur.val == cur.next.val) {
                dul = true;
            }
            else {
                if(!dul) {
                    n.next = cur;
                    n = n.next;
                }
                dul = false;
            }
            cur = cur.next;
        }
        if(!dul)
            n.next = cur;
        else
            n.next = null;
        return dummy.next;
    }
    */
