
public class ZigZag {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(nRows==1) return s;
        char[] ss = s.toCharArray();
        StringBuffer result = new StringBuffer();
        int temp = 2*nRows -2;
        for(int i=0;i<nRows;i++)
        {
            for(int j=0;j<ss.length;j++)
            {
                if(j%temp==i || j%temp==temp-i)
                {
                    result.append(ss[j]);
                }
            }
        }
        return result.toString();
    }
}


/*
public String convert(String s, int nRows) {
// Start typing your Java solution below
// DO NOT write main() function
if(nRows<=1)
    return s;
int len = nRows*2-2;
int m = 0;
StringBuffer sb = new StringBuffer();
while(m<=len/2) {
    for(int i=m;i<s.length();i++) {
        if(i%len==m || i%len==len-m)
            sb.append(s.charAt(i));
    }
    m++;
}
return sb.toString();
}*/