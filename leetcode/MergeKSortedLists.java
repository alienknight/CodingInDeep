import java.util.*;
public class MergeKSortedLists {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists==null || lists.size()==0)
            return null;
        ArrayList<ListNode> l = new ArrayList<ListNode>();
        for(ListNode test : lists) {
            if(test!=null)
                l.add(test);
        }
        if(l.size()==0)
            return null;
        //sorts(lists);
        ListNode n = new ListNode(0);
        ListNode m = n;
        while(l.size()!=0) {
            sorts(l);
            ListNode temp = l.get(0);
            m.next = temp;
            m = m.next;
            if(temp.next!=null)
                l.set(0,temp.next);
            else
                l.remove(0);
        }
        return n.next;
    }
    public static void sorts(ArrayList<ListNode> lists) {
        Collections.sort(lists, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                if(n1.val < n2.val)
                    return -1;
                else if(n1.val > n2.val)
                    return 1;
                else
                    return 0;
            }
        });
    }
    public static void main(String[] args) {
    	ListNode a = null;
    	ListNode b = null;
    	ListNode c = null;
    	ArrayList<ListNode> lists = new ArrayList<ListNode>();
    	lists.add(a);
    	lists.add(b);
    	lists.add(c);
    	mergeKLists(lists);
    }
}


/*
public ListNode mergeKLists(ArrayList<ListNode> lists) {
// Start typing your Java solution below
// DO NOT write main() function
if(lists==null || lists.size()==0)
    return null;
Comparator<ListNode> comparator = new Comparator<ListNode>() {
    public int compare(ListNode a, ListNode b) {
        if(a.val < b.val)
            return -1;
        else if(a.val > b.val)
            return 1;
        else 
            return 0;
    }
};
PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),comparator);
for(ListNode n : lists) {
    if(n!=null)
        heap.add(n);
}
ListNode head = null;
ListNode cur = null;
while(!heap.isEmpty()) {
    if(head==null) {
        head = heap.poll();
        cur = head;
        if(head.next!=null)
            heap.add(head.next);
    }
    else {
        cur.next = heap.poll();
        cur = cur.next;
        if(cur.next!=null)
            heap.add(cur.next);
    }
}
return head;
}*/