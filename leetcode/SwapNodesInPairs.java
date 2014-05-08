
public class SwapNodesInPairs {


ListNode *swapPairs(ListNode *head) {
    if (!head || !head->next) return head;
    ListNode *ppre = NULL, *prev = head, *curr = head->next;

    while (curr) { //left at least 2 node
        prev->next = curr->next;
        curr->next = prev;
        if (ppre) ppre->next = curr;
        else head = curr;

        ppre = prev;
        prev = prev->next;
        if (prev) curr = prev->next; //left at least 1 node
        else curr = NULL; //none left
    }
    return head;
}

ListNode *swapPairs(ListNode *head) {
    if (!head || !head->next) return head;
    ListNode *second = head->next;
    head->next = second->next;
    second->next = head;
    head = second;
    head->next->next = swapPairs(head->next->next); //must be called after updating head
    return head;
}


//    public ListNode swapPairs(ListNode head) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(head==null || head.next==null) return head;
//        ListNode cur = head;
//        ListNode temp = null;
//        ListNode temp1 = null;
//        if(head.next.next==null)
//        {
//             temp = cur.next;
//             cur.next = temp.next;
//             temp.next = cur;
//             head = temp; 
//             return head;
//        }
//        while(cur!=null && cur.next!=null && cur.next.next!=null)
//        {
//            if(cur==head)
//            {
//                temp = cur.next;
//                cur.next = temp.next;
//                temp.next = cur;
//                head = temp;
//            }
//            else
//            {
//                temp = cur.next;
//                temp1 = temp.next;
//                cur.next = temp1;
//                temp.next = temp1.next;
//                temp1.next = temp;
//                cur = cur.next.next;
//            }          
//        }      
//        return head;
//    }
}

/*
 * public ListNode swapPairs(ListNode head) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if(head==null || head.next==null)
        return head;
    ListNode n = head.next;
    head.next = n.next;
    n.next = head;
    head = n;
    head.next.next = swapPairs(head.next.next);
    return head;
}*/
