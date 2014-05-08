
public class EditDistance {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return lcs(word1,word2,word1.length()-1,word2.length()-1,0);
    }
    public int lcs(String a, String b, int m, int n, int len) {
        if(m<0 || n<0)
            return len+Math.max(m,n)+1;
        if(a.charAt(m)==b.charAt(n))
            len = lcs(a,b,m-1,n-1,len);
        else 
        {
            int temp = Math.min(lcs(a,b,m-1,n,len), lcs(a,b,m,n-1,len));
            len = 1+Math.min(lcs(a,b,m-1,n-1,len), temp);
        }
        return len;
    }
}
/*
 

class Solution { public:
    int minDistance(string word1, string word2) {
        int ar[word1.size()+1][word2.size()+1];
        for(int i=0;i<=word1.size();i++)
            ar[i][0]=i;
        for(int j=0;j<=word2.size();j++)
            ar[0][j]=j;
        for(int i=1;i<=word1.size();i++)
        {
            for(int j=1;j<=word2.size();j++)
            {
                if(word1[i-1]==word2[j-1])
                    ar[i][j]=ar[i-1][j-1];
                else
                {
                    int mn=min(ar[i-1][j],ar[i][j-1]);
                    ar[i][j]=1+min(ar[i-1][j-1],mn);
                }
            }
        }
        return ar[word1.size()][word2.size()];   
    } };

*/ 
