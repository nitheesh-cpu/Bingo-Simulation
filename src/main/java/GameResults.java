import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameResults {
    private final int amount;
    private final int days;
    private final int maxWinners;
    private final int once;
    private final Object[][] winnersTable;
    private Object[][] ballsTable;
    private final BingoCardObj[] bingoCards;
    private final ArrayList<Integer> drawnNumbers;
    private final ArrayList<Integer> cardsWon;
    private final Random rn;
    private int[][] daysTable;
    private int amtBalls;
    private boolean done;
    private static final String winnersBanner = "██╗    ██╗██╗███╗   ██╗███╗   ██╗███████╗██████╗ ███████╗   \n" +
                                                "██║    ██║██║████╗  ██║████╗  ██║██╔════╝██╔══██╗██╔════╝██╗\n" +
                                                "██║ █╗ ██║██║██╔██╗ ██║██╔██╗ ██║█████╗  ██████╔╝███████╗╚═╝\n" +
                                                "██║███╗██║██║██║╚██╗██║██║╚██╗██║██╔══╝  ██╔══██╗╚════██║██╗\n" +
                                                "╚███╔███╔╝██║██║ ╚████║██║ ╚████║███████╗██║  ██║███████║╚═╝\n" +
                                                " ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝╚══════╝   \n" +
                                                "                                                            ";
    private static final String ballsBanner =   "██████╗  █████╗ ██╗     ██╗     ███████╗    ██████╗ ██████╗  █████╗ ██╗    ██╗███╗   ██╗   \n" +
                                                "██╔══██╗██╔══██╗██║     ██║     ██╔════╝    ██╔══██╗██╔══██╗██╔══██╗██║    ██║████╗  ██║██╗\n" +
                                                "██████╔╝███████║██║     ██║     ███████╗    ██║  ██║██████╔╝███████║██║ █╗ ██║██╔██╗ ██║╚═╝\n" +
                                                "██╔══██╗██╔══██║██║     ██║     ╚════██║    ██║  ██║██╔══██╗██╔══██║██║███╗██║██║╚██╗██║██╗\n" +
                                                "██████╔╝██║  ██║███████╗███████╗███████║    ██████╔╝██║  ██║██║  ██║╚███╔███╔╝██║ ╚████║╚═╝\n" +
                                                "╚═════╝ ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚══╝╚══╝ ╚═╝  ╚═══╝   \n" +
                                                "                                                                                           ";

    public GameResults(BingoCard bc, int days, int seed) throws IOException {
        amount = bc.getAmtWinners();
        this.days = days;
        once = 0;
        amtBalls = 0;
        done = false;
        rn = new Random(seed);
        this.maxWinners = amount;
        bingoCards = bc.getBingoCards();
        daysTable = new int[0][0];
        winnersTable = new Object[maxWinners][3];
        ballsTable = new Object[75][3];
        cardsWon = new ArrayList<>();
        drawnNumbers = new ArrayList<>();

        while (cardsWon.size() < maxWinners) {
            drawBall();
        }
        amtBalls = drawnNumbers.size();
        getDays();
        for (int q = 0; q < cardsWon.size(); q++)
            getWin(cardsWon.get(q));

        Path fileName = Path.of("BingoCards/results.txt");
        StringBuilder content = new StringBuilder();
        content.append(winnersBanner + "\n");
        content.append("Card #:\t\t\t\tDay:\t\t\t\t\tRound:\n");
        for (int r = 0; r < winnersTable.length; r++)
            content.append(winnersTable[r][0] + "\t\t\t\t" + winnersTable[r][1] + "  \t\t\t\t" + winnersTable[r][2] + "\n");
        content.append("\n" + ballsBanner + "\n");
        content.append("Ball Drawn:\t\t\tDay:\t\t\t\t\tRound:\n");
        for (int r = 0; r < ballsTable.length; r++)
            content.append(ballsTable[r][0] + "\t\t\t\t" + ballsTable[r][1] + "  \t\t\t\t" + ballsTable[r][2] + "\n");
        Files.writeString(fileName, content);
    }

    public void drawBall() {
        if (done) return;
        if (drawnNumbers.size() == 75) {
            done = true;
            return;
        }
        int num;
        boolean valid = false;
        int tmp = 0;
        while (!valid) {
            tmp = rn.nextInt(75) + 1;
            if (!drawnNumbers.contains(tmp)) {
                valid = true;
            }
        }
        if (drawnNumbers.contains(tmp))
            System.out.println("how");
        drawnNumbers.add(tmp);
        if (cardsWon.size() < maxWinners) {
            checkWin();
        }
    }

    public void getDays() {
        System.out.println(amtBalls);
        daysTable = new int[2][days];
        for (int i = 0; i < daysTable[0].length; i++) {
            for (int j = 0; j < 2; j++) {
                daysTable[j][i] = amtBalls / (days * 2);
            }
        }
        int excess = amtBalls % (days * 2);
        outerloop:
        for (int i = 0; i < daysTable[0].length; i++) {
            for (int j = 0; j < 2; j++) {
                if (excess == 0) break outerloop;
                daysTable[j][i]++;
                excess--;
            }
        }
        System.out.println(Arrays.deepToString(daysTable));
        int count = 0;
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] round = {"AM", "PM"};
        ballsTable = new Object[drawnNumbers.size()][3];
        for (int i = 0; i < daysTable[0].length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < daysTable[j][i]; l++) {
                    addRow(ballsTable, new Object[]{drawnNumbers.get(count), days[i], round[j]});
                    count++;
                }
            }
        }
    }

    public void addRow(Object[][] list, Object[] row) {
        for (int i = 0; i < list.length; i++) {
            if (list[i][0] == null) {
                list[i] = row;
                return;
            }
        }
    }

    public void getWin(int q) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] rou = {"AM", "PM"};
        int round = bingoCards[q].getRoundWon();
        System.out.println(round);
        outer:
        for (int i = 0; i < daysTable[0].length; i++) {
            for (int j = 0; j < 2; j++) {
                round -= daysTable[j][i];
                if (round <= 0) {
                    addRow(winnersTable, new Object[]{q + 1, days[i], rou[j]});
                    break outer;
                }
            }
        }
    }

    public void checkWin() {
        for (int i = 0; i < bingoCards.length; i++) {
            int[][] card = bingoCards[i].getBoard();
            if ((!(cardsWon.contains(i))) && (
                    (drawnNumbers.contains(card[0][0]) && drawnNumbers.contains(card[0][1]) && drawnNumbers.contains(card[0][2]) && drawnNumbers.contains(card[0][3]) && drawnNumbers.contains(card[0][4])) ||
                            (drawnNumbers.contains(card[1][0]) && drawnNumbers.contains(card[1][1]) && drawnNumbers.contains(card[1][2]) && drawnNumbers.contains(card[1][3]) && drawnNumbers.contains(card[1][4])) ||
                            (drawnNumbers.contains(card[2][0]) && drawnNumbers.contains(card[2][1]) && drawnNumbers.contains(card[2][3]) && drawnNumbers.contains(card[2][4])) ||
                            (drawnNumbers.contains(card[3][0]) && drawnNumbers.contains(card[3][1]) && drawnNumbers.contains(card[3][2]) && drawnNumbers.contains(card[3][3]) && drawnNumbers.contains(card[3][4])) ||
                            (drawnNumbers.contains(card[4][0]) && drawnNumbers.contains(card[4][1]) && drawnNumbers.contains(card[4][2]) && drawnNumbers.contains(card[4][3]) && drawnNumbers.contains(card[4][4])) ||
                            (drawnNumbers.contains(card[0][0]) && drawnNumbers.contains(card[1][0]) && drawnNumbers.contains(card[2][0]) && drawnNumbers.contains(card[3][0]) && drawnNumbers.contains(card[4][0])) ||
                            (drawnNumbers.contains(card[0][1]) && drawnNumbers.contains(card[1][1]) && drawnNumbers.contains(card[2][1]) && drawnNumbers.contains(card[3][1]) && drawnNumbers.contains(card[4][1])) ||
                            (drawnNumbers.contains(card[0][2]) && drawnNumbers.contains(card[1][2]) && drawnNumbers.contains(card[3][2]) && drawnNumbers.contains(card[4][2])) ||
                            (drawnNumbers.contains(card[0][3]) && drawnNumbers.contains(card[1][3]) && drawnNumbers.contains(card[2][3]) && drawnNumbers.contains(card[3][3]) && drawnNumbers.contains(card[4][3])) ||
                            (drawnNumbers.contains(card[0][4]) && drawnNumbers.contains(card[1][4]) && drawnNumbers.contains(card[2][4]) && drawnNumbers.contains(card[3][4]) && drawnNumbers.contains(card[4][4])) ||
                            (drawnNumbers.contains(card[0][0]) && drawnNumbers.contains(card[1][1]) && drawnNumbers.contains(card[3][3]) && drawnNumbers.contains(card[4][4])) ||
                            (drawnNumbers.contains(card[0][4]) && drawnNumbers.contains(card[1][3]) && drawnNumbers.contains(card[3][1]) && drawnNumbers.contains(card[4][0])))) {
                cardsWon.add(i);
                bingoCards[i].setWon(true, drawnNumbers.size());
                System.out.println(bingoCards[i].getRoundWon());
            }
        }
    }
}
