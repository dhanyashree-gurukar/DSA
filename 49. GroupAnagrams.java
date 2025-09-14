/*Problem statement:
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
*/

/*Sample test cases:
    Example 1:
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    
    Example 2:
    Input: strs = [""]
    Output: [[""]]

    Example 3:
    Input: strs = ["a"]
    Output: [["a"]]
*/

//TC-O(n * k logk), SC-O(n*k) where k is maximum length of a string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramGroups = new HashMap<>();

        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if(!anagramGroups.containsKey(sortedString)){
                anagramGroups.put(sortedString, new ArrayList<>());
            }
            anagramGroups.get(sortedString).add(str);
        }
        return new ArrayList<>(anagramGroups.values());
    }
}