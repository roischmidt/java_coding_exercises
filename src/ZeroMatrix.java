import java.util.HashSet;
import java.util.Set;

/**
 * Given a boolean matrix, update it so that if any cell is true, all the cells in that
 * row and column are true.
 *
 * [true, false, false] [true, true, true ]
 * [false, false, false] -> [true, false, false]
 * [false, false, false] [true, false, false]
 */
public class ZeroMatrix {

    private static boolean[][] updateMatrix(boolean[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for(int i = 0; i < matrix.length;i ++ ) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = true;
                    continue;
                }
                if(matrix[i][j]){
                    rowSet.add(i);
                    colSet.add(j);
                    // fill all elements that already passed
                    for(int row = 0; row < i; row++)
                        matrix[row][j] = true;
                    for(int col = 0; col <  j; col ++)
                        matrix[i][col] = true;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        boolean[][] matrix = {{false, false, false}, {false, true, false}, {false, false, false}};
        matrix = ZeroMatrix.updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
