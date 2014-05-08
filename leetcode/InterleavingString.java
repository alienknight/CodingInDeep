
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length()==0 && s2.length()==0 && s3.length()==0)
            return true;
        if(s3.length()!=s1.length()+s2.length()) 
            return false;
        if(s1.length()!=0 && s2.length()!=0 && s3.charAt(s3.length()-1)==s1.charAt(s1.length()-1) && s3.charAt(s3.length()-1)==s2.charAt(s2.length()-1)) {
            return isInterleave(s1.substring(0,s1.length()-1),s2,s3.substring(0,s3.length()-1)) || 
                isInterleave(s1,s2.substring(0,s2.length()-1),s3.substring(0,s3.length()-1));
        }
        else if(s1.length()!=0 && s3.charAt(s3.length()-1)==s1.charAt(s1.length()-1)) {
            return isInterleave(s1.substring(0,s1.length()-1),s2,s3.substring(0,s3.length()-1));
        }
        else if(s2.length()!=0 && s3.charAt(s3.length()-1)==s2.charAt(s2.length()-1)) {
            return isInterleave(s1,s2.substring(0,s2.length()-1),s3.substring(0,s3.length()-1));
        }
        else 
            return false;
    }
}

/*
public boolean isInterleave(String s1, String s2, String s3) {
// Note: The Solution object is instantiated only once and is reused by each test case.
if(s1.length()+s2.length()!=s3.length())
    return false;
int n1 = s1.length(), n2 = s2.length();
boolean[][] check = new boolean[s1.length()+1][s2.length()+1];
check[0][0] = true;
for(int i=0;i<n2;i++) {
    if(s2.charAt(i)==s3.charAt(i)) check[0][i+1] = true;
    else break;
}
for(int i=0;i<n1;i++) {
    if(s1.charAt(i)==s3.charAt(i)) check[i+1][0] = true;
    else break;
}
for(int i=1;i<=n1;i++)
    for(int j=1;j<=n2;j++) {
        if(check[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1) || check[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1))
            check[i][j] = true;
    }
return check[n1][n2];
}*/