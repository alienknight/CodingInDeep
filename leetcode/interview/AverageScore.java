import java.util.*;
public class AverageScore {
	public static class TestResult {
		int studentId;
		String testDate;
		int testScore;
		public TestResult (int a, int b) {
			studentId = a;
			testScore = b;
		}
	}
	public static Map<Integer, Double> calculateFinalScores(List<TestResult> results) {
		if(results==null || results.size()==0)
			return null;
		Map<Integer, Double> res = new HashMap<Integer, Double>();
		HashMap<Integer, PriorityQueue<Integer>> scores = new HashMap<Integer, PriorityQueue<Integer>>();
		for(TestResult result : results) {
			PriorityQueue<Integer> queue = scores.get(result.studentId);
			if(queue==null) {
				queue = new PriorityQueue<Integer>();
				scores.put(result.studentId, queue);
			}
			queue.add(result.testScore);
			if(queue.size() > 5)
				queue.poll();
		}
		for(int id : scores.keySet()) {
			double avg = 0;
			for(int score : scores.get(id))
				avg += score;
			res.put(id, avg / 5);
		}
		return res;
	}
	public static void main(String[] args) {
		TestResult a = new TestResult(1,40);
		TestResult b = new TestResult(1,50);
		TestResult c = new TestResult(1,60);
		TestResult d = new TestResult(1,70);
		TestResult e = new TestResult(1,80);
		TestResult f = new TestResult(1,90);
		TestResult g = new TestResult(1,100);
		TestResult h = new TestResult(2,35);
		TestResult i = new TestResult(2,36);
		TestResult j = new TestResult(2,40);
		TestResult k = new TestResult(2,51);
		TestResult l = new TestResult(2,54);
		TestResult m = new TestResult(2,59);
		List<TestResult> t = new ArrayList<TestResult>();
		t.add(a);
		t.add(b);
		t.add(c);
		t.add(d);
		t.add(e);
		t.add(f);
		t.add(g);
		t.add(h);
		t.add(i);
		t.add(j);
		t.add(k);
		t.add(l);
		t.add(m);
		calculateFinalScores(t);
	}
}
