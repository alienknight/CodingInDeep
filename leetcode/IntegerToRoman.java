public class Solution {
    public String intToRoman(int num) {
       if (num == 0)   return "";
       int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
       String[] romans = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
       StringBuilder res = new StringBuilder();
       int index = 0;
       while (num > 0){
          if (num < nums[index]) index++;
          else{
              num -= nums[index];
              res.append(romans[index]);
          }
       }
       return res.toString();
   }
    
}
