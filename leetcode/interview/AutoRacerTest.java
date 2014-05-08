import java.util.*;
import java.io.*;
public class AutoRacerTest {
    public static class Racer {
        int id;
        int start;
        int end;
        int score;
        public Racer(int a, int b, int c) {
            id = a;
            start = b;
            end = c;
        }
    }
    public static class IntervalNode {
        int val;
        int key;
        IntervalNode left;
        IntervalNode right;
        public IntervalNode(int a, int b) {
            val = a;
            key = b;
        }
    }
    public static void insertTree(IntervalNode root, IntervalNode t) {
        if(root.val > t.val) {
            if(root.left==null) root.left = t;
            else insertTree(root.left, t);
        }else {
            if(root.right==null) root.right = t;
            else insertTree(root.right, t);
        }
    }
    public static void Score(Racer r, IntervalNode root, HashMap<Integer,Integer> map, int[] count) {
        if(root==null) return ;
        if(root.val <= r.start) Score(r, root.right, map, count);
        else if(root.val >= r.end) Score(r, root.left, map, count);
        else {
            if(map.containsKey(root.key)) count[0]++;
            else map.put(root.key, 1);
            Score(r, root.left, map, count);
            Score(r, root.right, map, count);
        }
        r.score = count[0];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        IntervalNode root = null;
        ArrayList<Racer> list = new ArrayList<Racer>();
        while ((line = br.readLine()) != null) {
            // ...
            String[] info = line.split(" ");
            if(info.length != 3) break;
            if(info[0].length()>9 && !info[0].equals(1000000000)) continue;
            int id = Integer.parseInt(info[0]);
            int start = Integer.parseInt(info[1]);
            int end = Integer.parseInt(info[2]);
            Racer r = new Racer(id,start,end);
            list.add(r);
            if(root==null) root = new IntervalNode((start+end)/2, -1);
            IntervalNode n1 = new IntervalNode(r.start, r.id);
            IntervalNode n2 = new IntervalNode(r.end, r.id);
            insertTree(root, n1);
            insertTree(root, n2);
        }
        for(Racer r : list) {
            int[] rec = {0};
            Score(r,root,new HashMap<Integer,Integer>(),rec);
        }
        Collections.sort(list, new Comparator<Racer>() {
            public int compare(Racer r1, Racer r2) {
                if(r1.score < r2.score) return -1;
                else if(r1.score > r2.score) return 1;
                else if(r1.id < r2.id) return -1;
                else return 1;
            }
        });
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i).id);
            System.out.print(" ");
            System.out.println(list.get(i).score);
        }
    }
//5
//486869240777 100 200
//3 110 190
//4 105 145
//1 90 150
//5 102 198
//	public static class Racer {
//		int id;
//		int start;
//		int end;
//		int score;
//		public Racer(int a, int b, int c) {
//			id = a;
//			start = b;
//			end = c;
//		}
//	}
//	public static class IntervalNode {
//		int val, key;
//		IntervalNode left;
//		IntervalNode right;
//		public IntervalNode(int a, int b) {
//			val = a;
//			key = b;
//		}
//	}
//	public static void insertTree(IntervalNode root, IntervalNode n) {
//		searchTree(root,n);
//	}
//	public static void searchTree(IntervalNode root, IntervalNode t) {
//		if(root.val > t.val) {
//			if(root.left==null) root.left = t;
//			else searchTree(root.left,t);
//		}else {
//			if(root.right==null) root.right = t;
//			else searchTree(root.right,t);
//		}
//	}
//	public static void Score (Racer r, IntervalNode root, HashMap<Integer,Integer> map, int[] count) {
//		if(root==null) return ;
//		if(root.val <= r.start)
//			Score(r,root.right,map,count);
//		else if(root.val >= r.end)
//			Score(r,root.left,map,count);
//		if(root.val > r.start && root.val < r.end) {
//			if(map.containsKey(root.key)) count[0]++;
//			else map.put(root.key,1);
//			Score(r,root.right,map,count);
//			Score(r,root.left,map,count);
//		}
//		r.score = count[0];
////		Collections.sort(racers, new Comparator<Racer>(){
////			public int compare(Racer r1, Racer r2) {
////				if(r1.end<r2.end) return -1;
////				else return 1;
////			}
////		});
//	}
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String line = br.readLine();
//		int num = Integer.parseInt(line);
//		IntervalNode root = null;
//		ArrayList<Racer> list = new ArrayList();
//		for(int i=0;i<num;i++) {
//			String s = br.readLine();
//			String[] info = s.split(" ");
//			int id = Integer.parseInt(info[0]);
//			int start = Integer.parseInt(info[1]);
//			int end = Integer.parseInt(info[2]);
//			Racer r = new Racer(id,start,end);
//			list.add(r);
//			if(root==null) root = new IntervalNode((start+end)/2, -1);
//			IntervalNode n1 = new IntervalNode(r.start, r.id);
//			IntervalNode n2 = new IntervalNode(r.end, r.id);
//			insertTree(root,n1);
//			insertTree(root,n2);
//		}
//		for(int i=0;i<list.size();i++) {
//			int[] rec = {0};
//			Score(list.get(i),root,new HashMap<Integer,Integer>(),rec);
//		}
//		Collections.sort(list, new Comparator<Racer>(){
//			public int compare(Racer r1, Racer r2) {
//				if(r1.score < r2.score) return -1;
//				else if(r1.score > r2.score) return 1;
//				else if(r1.id < r2.id) return -1;
//				else return 1;
//			}
//		});
//		for(int i=0;i<list.size();i++) {
//			System.out.print(list.get(i).id);
//			System.out.print(" ");
//			System.out.println(list.get(i).score);
//		}
//	}
}
