
public class FindLoop {
//	public static class Node {
//		Node next = null;
//	}
//	public static boolean find(Node n) {
//		Node slow = n, fast = n;
//		while(fast!=null && fast.next!=null) {
//			slow = slow.next;
//			fast = fast.next.next;
//			if(slow == fast)
//				return true;
//		}
//		return false;
//	}
	  public static class Node {

		     public int value;

		     public Node next;
		  }
		 
		  public static boolean hasLoops( Node myList ) {
		      Node slow = myList;
		      Node fast = myList;
		      
		      //fast node not reach the end
		      while(fast != null && fast.next != null) { 
		          slow = slow.next;
		          fast = fast.next.next;
		          
		          //If met, there is a loop
		          if(slow == fast)
		              return true;
		      }
		      
		      //fast node reach the end, there is no loop
		      return false;
		  }
	public static void main(String[] args) {
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();
		Node e = new Node();
		Node f = new Node();
		Node g = new Node();
		Node h = new Node();
		Node i = new Node();
		Node j = new Node();
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = i;
		i.next = j;
		//j.next = d;
		System.out.print(hasLoops(null));
	}
}
