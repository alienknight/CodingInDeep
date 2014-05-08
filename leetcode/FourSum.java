import java.util.*;
public class FourSum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if(num.length<4) return result;
    Arrays.sort(num);
    for(int i=0;i<num.length-3;i++)
    {
        if(i>0&&num[i]==num[i-1]) continue;
        int j=i+1;
        while(j<num.length)
        {
            int m = j+1;
            int n = num.length-1;
            while(m<n)
            {
                if(num[i]+num[j]+num[m]+num[n]==target)
                {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[j]);
                    temp.add(num[m]);
                    temp.add(num[n]);
                    result.add(temp);
                    while(m<n&&num[m]==num[m+1]) m=m+2;
                    while(m<n&&num[n]==num[n-1]) n=n-2;
                }
                else if(num[i]+num[j]+num[m]+num[n]<target)
                    m++;
                else
                    n--;
            }
            j++;
        }
    }
    return result;
}
    public static void main(String[] args){
    	int[] a = {0,0,0,0};
    	fourSum(a,0);
    }
}

/*
public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    // Start typing your Java solution below
    // DO NOT write main() function
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if(num.length<4)
        return result;
    Arrays.sort(num);
    for(int i=0;i<num.length-3;i++) {
        if(i>0 && num[i]==num[i-1])
            continue;
        for(int j=i+1;j<num.length-2;j++) {
            if(j>i+1 && num[j]==num[j-1])
                continue;
            int sum = target-num[i]-num[j];
            int start = j+1;
            int end = num.length-1;
            while(start < end) {
                if(num[start]+num[end]==sum) {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[j]);
                    temp.add(num[start]);
                    temp.add(num[end]);
                    result.add(temp);
                    do{start++;} while(start<end && num[start]==num[start-1]);
                    do{end--;} while(start<end && num[end]==num[end+1]);
                }
                else if(num[start]+num[end]<sum)
                    start++;
                else 
                    end--;
            }
        }
    }
    return result;
}
}*/