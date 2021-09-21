import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class BingoSimFrame extends JFrame {
    private Font TWBlack, TWBold, GSBold, DMRegular, DMItalic, JBExtraBold, TWBoldItalic, TWExtraLight, TWExtraLightItalic, TWItalic, TWLight, TWLightItalic, TWRegular, TWSemiBold, TWSemiBoldItalic;
    private final BingoCardObj[] bingoCards;
    private int[][] board;
    private final JPanel panel;
    private final JTextArea textArea2;
    private final Random rn;
    private boolean done;
    private int amtBalls;
    private int[][] daysTable;
    private Graphics cardGraphics;
    private final ArrayList<Integer> drawnNumbers;
    private final ArrayList<Integer> cardsWon;
    private int count;
    private JScrollPane scrollPane, scrollPane2;
    private JTable table, table2;
    private String[] columnNames, columnNames2;
    private final int seed;
    private int once;
    private final int maxWinners;
    private final int days;
    private Object[][] data, data2;
    private final DefaultTableModel defaultTableModel2;
    private final DefaultTableModel defaultTableModel;


    public BingoSimFrame(BingoCard bc, int days, int seed) {
        super("Bingo Simulation");
        JFrame.setDefaultLookAndFeelDecorated(true);
//        getDays();
        this.pack();
        setSize(1010, 665);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.days = days;
        this.seed = seed;
        try {

            JBExtraBold = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("JetBrainsMono-ExtraBold.ttf")).deriveFont(120f);
            DMItalic = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("DankMono-Italic.ttf")).deriveFont(40f);
            TWLightItalic = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("TitilliumWeb-LightItalic.ttf")).deriveFont(35f);
            DMRegular = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("DankMono-Regular.ttf")).deriveFont(25f);
            GSBold = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("Gill Sans Bold.otf")).deriveFont(12f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(JBExtraBold);
            ge.registerFont(DMItalic);
            ge.registerFont(TWLightItalic);
            ge.registerFont(DMRegular);
            ge.registerFont(GSBold);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        try {
            TWBlack = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Black.ttf"))).deriveFont(12f);
            TWBold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Bold.ttf"))).deriveFont(12f);
            TWBoldItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-BoldItalic.ttf"))).deriveFont(12f);
            TWExtraLight = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-ExtraLight.ttf"))).deriveFont(12f);
            TWExtraLightItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-ExtraLightItalic.ttf"))).deriveFont(12f);
            TWItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Italic.ttf"))).deriveFont(12f);
            TWLight = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Light.ttf"))).deriveFont(12f);
//            TWLightItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-LightItalic.ttf"))).deriveFont(12f);
            TWRegular = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Regular.ttf"))).deriveFont(30f);
            TWSemiBold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-SemiBold.ttf"))).deriveFont(12f);
            TWSemiBoldItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-SemiBoldItalic.ttf"))).deriveFont(24f);
//            JBExtraBold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("JetBrainsMono-ExtraBold.ttf"))).deriveFont(24f);
//            DMItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("DankMono-Italic.ttf"))).deriveFont(12f);
            DMRegular = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("DankMono-Regular.ttf"))).deriveFont(24f);
//            GSBold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Gill Sans Bold.otf"))).deriveFont(24f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(TWBlack);
            ge.registerFont(TWBold);
            ge.registerFont(TWBoldItalic);
            ge.registerFont(TWExtraLight);
            ge.registerFont(TWExtraLightItalic);
            ge.registerFont(TWItalic);
            ge.registerFont(TWLight);
//            ge.registerFont(TWLightItalic);
            ge.registerFont(TWRegular);
            ge.registerFont(TWSemiBold);
            ge.registerFont(TWSemiBoldItalic);
//            ge.registerFont(JBExtraBold);
//            ge.registerFont(DMItalic);
            ge.registerFont(DMRegular);
//            ge.registerFont(GSBold);
        } catch (IOException | FontFormatException e) {
            System.out.println("Error");
        }

        bingoCards = bc.getBingoCards();
        count = 0;
        amtBalls = 0;
        daysTable = new int[0][0];
        cardsWon = new ArrayList<>();
        drawnNumbers = new ArrayList<>();
        rn = new Random(seed);
        done = false;
        once = 0;
        maxWinners = bc.getAmtWinners();
        panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                cardGraphics = g;
                makePage(g);
                markNumbers(g);
                fillPage(g);
            }

            public void makePage(Graphics g) {
                Graphics2D card = (Graphics2D) g;
                card.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                card.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                card.setColor(new Color(59, 66, 82));
                card.fillRect(0, 0, 500, 625);
                card.setColor(new Color(229, 233, 240));
                card.setFont(GSBold);
                int x = count + 1;
                card.drawString("#" + x, 0, 620);
                card.setColor(new Color(76, 86, 106));
                card.fillRect(0, 100, 500, 500);
                card.setColor(new Color(67, 76, 94));
                for (int i = 100; i < 301; i += 200) {
                    card.setColor(new Color(67, 76, 94));
                    g.fillRect(i, 100, 100, 100);
                    g.fillRect(i, 300, 100, 100);
                    g.fillRect(i, 500, 100, 100);
                }
                for (int i = 0; i < 401; i += 200) {
                    g.fillRect(i, 200, 100, 100);
                    g.fillRect(i, 400, 100, 100);
                }
                g.setColor(new Color(191, 97, 106));
                g.fillOval(205, 305, 90, 90);
                card.setColor(new Color(229, 233, 240));
                card.setFont(JBExtraBold);
                card.drawString("B", 13, 93);
                card.drawString("I", 113, 93);
                card.drawString("N", 213, 93);
                card.drawString("G", 313, 93);
                card.drawString("O", 410, 93);
                card.setFont(DMItalic);
                card.drawString("FREE", 205, 365);
            }

            public void markNumbers(Graphics g) {
                int[][] card = bingoCards[count].getBoard();
                if (bingoCards[count].didWin()) {
                    ArrayList<Integer> drawn = new ArrayList<>();
                    for (int i = 1; i <= bingoCards[count].getRoundWon(); i++) {
                        drawn.add(drawnNumbers.get(i - 1));
                    }
                    for (int r = 1; r <= 5; r++) {
                        for (int c = 0; c < 5; c++) {
                            if (drawn.contains(card[r - 1][c])) {
                                g.setColor(new Color(191, 97, 106));
                                g.fillOval(c * 100 + 5, r * 100 + 5, 90, 90);
                            }
                        }
                    }
                } else {
                    for (int r = 1; r <= 5; r++) {
                        for (int c = 0; c < 5; c++) {
                            if (drawnNumbers.contains(card[r - 1][c])) {
                                g.setColor(new Color(191, 97, 106));
                                g.fillOval(c * 100 + 5, r * 100 + 5, 90, 90);
                            }
                        }
                    }
                }
            }

            public void fillPage(Graphics g) {
                g.setFont(DMItalic);
                board = bingoCards[count].getBoard();
                try {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 1; j < 6; j++) {
                            if (!(i == 2 && j == 3)) {
                                g.setColor(new Color(229, 233, 240));
                                g.drawString(String.valueOf(board[j - 1][i]), ((i) * 100) + 25, (j * 100) + 65);
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "You are missing an argument! \nPlease go back and enter a number!", "Missing Arguments!", JOptionPane.ERROR_MESSAGE);
                }
            }

        };
        panel.setSize(500, 625);
        add(panel);

        JPanel comps = new JPanel();
        GridLayout layout = new GridLayout(0, 2);
        setLayout(layout);
        GridLayout components = new GridLayout(8, 0);
        comps.setLayout(components);
        components.setVgap(15);
        comps.setSize(500, 625);
        comps.setBorder(BorderFactory.createEmptyBorder(0, 30, 30, 30));
        add(comps);

        JLabel label = new JLabel();
        label.setSize(300, 15);
        label.setLocation(600, 15);
        label.setFont(TWLightItalic);
        label.setText("Bingo Card Number:");
        comps.add(label);

        SpinnerModel model = new SpinnerNumberModel(1, 1, bingoCards.length, 1);
        JSpinner spinner = new JSpinner(model);
        JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) spinner.getEditor();
        spinnerEditor.getTextField().setHorizontalAlignment(JTextField.LEFT);
        spinner.setBounds(800, 100, 250, 30);
        spinner.setSize(new Dimension(150, 30));
        comps.add(spinner);

        JLabel label2 = new JLabel();
        label2.setSize(300, 100);
        label2.setLocation(600, 15);
        label2.setFont(TWLightItalic);
        label2.setText("Drawn Numbers:");
        comps.add(label2);

        JTextArea textArea = new JTextArea();
        textArea.setSize(400, 400);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setVisible(true);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        textArea.setSize(new Dimension(500, 300));
        comps.add(scroll);

        JLabel label3 = new JLabel();
        label3.setSize(300, 100);
        label3.setLocation(600, 15);
        label3.setFont(TWLightItalic);
        label3.setText("Cards Won:");
        comps.add(label3);

        textArea2 = new JTextArea();
        textArea2.setSize(400, 400);
        textArea2.setLineWrap(true);
        textArea2.setEditable(false);
        textArea2.setVisible(true);
        JScrollPane scroll2 = new JScrollPane(textArea2);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        textArea2.setSize(new Dimension(500, 300));
        comps.add(scroll2);

//        columnNames = new String[]{"Roll #", "Ball"};
//        data = new Object[75][2];
//        table = new JTable(data,columnNames);
//        scrollPane = new JScrollPane(table);
//        table.setFillsViewportHeight(true);
//        table.setCellSelectionEnabled(false);
//        comps.add(scrollPane, BorderLayout.CENTER);
//
//        columnNames2 = new String[]{"Roll #", "Card ID"};
//        data2 = new Object[maxWinners][2];
//        table2 = new JTable(data2,columnNames2);
//        scrollPane2 = new JScrollPane(table2);
//        table2.setFillsViewportHeight(true);
//        comps.add(scrollPane2, BorderLayout.CENTER);

        JLabel label4 = new JLabel();
        label4.setSize(300, 100);
        label4.setLocation(600, 15);
        label4.setFont(TWLightItalic);
        label4.setText("Draw a Number:");
        comps.add(label4);

        JButton draw = new JButton("Click");
        draw.setLocation(235, 210);
        draw.setSize(130, 30);
        comps.add(draw);

        JButton results = new JButton("Show Results");
        results.setLocation(235, 210);
        results.setSize(130, 30);


        JFrame popup = new JFrame("Game Results");
        //popup.pack();
        popup.setLayout(new BorderLayout());
        popup.setSize(500, 575);
        popup.setLocationRelativeTo(null);
        popup.setResizable(false);
        popup.setAlwaysOnTop(true);
        popup.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JPanel info = new JPanel(), table = new JPanel();
        JLabel heading = new JLabel("Balls Drawn:");
        heading.setSize(200, 65);
        heading.setLocation((popup.getWidth() / 2) - 100, 10);
        heading.setFont(TWRegular);
        info.add(heading);
        JLabel heading2 = new JLabel("Winning Cards:");
        heading2.setSize(200, 65);
        heading2.setLocation((popup.getWidth() / 2) - 100, 10);
        heading2.setFont(TWRegular);
        table.add(heading2);

        JTable jt = new JTable(new DefaultTableModel());
        defaultTableModel = (DefaultTableModel) jt.getModel();
        defaultTableModel.addColumn("Card #");
        defaultTableModel.addColumn("Day");
        defaultTableModel.addColumn("Round");
        jt.setCellSelectionEnabled(false);
        jt.setBounds(30, 40, 500, 100);
        jt.setEnabled(false);
        JScrollPane sp = new JScrollPane(jt);
        table.add(sp);

        JTable jt2 = new JTable(new DefaultTableModel());
        defaultTableModel2 = (DefaultTableModel) jt2.getModel();
        defaultTableModel2.addColumn("Ball");
        defaultTableModel2.addColumn("Day");
        defaultTableModel2.addColumn("Round");
        jt2.setCellSelectionEnabled(false);
        jt2.setBounds(30, 40, 500, 100);
        jt2.setEnabled(false);
        JScrollPane sp2 = new JScrollPane(jt2);
        info.add(sp2, BorderLayout.CENTER);

        JTabbedPane tp = new JTabbedPane();
        tp.add("Winners", table);
        tp.add("Balls", info);
        popup.add(tp);


//        popup.add(info);
//        popup.add(table);

        setResizable(false);
        setVisible(true);

        draw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (done) return;
                if (drawnNumbers.size() == 75) {
                    done = true;
                    textArea.append("\nAll out of numbers!");
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
                if (cardsWon.size() >= maxWinners) {
                    if (once == 0) {
                        textArea2.append("\nGame Over!");
                        amtBalls = drawnNumbers.size();
                        getDays();
                        for (int q = 0; q < cardsWon.size(); q++)
                            getWin(cardsWon.get(q));
                        comps.remove(draw);
                        label4.setText("Get Game Results:");
                        comps.add(results);
                    }
                    once++;
                }
                //System.out.println(tmp);
                textArea.append(tmp + "   ");
                panel.repaint();
            }
        });
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                count = Integer.parseInt("" + ((JSpinner) e.getSource()).getValue()) - 1;
                panel.repaint();
            }
        });

        results.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!popup.isVisible())
                    popup.setVisible(true);
            }
        });

        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                count = Integer.parseInt("" + ((JSpinner) e.getSource()).getValue()) - 1;
                panel.repaint();
            }
        });

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
        Object[][] daysArr = new Object[2][days];
        int count = 0;
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[] round = {"AM", "PM"};
        for (int i = 0; i < daysTable[0].length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int l = 0; l < daysTable[j][i]; l++) {
                    defaultTableModel2.addRow(new Object[]{drawnNumbers.get(count), days[i], round[j]});
                    count++;
                }
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
                    defaultTableModel.addRow(new Object[]{q + 1, days[i], rou[j]});
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
                textArea2.append("#" + (i + 1) + "   ");
                cardsWon.add(i);
                bingoCards[i].setWon(true, drawnNumbers.size());
                System.out.println(bingoCards[i].getRoundWon());
            }
        }
    }

//    public int checkAmtWin(ArrayList<Integer> nums) {
//        int count = 0;
//        for (int i = 0; i < bingoCards.length; i++) {
//            int[][] card = bingoCards[i].getBoard();
//            if ((!(cardsWon.contains(i))) && (
//                    (nums.contains(card[0][0]) && nums.contains(card[0][1]) && nums.contains(card[0][2]) && nums.contains(card[0][3]) && nums.contains(card[0][4])) ||
//                            (nums.contains(card[1][0]) && nums.contains(card[1][1]) && nums.contains(card[1][2]) && nums.contains(card[1][3]) && nums.contains(card[1][4])) ||
//                            (nums.contains(card[2][0]) && nums.contains(card[2][1]) && nums.contains(card[2][3]) && nums.contains(card[2][4])) ||
//                            (nums.contains(card[3][0]) && nums.contains(card[3][1]) && nums.contains(card[3][2]) && nums.contains(card[3][3]) && nums.contains(card[3][4])) ||
//                            (nums.contains(card[4][0]) && nums.contains(card[4][1]) && nums.contains(card[4][2]) && nums.contains(card[4][3]) && nums.contains(card[4][4])) ||
//                            (nums.contains(card[0][0]) && nums.contains(card[1][0]) && nums.contains(card[2][0]) && nums.contains(card[3][0]) && nums.contains(card[4][0])) ||
//                            (nums.contains(card[0][1]) && nums.contains(card[1][1]) && nums.contains(card[2][1]) && nums.contains(card[3][1]) && nums.contains(card[4][1])) ||
//                            (nums.contains(card[0][2]) && nums.contains(card[1][2]) && nums.contains(card[3][2]) && nums.contains(card[4][2])) ||
//                            (nums.contains(card[0][3]) && nums.contains(card[1][3]) && nums.contains(card[2][3]) && nums.contains(card[3][3]) && nums.contains(card[4][3])) ||
//                            (nums.contains(card[0][4]) && nums.contains(card[1][4]) && nums.contains(card[2][4]) && nums.contains(card[3][4]) && nums.contains(card[4][4])) ||
//                            (nums.contains(card[0][0]) && nums.contains(card[1][1]) && nums.contains(card[3][3]) && nums.contains(card[4][4])) ||
//                            (nums.contains(card[0][4]) && nums.contains(card[1][3]) && nums.contains(card[3][1]) && drawnNumbers.contains(card[4][0])))) {
//                count++;
//            }
//        }
//        return count;
//    }

}