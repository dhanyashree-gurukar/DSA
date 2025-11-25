/*Problem statement:
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
*/

/*Sample test cases:
    Example 1:
    Input: nums = [2,2,1]
    Output: 1

    Example 2:
    Input: nums = [4,1,2,1,2]
    Output: 4

    Example 3:
    Input: nums = [1]
    Output: 1
*/

//In XOR x^x = 0 and x^0 = x hence the numbers which appears more than once will cancel out each other
class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int index = 0;
        for(int num : nums){
            index = index ^ num;
        }

        return index;
    }
}