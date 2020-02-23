/**
 * Given a 2D array of 1s and 0s, find the largest square subarray of all 1s.
 *
 * subarray([1, 1, 1, 0]
 *          [1, 1, 1, 1]
 *          [1, 1, 0, 0]) = 2
 */
public class SquareSubMatrix {

    /**
     * create an array which has sum of all columns and then count consecutive sums
     *  e.g         ([1, 1, 1, 0]
     *              [1, 1, 1, 1]
     *              [1, 1, 0, 0]) == [3,3,2,1] = 2
     */
    static int subArray(int[][] matrix) {
        int[] sumArr = new int[matrix[0].length];
        for(int colIdx = 0; colIdx < matrix[0].length; colIdx++){
            for( int rowIdx = 0; rowIdx < matrix.length; rowIdx++){
                sumArr[colIdx] += matrix[rowIdx][colIdx];
            }
        }
        int maxSquareSize = 0;
        int equalColumnCount = 1;
        for(int i = 0; i < sumArr.length; i++){
            if(i > 0 && sumArr[i] == sumArr[i-1]) {
                equalColumnCount++;
                maxSquareSize = Math.max(equalColumnCount,maxSquareSize);
            }
            else
                equalColumnCount = 1;

        }
        return maxSquareSize;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 0},{1, 1, 1, 1},{1, 1, 0, 0}};
        System.out.println("subArray size should be 2 : " + (subArray(matrix) == 2));
    }
}
