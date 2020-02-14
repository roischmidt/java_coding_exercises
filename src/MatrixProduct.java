import java.util.Arrays;

/**
 * Matrix product
 * Given a matrix, find the path from top left to bottom right with the greatest
 * product by moving only down and right.
 * <p>
 * [1, 2, 3]
 * [4, 5, 6]
 * [7, 8, 9]
 * 1 -> 4 -> 7 -> 8 -> 9
 * 2016
 * [-1, 2, 3]
 * [4, 5, -6]
 * [7, 8, 9]
 * -1 -> 4 -> 5 -> -6 -> 9
 * 1080
 */
public class MatrixProduct {

    public static void main(String[] args) {
        int[][] matrix =
                {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(product(matrix,3,3));
        System.out.println(Arrays.deepToString(matrix) + " product is 2016: " + (product(matrix,3,3) == 2016));
        int[][] matrix2 =
                {{-1, 2, 3},
                {4, 5, -6},
                {7, 8, 9}};
        System.out.println(product(matrix2,3,3));
        System.out.println(Arrays.deepToString(matrix2) + " product is 1080: " + (product(matrix2,3,3) == 1080));
    }

    public static int product(int[][] matrix,int row, int col) {
        return productRec(matrix,row,col,0,0,1);
    }

    public static int productRec(int[][] matrix,int row, int col,int i, int j,int mul) {
        if(i == row || j == col)
            return mul;
        int cur = matrix[i][j] * mul;
        return Math.max(productRec(matrix,row,col,i,j+1,cur),productRec(matrix,row,col,i+1,j,cur));
    }
}
