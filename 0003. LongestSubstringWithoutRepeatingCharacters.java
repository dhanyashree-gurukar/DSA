/*Problem Statement:
Given a string s, find the length of the longest substring without duplicate characters.
*/

/*Sample test cases: 
    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3. It can also be bca/cab.
    
    Example 2:
    Input: s = "bbbbb"
    Output: 1
    
    Example 3:
    Input: s = "pwwkew"
    Output: 3
*/

//Method 1 - Sliding window using hashset
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int left=0, len=0;

        for(int right=0; right<s.length(); right++){
            char ch = s.charAt(right);

            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            len = Math.max(len, (right-left)+1);
        }
        return len;
    }
}

//Method 2 - Sliding window using boolean array
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        boolean[] arr = new boolean[128];

        int len=0, right=0, left=0;

        while(right<s.length()){
            if(!arr[s.charAt(right)]){
                arr[s.charAt(right)] = true;
                len = Math.max(len, (right-left) + 1);
                right++;
            }else{
                arr[s.charAt(left)] = false;
                left++;
            }
        }

        return len;
    }
}