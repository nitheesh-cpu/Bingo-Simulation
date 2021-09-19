public class BingoCardObj {
    private int[][] board;
    private boolean won;
    private int roundWon, id;

    public BingoCardObj(int x, int[][] b) {
        id = x;
        board = b;
    }

    public void setWon(boolean b, int x) {
        won = b;
        roundWon = x;
    }
    public boolean didWin() {
        return won;
    }


    public int[][] getBoard() {
        return board;
    }

    public int getRoundWon(){
        return roundWon;
    }
    public void setBoard(int[][] x) {
        board = x;
    }
}
