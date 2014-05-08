public class AddTwoNumber {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(l1,l2,0);
    }
    public static ListNode helper(ListNode l1, ListNode l2, int carry) {
        if(l1==null && l2==null && carry==0)
            return null;
        int sum = (l1==null?0:l1.val) + (l2==null?0:l2.val) + carry;
        int carry_new = sum/10;
        sum %= 10;
        ListNode n = new ListNode(sum);
        n.next = helper(l1==null?null:l1.next,l2==null?null:l2.next,carry_new);
        return n;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		addTwoNumbers(l1,l2);
	}
}
