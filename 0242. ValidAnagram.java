/*Problem statement:
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
*/

/*Sample test cases: 
    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false
*/

//Method-1 : Sorting (TC-O(nlogn), SC-O(n))
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
} 

//Method-2 : Hashmap (TC-O(n), SC-O(k) where k is distinct elements)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)-1);
            if(map.get(ch) < 0){
                return false;
            }
        }
        return true;
    }
}