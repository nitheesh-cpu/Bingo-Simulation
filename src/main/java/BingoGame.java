import com.formdev.flatlaf.icons.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class BingoGame extends JFrame {
    private JButton button, button2;
    private final JProgressBar progressBar;
    private final JTextField inputField, inputFieldThree, inputFieldTwo;
    private Font TWExtraLightItalic;
    private Font TWLightItalic;
    private HelpFrame hf;
    private Font TWRegular, DMRegular, TWItalic, TWLight;

    public BingoGame() {
        super("Bingo Menu");
        JFrame.setDefaultLookAndFeelDecorated(true);
        setLayout(new BorderLayout());
        pack();
        Dimension size = new Dimension(600, 300);
        setSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setLocationRelativeTo(null);
        getClass().getClassLoader();
        try {
            Font TWBlack = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Black.ttf"))).deriveFont(12f);
            Font TWBold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Bold.ttf"))).deriveFont(12f);
            Font TWBoldItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-BoldItalic.ttf"))).deriveFont(12f);
            Font TWExtraLight = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-ExtraLight.ttf"))).deriveFont(12f);
            TWExtraLightItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-ExtraLightItalic.ttf"))).deriveFont(12f);
            TWItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Italic.ttf"))).deriveFont(12f);
            TWLight = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Light.ttf"))).deriveFont(12f);
            TWLightItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-LightItalic.ttf"))).deriveFont(12f);
            TWRegular = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Regular.ttf"))).deriveFont(30f);
            Font TWSemiBold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-SemiBold.ttf"))).deriveFont(12f);
            Font TWSemiBoldItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-SemiBoldItalic.ttf"))).deriveFont(24f);
            Font JBExtraBold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("JetBrainsMono-ExtraBold.ttf"))).deriveFont(24f);
            Font DMItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("DankMono-Italic.ttf"))).deriveFont(12f);
            DMRegular = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("DankMono-Regular.ttf"))).deriveFont(24f);
            Font DMRegular2 = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("DankMono-Regular.ttf"))).deriveFont(12f);
            Font GSBold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Gill Sans Bold.otf"))).deriveFont(24f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(TWBlack);
            ge.registerFont(TWBold);
            ge.registerFont(TWBoldItalic);
            ge.registerFont(TWExtraLight);
            ge.registerFont(TWExtraLightItalic);
            ge.registerFont(TWItalic);
            ge.registerFont(TWLight);
            ge.registerFont(TWLightItalic);
            ge.registerFont(TWRegular);
            ge.registerFont(TWSemiBold);
            ge.registerFont(TWSemiBoldItalic);
            ge.registerFont(JBExtraBold);
            ge.registerFont(DMItalic);
            ge.registerFont(DMRegular);
            ge.registerFont(DMRegular2);
            ge.registerFont(GSBold);
        } catch (IOException | FontFormatException e) {
            System.out.println("Error");
        }

        Container win = getContentPane();
        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        win.setLayout(null);
        JLabel input = new JLabel("Game Code*");
        input.setSize(100, 20);
        input.setLocation((((getWidth() - 400) / 5))-10, 180);
        input.setFont(TWLightItalic);
        win.add(input);

        JLabel input2 = new JLabel("Number of Cards*");
        input2.setSize(150, 20);
        input2.setLocation((((getWidth()-400)/5)*2)+(100*1)-10, 180);
        input2.setFont(TWLightItalic);
        win.add(input2);

        JLabel input3 = new JLabel("Number of Winners");
        input3.setSize(150, 20);
        input3.setLocation((((getWidth()-400)/5)*3)+(100*2)-10, 180);
        input3.setFont(TWLightItalic);
        win.add(input3);

        JLabel credits = new JLabel("Made By: Nitheesh Kodarapu");
        credits.setSize(150, 20);
        credits.setFont(TWExtraLightItalic);
        credits.setLocation(5, 5);
        win.add(credits);

        JLabel heading = new JLabel("Bingo", SwingConstants.CENTER);
        heading.setSize(80, 65);
        heading.setLocation((getWidth() / 2) - 50, 20);
        heading.setFont(TWRegular);
        win.add(heading);

        JLabel input4 = new JLabel("Number of Days");
        input4.setSize(150, 20);
        input4.setLocation((((getWidth()-400)/5)*4)+(100*3)-10, 180);
        input4.setFont(TWLightItalic);
        win.add(input4);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLocation(178, 210);
        buttonPanel.setSize(100, 30);
        button = new JButton("Print Cards");
        button.setLocation(115, 210);
        button.setSize(100, 30);
        win.add(buttonPanel);
        buttonPanel.add(button);
        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setLocation(297, 210);
        buttonPanel2.setSize(130, 30);
        button2 = new JButton("Play Simulation");
        button2.setLocation(260, 210);
        button2.setSize(130, 30);
        win.add(buttonPanel2);
        buttonPanel2.add(button2);


        JButton help = new JButton();
        help.setFocusable(false);
        help.setBorderPainted(false);
        help.setContentAreaFilled(false);
        help.setFocusPainted(false);
        help.setOpaque(false);
        help.setSize(24,24);
        help.setLocation(8,230);
        help.setIcon(new FlatHelpButtonIcon());
        win.add(help);



//        JFrame helpFrame = new JFrame("How to use");
//        helpFrame.setSize(500,575);
//        helpFrame.setLocationRelativeTo(null);
//        helpFrame.setResizable(false);
//        helpFrame.setAlwaysOnTop(true);
//        helpFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
//        helpFrame.setVisible(true);
//        JLabel helpHeading = new JLabel("How to Use:",SwingConstants.CENTER);
//        helpHeading.setFont(TWRegular);
//        helpHeading.setLocation(0,0);
//        helpFrame.add(helpHeading);
//        JTextPane helpBody1 = new JTextPane();
//        helpBody1.setFont(TWLight);
//        helpBody1.setLocation(25,25);
//        helpBody1.setText("Hey there");
//        helpFrame.add(helpBody1);

        inputField = new JTextField("", 10);
        inputField.setSize(100, 30);
        inputField.setLocation((((getWidth() - 400) / 5))-10, 150);
        win.add(inputField);

        SpinnerModel value = new SpinnerNumberModel(0, 0, 10000, 1);
        JSpinner jSpinner = new JSpinner(value);
        jSpinner.setBounds((((getWidth()-400)/5)*2)+(100*1)-10, 150, 100, 30);
        win.add(jSpinner);

        inputFieldThree = new JTextField("", 10);
        inputFieldThree.setSize(100, 30);
        inputFieldThree.setLocation((((getWidth()-400)/5)*3)+(100*2)-10, 150);
        win.add(inputFieldThree);

        inputFieldTwo = new JTextField("", 10);
        inputFieldTwo.setSize(100, 30);
        inputFieldTwo.setLocation((((getWidth()-400)/5)*4)+(100*3)-10, 150);
        win.add(inputFieldTwo);

        JSeparator jSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        win.add(jSeparator);

        progressBar = new JProgressBar(SwingConstants.HORIZONTAL);
        progressBar.setSize(300, 25);
        progressBar.setLocation(90, 260);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setIndeterminate(true);
        progressBar.setFont(TWLightItalic);
        progressBar.setString("Creating Files...");
        win.add(progressBar);
        progressBar.setVisible(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        button.addActionListener(e -> {
            button = (JButton) e.getSource();
            String seed = inputField.getText();
            int winners = Integer.parseInt(inputFieldThree.getText());
            int days =  Integer.parseInt(inputFieldTwo.getText());
            int amount = (int) jSpinner.getValue();
            if (amount != 0) {
                setSize(500, 350);
                progressBar.setVisible(true);
                revalidate();
            }
            while(true) {
                try {
                    if (amount == 0) {
                        throw new NumberFormatException();
                    }if (winners == 0) {
                        throw new NumberFormatException();
                    }if (days == 0) {
                        throw new NumberFormatException();
                    }
                    ExecutorService executor = java.util.concurrent.Executors.newSingleThreadExecutor();
                    executor.submit(() -> {
                        try {
                            button.setEnabled(false);
                            button2.setEnabled(false);
                            help.setEnabled(false);
                            new BingoBoard(Integer.parseInt(seed), (Math.round(amount / 4) * 4) + 4,winners,days);
                            dispose();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(BingoGame.super.getContentPane(), "You are missing an argument! \nPlease go back and enter a number!", "Missing Arguments!", JOptionPane.ERROR_MESSAGE);
                    throw ex;
                }
                break;

            }


            System.out.println("Frame Closed.");
        });
        button2.addActionListener(e -> {
            button2 = (JButton) e.getSource();
            String seed = inputField.getText();
            String winners = inputFieldThree.getText();
            int amount = (int) jSpinner.getValue();
            int days =  Integer.parseInt(inputFieldTwo.getText());
            while (true) {
                try {
                    if (seed.isBlank()) {
                        throw new NumberFormatException();
                    }
                    if (winners.isBlank()) throw new NumberFormatException();
                    if (amount == 0) throw new NumberFormatException();
                    if (days == 0) throw new NumberFormatException();

                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(BingoGame.super.getContentPane(), "You are missing an argument! \nPlease go back and enter a number!", "Missing Arguments!", JOptionPane.ERROR_MESSAGE);
                    throw ex;
                }
                break;
            }
            BingoCard bc = null;
            try {
                bc = new BingoCard(Integer.parseInt(seed), amount,Integer.parseInt(winners));
                new BingoSimFrame(bc,days,Integer.parseInt(seed)).setVisible(true);
            } catch (IOException ex) {
                System.out.println("It's me");
                ex.printStackTrace();
            }


            setVisible(false);
            System.out.println("Frame Closed.");
        });

        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(hf == null) {
                    hf = new HelpFrame();
                    hf.setVisible(true);
                }
                else if(hf.isVisible())
                    hf.setVisible(false);
                else if(!hf.isVisible())
                    hf.setVisible(true);

            }
        });

    }


}