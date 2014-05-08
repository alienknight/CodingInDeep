import java.util.*;
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3)
            return result;
        for(int i=num.length-1;i>0;i--)
            for(int j=0;j<i;j++)
            {
                if(num[j] > num[j+1])
                {
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        for(int i=0;i<num.length;i++)
        {
            int temp = -num[i];
            int t1 = i+1;
            int t2 = num.length-1;
            while(t2 > t1)
                {
                    if((num[t1]+num[t2])==temp)
                    {
                        ArrayList<Integer> ele = new ArrayList<Integer>();
                        ele.add(num[i]);
                        ele.add(num[t1]);
                        ele.add(num[t2]);
                        if(exclude(result,ele))
                            result.add(ele);
                        t2--;
                    }
                    else if((num[t1]+num[t2])>temp)
                        t2--;
                    else
                        t1++;             
                }
        }
        return result;
    }
    public boolean exclude(ArrayList<ArrayList<Integer>> m, ArrayList<Integer> n)
    {
        for(int i=0;i<m.size();i++)
        {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int index = 0;index<3;index++)
            {
                if(!map.containsKey(m.get(i).get(index)))
                    map.put(m.get(i).get(index),1);              
                else
                    map.put(m.get(i).get(index),map.get(m.get(i).get(index))+1);
            }
            if(map.containsKey(n.get(0)) && map.containsKey(n.get(1)) && map.containsKey(n.get(2)))
            {
                map.put(n.get(0),map.get(n.get(0))-1);
                map.put(n.get(1),map.get(n.get(1))-1);
                map.put(n.get(2),map.get(n.get(2))-1);
                if(map.get(n.get(0))==0 && map.get(n.get(1))==0 && map.get(n.get(2))==0)
                    return false;
            }
        }
        return true;
    }
}
/*
 *public class Solution {
     public ArrayList<ArrayList<Integer>> threeSum(int[] num) {  
  ArrayList<ArrayList<Integer>> resSet = new ArrayList<ArrayList<Integer>>();  
  if (num.length < 3) return resSet;  
  Arrays.sort(num);  
  for (int i=0; i<num.length-2 && num[i]<=0; ++i) {  
    // remove duplicates  
    if (i>0 && num[i]==num[i-1]) continue;  
    // use two pointer to find b+c = -a  
    int start=i+1, end=num.length-1;  
        while (start<end) {  
          int sum = num[i] + num[start] + num[end];  
          if (sum < 0) {  
            start++;  
          } else if (sum > 0) {  
            end--;  
          } else { // find one  
            ArrayList<Integer> res = new ArrayList<Integer>(3);  
            res.add(num[i]);  
            res.add(num[start]);  
            res.add(num[end]);  
            resSet.add(res);  
            // move the left pointer to right and skip duplicates;  
            do { start++; } while (start<end && num[start]==num[start-1]);  
            // move the right pointer to left and skip duplicates  
            do { end--; } while (start<end && num[end]==num[end+1]);  
          }  
        }  
      }  
      return resSet;  
    }
}
 **/
 