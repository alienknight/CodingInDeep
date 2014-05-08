import java.util.*;
import java.io.*;

public class AddList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode iter1 = l1, iter2 = l2;
	    ListNode list = null, tail = null;

	    int carry = 0;
	    while (iter1 != null || iter2 != null || carry != 0) {
	        int num1 = iter1 == null ? 0 : iter1.val;
	        int num2 = iter2 == null ? 0 : iter2.val;
	        int sum = num1 + num2 + carry;
	        carry = sum / 10;
	        sum %= 10;
	        if (list == null) {
	            list = new ListNode(sum);
	            tail = list;
	        } else {
	            tail.next = new ListNode(sum);
	            tail = tail.next;
	        }

	        iter1 = iter1 == null ? null : iter1.next;
	        iter2 = iter2 == null ? null : iter2.next;
	    }
	    return list;
	}
}
