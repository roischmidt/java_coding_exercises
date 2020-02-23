import java.util.HashSet;
import java.util.Set;

/**
 * Given a boolean matrix, update it so that if any cell is true, all the cells in that
 * row and column are true.
 * <p>
 * [true, false, false] [true, true, true ]
 * [false, false, false] -> [true, false, false]
 * [false, false, false] [true, false, false]
 */
public class ZeroMatrix {

    /**
     * iterate on all rows and columns from beginning and also from end so-
     * when a 'true' found it will fill all lower and higher elements
     * @param matrix
     * @return updated matrix
     */
    private static boolean[][] updateMatrix(boolean[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0, ie = matrix.length - 1; i < matrix.length; i++, ie--) {
            for (int j = 0, je = matrix[0].length - 1; j < matrix[0].length; j++, je--) {
                boolean isUpdated = false;
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = true;
                    isUpdated = true;
                }
                if (rowSet.contains(ie) || colSet.contains(je)) {
                    matrix[ie][je] = true;
                    isUpdated = true;
                }
                if (!isUpdated) {
                    if (matrix[i][j]) {
                        rowSet.add(i);
                        colSet.add(j);
                    }
                    if (matrix[ie][je]) {
                        rowSet.add(ie);
                        colSet.add(je);
                    }
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
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
            /**
             * false true false
             * true true true
             * false true false
             */
        }
    }
}
