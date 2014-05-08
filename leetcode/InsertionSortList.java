    public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        while(head!=null) {
            while(cur.next!=null && cur.next.val<=head.val) cur = cur.next;
            ListNode temp = head.next;
            if(cur.next==null) {
                cur.next = head;
                cur.next.next = null;
            }
            else {
                head.next = cur.next;
                cur.next = head;
            }
            cur = dummy;
            head = temp;
        }
        return dummy.next;
    }