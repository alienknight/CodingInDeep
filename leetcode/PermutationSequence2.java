    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = n;
        ArrayList<String> result = new ArrayList<String>(helper(n,1));
        Collections.sort(result, new Comparator<String>(){
            public int compare(String a, String b) {
                long a1 = Long.parseLong(a);
                long b1 = Long.parseLong(b);
                if(a1<b1) return -1;
                else if(a1>b1) return 1;
                else return 0;
            }
        });
        return result.get(k-1);
    }
    public ArrayList<String> helper(int n, int count) {
        ArrayList<String> result = new ArrayList<String>();
        if(count==n) {
            result.add(String.valueOf(count));
            return result;
        }
        for(String s : helper(n,count+1)) {
            for(int i=0;i<=s.length();i++) {
                String temp = s.substring(0,i)+String.valueOf(count)+s.substring(i,s.length());
                result.add(temp);
            }
        }
        return result;
    }