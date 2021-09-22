import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BingoCard {

    private final Random rn;
    public static final int LENGTH = 6;
    private int[][] card;
    private int count;
    private int winners;
    private final BingoCardObj[] bingoCards;

    public BingoCard(int s, int a) throws IOException {
        bingoCards = new BingoCardObj[a];
        int seed = 1;
        count = 0;
        rn = new Random(s);
        for (int i = 0; i < a; i++) {
            refill();
        }
    }

    public BingoCard(int s, int a, int w) throws IOException {
        bingoCards = new BingoCardObj[a];
        int seed = 1;
        count = 0;
        rn = new Random(s);
        winners = w;
        for (int i = 0; i < a; i++) {
            refill();
        }
    }

    public BingoCardObj[] getBingoCards() {
        return bingoCards;
    }

    public int getAmtWinners() {
        return winners;
    }

    public int getAmtCards(){
        return bingoCards.length;
    }

    public int getPos(int x, int y) {
        if (x >= card.length || y >= card.length) return -1;
        return card[x][y];
    }

    public void refill() {
        card = new int[5][5];
        ArrayList<Integer> alreadyUsed = new ArrayList<Integer>();
        boolean valid = false;
        int tmp = 0;
        for (int i = 0; i <= 4; i++)
            for (int row = 0; row < card.length; row++)
                card[row][i] = 0;
        for (int i = 0; i <= 4; i++) {
            for (int row = 0; row < card.length; row++) {
                while (!valid) {
                    tmp = rn.nextInt(15) + 1 + 15 * i;
                    if (!alreadyUsed.contains(tmp)) {
                        valid = true;
                        alreadyUsed.add(tmp);
                    }
                }
                card[row][i] = tmp;
                valid = false;
            }
        }
        card[2][2] = 0;
        bingoCards[count] = (new BingoCardObj(count, card));
        count++;
    }


}
