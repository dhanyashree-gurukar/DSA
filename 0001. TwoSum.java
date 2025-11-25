/*Problem Statement - Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.*/

/*Sample test cases:
    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]
 */

 //Brute force approach : TC-O(n^2), SC-O(1)
 class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    
                }
            }
        }
        return result;
    }
} 

//HashMap approach : TC-O(n), SC-O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numIndex = new HashMap<>();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++)
        {
            int diff = target - nums[i];
            if(numIndex.containsKey(diff)){               
                result[0] = numIndex.get(diff);
                result[1] = i;
                return result;
            }
            numIndex.put(nums[i], i);
        }
        return new int[0];
    }
}