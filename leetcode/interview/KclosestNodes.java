import java.util.*;
public class KclosestNodes {
//	public static class Node{
//		int x;
//		int y;
//		public Node(int a, int b) {
//			x = a;
//			y = b;
//		}
//	}
//	public static ArrayList<Node> find (ArrayList<Node> list, int k) {
//		ArrayList<Node> res = new ArrayList<Node>();
//		if(list==null || list.size()==0 || k==0)
//			return res;
//		Comparator<Node> comparator = new Comparator<Node>(){
//			public int compare(Node a, Node b) {
//				long alen = a.x * a.x + a.y * a.y;
//				long blen = b.x * b.x + b.y * b.y;
//				if(alen < blen)
//					return 1;
//				else if(alen > blen)
//					return -1;
//				else return 0;
//			}
//		};
//		PriorityQueue<Node> queue = new PriorityQueue<Node>(k,comparator);
//		for(Node n : list) { 
//			queue.add(n);
//			if(queue.size()>k)
//				queue.poll();
//		}
//		for(Node m : queue)
//			res.add(m);
//		return res;
//	}
	  public static class Point {

		    public double x;

		    public double y;
		    public Point(double a, double b) {
		    	x = a;
		    	y = b;
		    }

		  } 
		  public static Point[] closestk( Point  myList[], int k ) {
		      //Check edge case
		      if(myList == null || myList.length ==0 || k <=0)
		          return null;
		      Point[] res = new Point[k];
		      //Define the comparator of the priority queue;
		      Comparator<Point> comparator = new Comparator<Point>() {
		          //Define the compare() function, and make element in the queue sored in
		          //  reverse natural order according to its distance to origin;
		          public int compare(Point a, Point b) {
		              double alen = a.x * a.x + a.y * a.y;
		              double blen = b.x * b.x + b.y * b.y;
		              if(alen < blen)
		                  return 1;
		              else if(alen > blen)
		                  return -1;
		              else
		                  return 0;
		          }
		      };
		      //Define the priority queue
		      PriorityQueue<Point> queue = new PriorityQueue<Point> (k, comparator);
		      //Add point to queue
		      for(Point p : myList) {
		          queue.add(p);
		          //Remove the farthest point when size is beyond k
		          if(queue.size() > k)
		              queue.poll();
		      }
		      //Add K cloest points in result array
		      for(int i=0; i<k; i++)
		          res[i] = queue.poll();
		      return res;          
		  }
	public static void main(String[] args) {
		Point a = new Point(1.0,2.0);
		Point b = new Point(3.0,5.0);
		Point c = new Point(-2.0,-2.0);
		Point d = new Point(-1.0,0.0);
		Point e = new Point(10.0,2.0);
		Point f = new Point(-1.0,7.0);
		Point g = new Point(6.0,5.0);
		Point[] l = {a,b,c,d,e,f,g};		
		closestk(l,3);
	}
}
