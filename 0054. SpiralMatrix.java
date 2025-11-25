/*Problem statement: 
Given an m x n matrix, return all elements of the matrix in spiral order.
*/

/*Smaple test cases:
    Example 1:
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,3,6,9,8,7,4,5]
    
    Example 2:
    Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7] 
*/

//TC-O(M*N), SC-O(1)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0, endRow = matrix.length-1;
        int startCol = 0, endCol = matrix[0].length-1;

        List<Integer> list = new ArrayList<>();

        while (startRow <= endRow && startCol <= endCol){
            for(int j=startCol ; j<=endCol; j++){
                list.add(matrix[startRow][j]);
            }

            for(int i=startRow + 1; i<=endRow; i++){
                list.add(matrix[i][endCol]);
            }

            if(startRow < endRow){
                for(int j=endCol - 1 ; j>=startCol; j--){
                    list.add(matrix[endRow][j]);
                }
            }
            
            if(startCol < endCol){
                for(int i = endRow-1; i>startRow; i--){
                    list.add(matrix[i][startCol]);
                }
            }
            
            startRow++; 
            startCol++; 
            endRow--;
            endCol--;
        }
        return list;
    }
}