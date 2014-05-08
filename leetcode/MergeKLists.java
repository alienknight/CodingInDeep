import java.util.*;
public class MergeKLists {
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
	      LinkedList<ListNode> result = new LinkedList<ListNode>();
	      if(lists.size()==0 || lists==null) return null;
	      return select(lists,result);
	  }
	  public static ListNode select(ArrayList<ListNode> lists, LinkedList<ListNode> result) {
	      if(lists.size()==0) return null;
	      int temp = Integer.MAX_VALUE;
	      int count = -1;
	      for(int i=0;i<lists.size();i++)
	      {
	          if(lists.get(i)==null) continue;
	          if(lists.get(i).val < temp)
	          {
	              temp = lists.get(i).val;
	              count = i;
	          }
	      }
	      if(count==-1) return null;
	      ListNode a = lists.get(count);
	      result.add(a);
	      if(lists.get(count).next!=null)
	          lists.add(lists.get(count).next);
	      lists.remove(count);
	      a.next = select(lists,result);//Important
	      return a;
	  }
	  public static void main(String[] args)
	  {
		  ListNode a = new ListNode(1);
		  ListNode b = new ListNode(2);
		  ListNode c = new ListNode(2);
		  ListNode d = new ListNode(1);
		  ListNode e = new ListNode(1);
		  ListNode f = new ListNode(2);
		  a.next = b;
		  b.next = c;
		  d.next = e;
		  e.next = f;
		  ArrayList<ListNode> lists = new ArrayList<ListNode> ();
		  lists.add(a);
		  lists.add(d);
		  mergeKLists(lists);
	  }
}
/*
 *     public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(lists==null || lists.size()==0)
            return null;
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2){
                if(n1.val<n2.val)
                    return -1;
                else if(n1.val>n2.val)
                    return 1;
                else
                    return 0;
            }
        };
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),comparator);
        for(ListNode n : lists)
            if(n!=null)
                queue.add(n);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!queue.isEmpty()) {
            ListNode temp = queue.poll();
            if(temp.next!=null)
                queue.add(temp.next);
            cur.next = temp;
            cur = cur.next;
        }
        return dummy.next;
    }
    */
