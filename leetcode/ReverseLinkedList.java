
public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preM = dummy;
        ListNode pre = dummy;
        for(int i=1;i<=n;i++) {
            if(i==m)
                preM = pre;
            if(i>m && i<=n) {
                pre.next = head.next;
                head.next = preM.next;
                preM.next = head;
                head = pre;
            }
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }
}


////////////////////////// HOW TO SWAP NODES IN LINKED LIST?