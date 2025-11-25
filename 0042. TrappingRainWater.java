/*Problem statement:
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/

/*Sample test cases:
    Example 1:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    
    Example 2:
    Input: height = [4,2,0,3,2,5]
    Output: 9
*/

//DP Approach - TC-O(n), SC-O(n)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        leftMax[0] = height[0];

        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        rightMax[n-1] = height[n-1];

        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int water = 0;
        for(int i=0; i<n; i++){
            int waterlevel = Math.min(leftMax[i], rightMax[i]);
            water += waterlevel - height[i];
        }
        return water;
    }
}

//TC-O(n), SC-O(1)
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int water = 0;
        int left = 0, right = height.length-1;
        int leftMax=0, rightMax=0;

        while (left <= right){
            leftMax = (leftMax > height[left]) ? leftMax : height[left];
            rightMax = (rightMax > height[right]) ? rightMax : height[right];

            if(leftMax < rightMax){
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}