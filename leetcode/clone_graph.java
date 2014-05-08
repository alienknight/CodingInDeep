import java.io.*;
import java.util.*;

public class clone_graph {

public class Node{
	Vector<Node> neighbors;
}

public void clone(Node root)
{
//	int result[] = new int[2];
//	int a = result.length;
//	Vector<String> arr = new Vector<String>();
//	arr.size();
	HashMap<Node, Node> map = new HashMap<Node, Node> ();
	Queue<Node> queue = new LinkedList<Node> ();	//Queue is an interface, cannot be instantiated directly
	Node root_copy = new Node();
	queue.add(root);
	map.put(root, root_copy);	
	while(!queue.isEmpty())
	{
		Node temp = queue.peek();
		queue.poll();
		if(!temp.neighbors.isEmpty()){
		for(Node n : temp.neighbors)
		{
			if(!map.containsKey(n))
			{
				Node n_copy = new Node();
				map.put(n, n_copy);
				map.get(temp).neighbors.add(n_copy);
			}
			else
			{
				map.get(temp).neighbors.add(map.get(n));
			}
		}
		}
	}	
}
}
