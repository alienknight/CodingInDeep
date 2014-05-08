
import java.util.*;

public class ReverseKGroup {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || k <= 1)
			return head;
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode cur = head;
		ListNode top = null;
		ListNode temp = null;
		while (cur != null) {
			for (int i = 0; i < k; i++) {
				if (cur == null) {
					if (top == null)
						return head;
					return top;
				}
				stack.push(cur);
				cur = cur.next;
			}
			while (!stack.isEmpty()) {
				if (top == null) {
					top = stack.pop();
					temp = top;
				} else {
					temp.next = stack.pop();
					temp = temp.next;
				}
			}
			temp.next = cur;
		}
		return top;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		a.next = b;
		reverseKGroup(a, 2);
	}
}

/*
public:
ListNode *reverseKGroup(ListNode *head, int k) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    if (!head || k <= 1) return head;

    ListNode dummy(0);
    dummy.next = head;
    ListNode *pre = &dummy;

    int i = 0;
    while (head) {
        i++;
        if (i % k == 0) {
            pre = reverse(pre, head->next);                
            head = pre->next;
        } else {
            head = head->next;   
        }
    }

    return dummy.next;
}

ListNode *reverse(ListNode *pre, ListNode *next) {
    ListNode *last = pre->next;
    ListNode *cur = last->next;
    while (cur != next) {
        last->next = cur->next;
        cur->next = pre->next;
        pre->next = cur;

        cur = last->next;
    }
    return last;
}
};*/