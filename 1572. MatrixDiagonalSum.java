/*Problem statement:
Given a square matrix mat, return the sum of the matrix diagonals.
Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
*/

/*Sample test cases:
    Example 1:
    Input: mat = [[1,2,3],
                [4,5,6],
                [7,8,9]]
    Output: 25
    Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25

    Example 2:
    Input: mat = [[1,1,1,1], [1,1,1,1], [1,1,1,1], [1,1,1,1]]
    Output: 8

    Example 3:
    Input: mat = [[5]]
    Output: 5
*/

//TC-O(n), SC-O(1)
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;

        for(int i=0; i<mat.length; i++){
            sum += mat[i][i];

            if(i != mat.length-i-1){
                sum += mat[i][mat.length-i-1];
            }
        }

        return sum;
    }
}