import java.io.*;
import java.util.*;
public class Intersection {
//	public static int[] intersect(int[] a, int[] b) {
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		ArrayList<Integer> res = new ArrayList<Integer>();
//		for(int i=0;i<a.length;i++)
//			map.put(a[i], 1);
//		for(int j=0;j<b.length;j++)
//			if(map.containsKey(b[j]) && 
//					map.get(b[j])==1) {
//				res.add(b[j]);
//				map.put(b[j], 2);
//			}
//		int[] result = new int[res.size()];
//		int i = 0;
//		for(Integer n : res)
//			result[i++] = n;
//		return result;
//	}
	public static List<Integer> intersection (List<Integer> a, List<Integer> b) {
	    if(a==null || b==null)
	        return null;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    for(int i=0; i<a.size(); i++)
	        map.put(a.get(i), 1);
	    for(int j=0; j<b.size(); j++) {
	        if(map.containsKey(b.get(j)) && map.get(b.get(j))==1) {
	            res.add(b.get(j));
	            map.put(b.get(j), 2);
	        }
	    }
	    return res;
	}
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList();
		ArrayList<Integer> b = new ArrayList();
		a.add(4);
		a.add(2);
		a.add(73);
		a.add(11);
		a.add(-5);
		b.add(-5);
		b.add(7);b.add(73);b.add(-1);b.add(9);b.add(9);b.add(4);
		System.out.print(intersection(a,b));
	}
}
