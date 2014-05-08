    public ListNode sortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head==null || head.next==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(p));
    }
    public ListNode merge(ListNode start, ListNode end) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(start!=null && end!=null) {
            if(start.val<=end.val) {
                cur.next = start;
                start = start.next;
            }else {
                cur.next = end;
                end = end.next;
            }
            cur = cur.next;
        }
        if(start!=null) cur.next = start;
        else cur.next = end;
        return dummy.next;
    }