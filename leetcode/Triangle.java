import java.util.*;
public class Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		for(int i = triangle.size() - 2; i >= 0; i--)
		{
		    for(int j = 0; j < triangle.get(i).size(); j++)
		    {
		        triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
		    }
		}
		return triangle.get(0).get(0);
		}
}
//public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
//// Start typing your Java solution below
//// DO NOT write main() function
//if(triangle.size()==0 || triangle.get(0).size()==0)
//  return 0;
//int[][] f = new int[triangle.size()][triangle.size()];
//f[0][0] = triangle.get(0).get(0);
//if(triangle.size()==1)
//  return f[0][0];
//int min = Integer.MAX_VALUE;
//for(int i=1;i<triangle.size();i++) {
//  min = Integer.MAX_VALUE;
//  for(int j=0;j<triangle.get(i).size();j++) {
//      f[i][j] = triangle.get(i).get(j)+Math.min(j>0?f[i-1][j-1]:Integer.MAX_VALUE, j<i?f[i-1][j]:Integer.MAX_VALUE);
//      min = Math.min(min, f[i][j]);
//  }
//}
//return min;
//}
/*


int minimumTriangle(vector<vector<int> > &t) {
    int n = t.size();
    vector<int> p (n+1, 0);
    while(n-- > 0)
        for(int i = 0; i <= n; ++i) 
            p[i] = t[n][i] + ((p[i] < p[i+1])? p[i] : p[i+1]);
    return p[0];
}

*/


