/*Problem statement:
Given a string s, return the longest palindromic substring in s.
*/

/*Sample test cases:
    Example 1:
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
    
    Example 2:
    Input: s = "cbbd"
    Output: "bb"
*/

//Manacher's algorithm - TC-O(n), SC-O(n)
class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length() == 0){
            return "";
        }

        StringBuilder str = new StringBuilder("^");

        for(char ch : s.toCharArray()){
            str.append("#").append(ch);
        }

        str.append("#$");

        int center = 0, right = 0;
        int n = str.length();
        int[] p = new int[n];

        for(int i=1; i<n-1; i++){
            int mirror = 2 * center - i;

            if(i < right){
                p[i] = Math.min(right-i, p[mirror]);
            }

            while(str.charAt(i + (p[i] + 1)) == str.charAt(i - (p[i] + 1))){
                p[i]++;
            }

            if(i + p[i] > right){
                center = i;
                right = i+ p[i];
            }

        }

        int maxlen = 0;
        int centerIndex = 0;

        for(int i=1; i<n-1; i++){
            if(p[i] > maxlen){
                maxlen = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxlen) / 2;
        return s.substring(start, start + maxlen);
    }
}