    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
        if(digits==null) return null;
        ArrayList<String> res = new ArrayList<String>();
        if(digits.length()==0) {
            res.add("");
            return res;
        }
        String t = null;
        if(digits.charAt(0)-'2'>=0 && digits.charAt(0)-'9'<=0)
            t = letters[Character.getNumericValue(digits.charAt(0))];
        else return letterCombinations(digits.substring(1));
        for(String temp : letterCombinations(digits.substring(1)))
            for(int i=0;i<t.length();i++)
                res.add(String.valueOf(t.charAt(i)) + temp);
        return res;
    }
