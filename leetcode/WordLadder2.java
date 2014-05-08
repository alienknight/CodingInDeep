
import java.util.*;
public class WordLadder2 {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
            ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>> ();
	        if(start.equals(end))
	            return res;
	        HashSet<String> temp = new HashSet<String>();
	        ArrayList<String> ini = new ArrayList<String> ();
	        ini.add(start);
	        ArrayDeque<ArrayList<String>> queue = new ArrayDeque<ArrayList<String>> ();
	        queue.add(ini);
	        while(!queue.isEmpty()) {
	            ArrayList<String> ss = queue.pollFirst();
	            String s = ss.get(ss.size()-1);
	            for(int i=0;i<s.length();i++)
	                for(int j=97;j<123;j++) {
	                    String t = new String(s);
	                    t = t.substring(0,i) + (char)j + t.substring(i+1);
	                    if(t.equals(end)) {
	                        ArrayList<String> tt = new ArrayList<String>(ss);
	                        tt.add(t);
	                        tt.add(end);
	                        res.add(tt);
	                        continue;
	                    }
	                    if(dict.contains(t) && !temp.contains(t)) {
	                        ArrayList<String> ts = new ArrayList<String>(ss);
	                        temp.add(t);
	                        ts.add(t);
	                        queue.add(ts);
	                    }
	                }
	           if(!res.isEmpty())
	            return res;
	        }
	        return res;
    }
}


/*
 * class Solution {
    vector<string> vdict;
    vector<vector<int> > adj;

    void build(unordered_set<string> &dict){
        int i, j;
        vdict.clear();
        unordered_map<string, int> ids;
        for(auto it=dict.begin(); it != dict.end(); it++){
            ids[*it] = vdict.size();
            vdict.push_back(*it);

        }
        adj.clear();
        adj.resize(vdict.size());
        for(int i = 0; i < vdict.size(); i++){
            string w = vdict[i];
            for(int j = 0; j < vdict[i].size(); j++){
                for(char c = 'a'; c <= 'z'; c++)
                    if(c != vdict[i][j]){
                        w[j] = c;
                        if(ids.count(w)){
                            adj[i].push_back(ids[w]);
                        }
                        w[j] = vdict[i][j];
                    }
            }
        }
    }

    void gen(int v1, int v2, vector<vector<int> >& prev, vector<int>& path, vector<vector<string> >&ans){
        path.push_back(v2);
        if(v2 == v1 and path.size() > 1){
            ans.push_back(vector<string>());
            for(auto rit = path.rbegin(); rit != path.rend(); rit++){
                ans.back().push_back(vdict[*rit]);
            }
        }else{
            int i;
            for(i = 0; i < prev[v2].size(); i++){
                gen(v1, prev[v2][i], prev, path, ans);
            }
        }
        path.pop_back();
    }
public:
    vector<vector<string> > findLadders(string start, string end, unordered_set<string> &dict) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        dict.insert(start);
        dict.insert(end);
        build(dict);
        queue<int> que;
        vector<vector<int> > prev(vdict.size());
        vector<int> distance(vdict.size());

        int v, v1, v2;
        for(v1 = 0; vdict[v1] != start; v1++);
        for(v2 = 0; vdict[v2] != end; v2++);
        for(int i = 0; i < adj[v1].size(); i++){
            v = adj[v1][i];
            que.push(v);
            prev[v].push_back(v1);
            distance[v] = 1;
        }
        while(not que.empty()){
            int v1 = que.front(); que.pop();
            if(v1 == v2) break;
            int d = distance[v1] + 1;
            for(int i = 0; i < adj[v1].size(); i++){
                v = adj[v1][i];
                if(prev[v].size() == 0){
                    prev[v].clear();
                    prev[v].push_back(v1);
                    distance[v] = d;
                    que.push(v);
                }else if(distance[v] == d){
                    prev[v].push_back(v1);
                }
            }
        }

        vector<vector<string> > ans;

        vector<int> path;
        gen(v1, v2, prev, path, ans);

        return ans;
    }
};
*/
 






















/*					Only for find the shortest sequences
public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<String> s = new ArrayList<String> ();
    ArrayList<String> r = new ArrayList<String> ();
    r.add(start);      
    if(start.equals(end))
        return r;
    HashMap<String,String> map = new HashMap<String,String> ();
    String index = helper(r,end,dict,s,result,map);
    ArrayList<String> result = new ArrayList<String> ();
    result.add(start);
    result.add(index);
    for(;map.contains(index);) {
        String val = map.get(index);
        result.add(val);
        index = val;
    }
    result.add(end);
    return result;
}
public String helper(ArrayList<String> r, String end, HashSet<String> dict, ArrayList<String> s, HashMap<String,String> map) {
    for(String str : r) {
        if(trans(str,end))
            return str;
    }
    if(s.containsAll(dict))
       return 0;
    ArrayList<String> temp = new ArrayList<String>();
    for(String a : r) {
        for(String t : dict) {
            if(trans(a,t)) {
                if(!s.contains(t)) {
                    map.put(t,a);
                    s.add(t);
                    temp.add(t);
                }
            }
        }
    }
    if(s.size()==0)
        return ;
    return helper(temp,end,dict,s,map);
}
public boolean trans(String a, String b) {
    int count=0;
    for(int i=0;i<a.length();i++) {
        if(a.charAt(i)!=b.charAt(i))
            count++;
    }
    if(count==1)
        return true;
    else
        return false;
}
*/