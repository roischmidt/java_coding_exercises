import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * [Google On-site 2018 Winter]
 * Set Matrix Zeroes II
 * There are orbs on an NxM board ('O' denotes orb. 'X' denotes empty slot).
 *
 * Whenever two orbs are in the same column or the same row, you get to erase one of them.
 *
 * Try to erase as many orbs as possible.
 *
 * Find the minimum number of orbs remained on board eventually.
 *
 * e.g.
 *
 * OXOXXO
 *
 * XXXXXO
 *
 * XXXXOX
 *
 * erase (0,0) and get
 *
 * XXOXXO
 *
 * XXXXXO
 *
 * XXXXOX
 *
 * erase (2,0) and get
 * XXXXXO
 *
 * XXXXXO
 *
 * XXXXOX
 *
 * erase (5,0) and get
 *
 * XXXXXX
 *
 * XXXXXO
 *
 * XXXXOX
 *
 * no more moves available. Return 2 e.g.
 *
 * OXOXXO
 *
 * XXXXXO
 *
 * XXOXOX
 * erase(4,2), (2,2), (0,0), (2,0), (5,0)
 *
 * Return 1
 * e.g.
 * OXOXXX
 *
 * XOXXXO
 *
 * XXXOOX
 *
 * erase(0,0), (1,1), (3,2)
 *
 * Return 3
 *
 * Follow-up Build a solver for this board game that erases the as many orbs as possible.
 */
public class OrbsQuestion {

    final int N = 3;
    final int M = 5;
    final char ORB = 'O';
    final char EMPTY = 'X';
    char[][] board = new char[N][M];

    public void initBoard() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int r = new Random().nextInt(2);
                board[i][j] = r == 0 ? ORB : EMPTY;
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    public int getNumOfLeftOrbs() {
        Map<Integer,Integer> orbsInColumn = new HashMap<>();
        for(int i = 0; i < N; i++){
            int lastColumnFound = -1;
            for(int j = 0; j < M; j++){
                if(board[i][j] == ORB){
                    Integer rowFound = orbsInColumn.get(j);
                    if(rowFound != null){
                        board[rowFound][j] = EMPTY;
                        orbsInColumn.remove(j);
                        System.out.println("(" + rowFound + "," + j + ")");
                    }
                    if(lastColumnFound != -1){
                        board[i][lastColumnFound] = EMPTY;
                        System.out.println("(" + i + "," + lastColumnFound + ")");
                    }
                    lastColumnFound = j;
                }
            }
            if(lastColumnFound != -1){
                orbsInColumn.put(lastColumnFound,i);
            }
        }
        return orbsInColumn.size();
    }

    public static void main(String[] args) {
        OrbsQuestion q = new OrbsQuestion();
        q.initBoard();
        System.out.println("final:");
        System.out.println(q.getNumOfLeftOrbs());
    }
}
