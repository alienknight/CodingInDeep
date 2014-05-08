
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode fast = head;
        ListNode slow = head;
        if(head==null || n==0 || head.next==null)
            return head;
        int count=0;
        while(fast!=null)
        {
            fast = fast.next;
            count++;
        }
        int k = n%count;
        if(k==0) return head;
        fast = head;
        for(int i=0;i<k;i++)
        {
            fast = fast.next;
        }
        while(fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode headnew = slow.next;
        fast.next = head;
        slow.next = null;
        return headnew;
    }
}
