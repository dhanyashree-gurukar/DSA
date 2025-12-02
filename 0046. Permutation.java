/*Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.*/

/*Sample test cases:
    Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    Example 2:
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]

    Example 3:
    Input: nums = [1]
    Output: [[1]]
*/

// TC - O(n.n!), SC - O(n)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(nums, 0, res);
        return res;
    }
    
    private void permuteHelper(int[] nums, int i, List<List<Integer>> res) {
        if(i == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for(int num : nums){
                permutation.add(num);
            }
            res.add(permutation);
            return;
        }

        for(int j=i; j<nums.length; j++) {
            swap(nums, i, j);
            permuteHelper(nums, i+1, res);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}