import java.awt.image.BufferedImage;

public class BingoCardObj2 {
    private BufferedImage board;
    private boolean won;
    private int roundWon, id;

    public BingoCardObj2(int x, BufferedImage b) {
        id = x;
        board = b;
        roundWon = 0;
        won = false;
    }

    public void setWon(boolean b, int x) {
        won = b;
        roundWon = x;
    }
    public boolean didWin() {
        return won;
    }


    public BufferedImage getImage() {
        return board;
    }

    public int getRoundWon(){
        return roundWon;
    }
    public void setBoard(BufferedImage x) {
        board = x;
    }
}
