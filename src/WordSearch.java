public class WordSearch {

    public static boolean exist(char[][] board, String word) {
       // return exist(board,word,0,0,new StringBuffer());
        return exist2(board,word,0,0,0,false);
    }

    // solution one: with stringBuffer (+ O(n) memory)
    private static boolean exist(char[][] board, String word, int rowIdx, int colIdx,StringBuffer sb) {
        if(rowIdx == board.length || colIdx == board[0].length)
            return false;
        if(sb.toString().contains(word))
            return true;
        char cur = board[rowIdx][colIdx];
        sb.append(cur);
        return exist(board,word,rowIdx,colIdx + 1,sb) || exist(board,word,rowIdx + 1,colIdx,sb);
    }

    // solution 2 no aditional space
    private static boolean exist2(char[][] board,String word,int rowIdx,int colIx, int wordIdx,boolean isRight) {
        if(wordIdx == word.length())
            return true;

        if(board[0].length == colIx) {
            colIx = 0;
            rowIdx++;
        }
        if(board.length == rowIdx)
            return false;
        if(board[rowIdx][colIx] == word.charAt(wordIdx)) {
            wordIdx++;
        } else {
            wordIdx = 0;
        }
        boolean isFoundLeft = false;
        if(colIx > 0 && wordIdx > 0 && !isRight) {
            isFoundLeft  = exist2(board, word, rowIdx, colIx - 1, wordIdx, false); // move left
        }
        return isFoundLeft || exist2(board,word,rowIdx,colIx+1,wordIdx,true) || // move right
                exist2(board,word,rowIdx+1,colIx,wordIdx,false);
    }
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        System.out.println(exist(board, "ABCCED")); // true
        System.out.println(exist(board, "SEE")); // true
        System.out.println(exist(board, "ABCB")); // false
        System.out.println(exist(board, "CE")); // true
    }

}
