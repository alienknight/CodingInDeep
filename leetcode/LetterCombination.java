    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> result = new ArrayList<String>();
        if(digits==null)
            return result;
        if(digits.equals("")) {
            result.add("");
            return result;
        }
        return helper(digits,digits.length()-1,map);
    }
    public ArrayList<String> helper(String digits, int count, String[] map) {
        ArrayList<String> result = new ArrayList<String>();
        if(count==0) {
            int cur = Character.getNumericValue(digits.charAt(0));
            for(int i=0;i<map[cur].length();i++) {
                result.add(String.valueOf(map[cur].charAt(i)));
            }
            return result;
        }            
        if(digits.charAt(count)-'0'>=2 && digits.charAt(count)-'0'<=9) {
            int cur = Character.getNumericValue(digits.charAt(count));
            for(int j=0;j<map[cur].length();j++) {
                for(String temp : helper(digits,count-1,map)) {
                    temp += map[cur].charAt(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }