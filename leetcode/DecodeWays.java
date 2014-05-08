
public class DecodeWays {
//    public int numDecodings(String s) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(s.length()==0 || s.equals("0"))
//            return 0;
//        return helper(s,0);
//    }
//    public int helper(String s, int count) {
//        if(count>=s.length())
//            return 1;
//        if(s.charAt(count)-'0'>9 || s.charAt(count)-'0'<=0)
//            return 0;
//        if(count==s.length()-1)
//            return 1;
//        //int temp = 0;
//        if(s.charAt(count)=='1' || (s.charAt(count)=='2' && s.charAt(count+1)-'0'<7 && s.charAt(count+1)-'0'>=0))
//            return helper(s,count+1)+helper(s,count+2);
//        else
//            return helper(s,count+1);
//    }
    public int numDecodings(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		if (s == null || s.length() == 0)
			return 0;
		int[] res = new int[s.length() + 1];
		res[s.length()] = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '0')
				res[i] = 0;
			else if (i == s.length() - 1)
				res[i] = res[i + 1];
			else {
				if (s.charAt(i) - '0' == 1
						|| (s.charAt(i) - '0' == 2 && s.charAt(i) - '0' > 0
								&& s.charAt(i + 1) - '0' < 7 && s.charAt(i + 1) - '0' >= 0))
					res[i] = res[i + 1] + res[i + 2];
				else
					res[i] = res[i + 1];

			}
		}
		return res[0];
	}
}



////////////////////////////////////////////////Cache
/*    public int numDecodings(String s) {
// Start typing your Java solution below
// DO NOT write main() function
if(s.length()==0 || s.equals("0"))
    return 0;
int[] store = new int[s.length()];
store[s.length()-1] = 1;
return helper(s,0,store);
}
public int helper(String s, int count, int[] store) {
if(count>=s.length())
    return 1;
if(s.charAt(count)-'0'>9 || s.charAt(count)-'0'<=0)
    return 0;
//if(count==s.length()-1)
  //  return 1;
//int temp = 0;
if(store[count]!=0)
        return store[count];
if(s.charAt(count)=='1' || (s.charAt(count)=='2' && s.charAt(count+1)-'0'<7 && s.charAt(count+1)-'0'>=0)) {
    store[count] = helper(s,count+1,store)+helper(s,count+2,store);
    return store[count];
}            
else{   
    store[count] = helper(s,count+1,store);
    return store[count];
}
}*/


//////////////////////////////////////////////Itarative
/*public int numDecodings(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if(s.length()==0 || s.equals("0"))
        return 0;
    int[] store = new int[s.length()+1];
    store[0] = 1;
    for(int i=1;i<=s.length();i++) {
        int c1 = 0;
        if(s.charAt(i-1)!='0') 
            c1 = store[i-1];
        int c2 = 0;
        if(i>=2 && (s.charAt(i-2)=='1' || s.charAt(i-2)=='2' && s.charAt(i-1)-'0'<7))
            c2 = store[i-2];
        store[i] = c1+c2;
    }
    return store[s.length()];
}*/