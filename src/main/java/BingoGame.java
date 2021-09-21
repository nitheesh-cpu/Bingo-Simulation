import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.icons.FlatHelpButtonIcon;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class BingoGame extends JFrame {
    private JButton button, button2;
    private final JProgressBar progressBar;
    private final JTextField inputField, inputFieldThree;
    private final JSpinner inputFieldTwo;
    private Font TWExtraLightItalic;
    private Font TWLightItalic;
    private final JFrame helpFrame;
    private final JRadioButton png;
    private final JRadioButton pdf;
    private final ButtonGroup buttonGroup;
    private final JButton help;
    //    private HelpFrame hf;
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
        JLabel input = new JLabel("Game Code");
        input.setSize(100, 20);
        input.setLocation((((getWidth() - 400) / 5)) - 10, 180);
        input.setFont(TWLightItalic);
        win.add(input);

        JLabel input2 = new JLabel("Number of Cards");
        input2.setSize(150, 20);
        input2.setLocation((((getWidth() - 400) / 5) * 2) + (100 * 1) - 10, 180);
        input2.setFont(TWLightItalic);
        win.add(input2);

        JLabel input3 = new JLabel("Number of Winners");
        input3.setSize(150, 20);
        input3.setLocation((((getWidth() - 400) / 5) * 3) + (100 * 2) - 10, 180);
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
        input4.setLocation((((getWidth() - 400) / 5) * 4) + (100 * 3) - 10, 180);
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


        help = new JButton();
        help.setFocusable(false);
        help.setContentAreaFilled(false);
        help.setOpaque(false);
        help.setSize(24, 24);
        help.setLocation(550, 8);
        help.setIcon(new FlatHelpButtonIcon());
        win.add(help);

        pdf = new JRadioButton("PDF");
        pdf.setActionCommand("pdf");
        pdf.setSize(100, 24);
        pdf.setLocation(8, 231);
        png = new JRadioButton("PNG");
        png.setActionCommand("png");
        png.setSize(100, 24);
        png.setLocation(8, 211);
        pdf.setSelected(true);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(pdf);
        buttonGroup.add(png);
        win.add(pdf);
        win.add(png);


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
        inputField.setLocation((((getWidth() - 400) / 5)) - 10, 150);
        win.add(inputField);

        SpinnerModel value = new SpinnerNumberModel(0, 0, 10000, 1);
        JSpinner jSpinner = new JSpinner(value);
        jSpinner.setBounds((((getWidth() - 400) / 5) * 2) + (100 * 1) - 10, 150, 100, 30);
        win.add(jSpinner);

        inputFieldThree = new JTextField("", 10);
        inputFieldThree.setSize(100, 30);
        inputFieldThree.setLocation((((getWidth() - 400) / 5) * 3) + (100 * 2) - 10, 150);
        win.add(inputFieldThree);

        SpinnerModel daysModel = new SpinnerNumberModel(5, 1, 5, 1);
        inputFieldTwo = new JSpinner(daysModel);
        inputFieldTwo.setSize(100, 30);
        inputFieldTwo.setLocation((((getWidth() - 400) / 5) * 4) + (100 * 3) - 10, 150);
        win.add(inputFieldTwo);

        JSeparator jSeparator = new JSeparator(SwingConstants.HORIZONTAL);
        win.add(jSeparator);

        progressBar = new JProgressBar(SwingConstants.HORIZONTAL);
        progressBar.setSize(300, 25);
        progressBar.setLocation(150, 260);
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


        helpFrame = new JFrame("How to Use");
        helpFrame.setSize(500, 575);
        helpFrame.setLayout(null);
        helpFrame.setLocationRelativeTo(null);
        helpFrame.setResizable(false);
        //setAlwaysOnTop(true);
        helpFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        //helpFrame.setVisible(true);
        //popup.pack();
        JPanel helpF = new JPanel(), settings = new JPanel();
        helpF.setLayout(null);
        //settings.setLayout(new BorderLayout());
        helpF.setSize(helpFrame.getWidth(), helpFrame.getHeight());


        JLabel helpHeading = new JLabel("How to Use:", SwingConstants.CENTER);
        helpHeading.setFont(TWRegular);
        helpHeading.setSize(250, 50);
        helpHeading.setLocation(helpFrame.getWidth() / 2 - 135, 0);
        helpF.add(helpHeading);
        JTextArea helpBody1 = new JTextArea();
        helpBody1.setFont(TWLight);
        helpBody1.setEditable(false);
        helpBody1.setLineWrap(true);
        helpBody1.setWrapStyleWord(true);
        helpBody1.setSize(400, 400);
        helpBody1.setLocation(25, 75);
        helpBody1.setText("""
                How to use the Main Menu:
                Enter a game code for your bingo game, this game code will allow you to run the program again with the same code and get the same bingo cards. Enter the number of bingo cards you want, the number of winners you want to play until, and the number of days you want to play the game over.Next, you can choose to either "Print Cards" which will save a pdf of all your bingo cards, or "Play Simulation" which will allow you to see how the game will play out and look at the game results.
                                
                How to use Print Cards:
                Fill in all the fields and press which export option you would like in the bottom left and press 'Print Cards' to save the set amount of cards to your computer.
                                
                How to use the Bingo Simulation:
                Use the spinner at the top by clicking the arrows on the side, or by manually entering a number, to change the card shown on the left side. From here you can click the button at the bottom right to draw a bingo ball and mark all the boards that have that number. The simulation will go on until set amount of winners have been reached and then you will be able to view the game results that have a table of the winning cards and drawn bingo balls, listed by the day and round they were pulled/won.""");
        helpF.add(helpBody1);
        //helpFrame.add(help);


        JLabel themeHeading = new JLabel("**Changing theme doesn't change the colors of the Bingo board**", SwingConstants.CENTER);
        themeHeading.setFont(TWLightItalic);

//        themeHeading.setSize(250,50);
//        themeHeading.setLocation(getWidth()/2-135,0);
        settings.add(themeHeading);
        Object[] data = {
                "Flat Dark", "Flat Darcula", "Ark Dark", "Ark Dark - Orange", "Carbon", "Carbon 2", "Dark Flat", "Dark Purple", "Dracula", "Gradiento Dark Fuchsia", "Gradiento Deep Ocean", "Gradiento Midnight Blue", "Gradiento Nature Green", "Gruvbox Dark Hard", "Gruvbox Dark Medium", "Gruvbox Dark Soft", "Hiberbee Dark", "High Contrast", "Material Design Dark", "Monocai", "Nord", "One Dark", "Solarized Dark", "Spacegray", "Vuesion", "Arc Dark", "Ark Dark Contrast", "Atom One Dark", "Atom One Dark Contrast", "Dracula", "Dracula Contrast", "Github Dark", "Github Dark Contrast", "Material Darker", "Material Darker Contrast", "Material Deep Ocean", "Material Deep Ocean Contrast", "Material Oceanic", "Material Oceanic Contrast", "Material Palenight", "Material Palenight Contrast", "Monokai Pro", "Monokai Pro Contrast", "Moonlight", "Moonlight Contrast", "Night Owl", "Night Owl Contrast", "Solarized Dark", "Solarized Dark Contrast"
        };
        JList<Object> list = new JList<>(data); //data has type Object[]
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLocation(helpFrame.getWidth() / 2 - 135, 30);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setVisibleRowCount(-1);
        list.setSelectedIndex(20);
        list.setSize(400, 450);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(200, 450));
        settings.add(list);


        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(0, 0, helpFrame.getWidth(), helpFrame.getHeight());
        tp.addTab("How to Play", helpF);
        tp.addTab("Theme", settings);
        helpFrame.add(tp);
        helpFrame.revalidate();
        list.addListSelectionListener(listSelectionListener);


        button.addActionListener(e -> {
            button = (JButton) e.getSource();
            String seed = inputField.getText();
            String winners = inputFieldThree.getText();
            int amount = (int) jSpinner.getValue();
            int days = (int) inputFieldTwo.getValue();
            while (true) {
                try {
                    if (amount == 0) {
                        throw new NumberFormatException();
                    }
                    if (winners.isBlank()) {
                        throw new NumberFormatException();
                    }
                    if (Integer.parseInt(winners) > amount) {
                        throw new WinnersGreaterThanAmount();
                    }
                    if (days == 0) {
                        throw new NumberFormatException();
                    }
                    setSize(500, 350);
                    progressBar.setVisible(true);
                    revalidate();
                    ExecutorService executor = java.util.concurrent.Executors.newSingleThreadExecutor();
                    executor.submit(() -> {
                        try {
                            button.setEnabled(false);
                            button2.setEnabled(false);
                            help.setEnabled(false);
                            new BingoBoard(Integer.parseInt(seed), (Math.round(amount / 4) * 4) + 4, Integer.parseInt(winners), days, buttonGroup.getSelection().getActionCommand());
                            dispose();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(BingoGame.super.getContentPane(), "You are missing an argument! \nPlease go back and enter a number!", "Missing Arguments!", JOptionPane.ERROR_MESSAGE);
                    throw ex;
                } catch (WinnersGreaterThanAmount ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(BingoGame.super.getContentPane(), "Why are there more winning cards than cards created?", "Something seems wrong...", JOptionPane.ERROR_MESSAGE);
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

            int days = (int) inputFieldTwo.getValue();
            while (true) {
                try {
                    if (seed.isBlank()) {
                        throw new NumberFormatException();
                    }
                    if (winners.isBlank()) throw new NumberFormatException();
                    if (Integer.parseInt(winners) > amount) throw new WinnersGreaterThanAmount();
                    if (amount == 0) throw new NumberFormatException();
                    if (days == 0) throw new NumberFormatException();

                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(BingoGame.super.getContentPane(), "You are missing an argument! \nPlease go back and enter a number!", "Missing Arguments!", JOptionPane.ERROR_MESSAGE);
                    throw ex;
                } catch (WinnersGreaterThanAmount ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(BingoGame.super.getContentPane(), "Why are there more winning cards than cards created?", "Something seems wrong...", JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
            BingoCard bc = null;
            try {
                bc = new BingoCard(Integer.parseInt(seed), amount, Integer.parseInt(winners));
                new BingoSimFrame(bc, days, Integer.parseInt(seed)).setVisible(true);
            } catch (IOException ex) {
                System.out.println("It's me");
                ex.printStackTrace();
            }


            setVisible(false);
            System.out.println("Frame Closed.");
        });

        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (helpFrame.isVisible())
                    helpFrame.setVisible(false);
                else if (!helpFrame.isVisible())
                    helpFrame.setVisible(true);

            }
        });

    }

    public void changeTheme(int x) {
        switch (x) {
            case 0 -> {
                FlatDarkLaf.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 1 -> {
                FlatDarculaLaf.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 2 -> {
                FlatArcDarkIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 3 -> {
                FlatArcDarkOrangeIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 4 -> {
                FlatCarbonIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 5 -> {
                FlatCobalt2IJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 6 -> {
                FlatDarkFlatIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 7 -> {
                FlatDarkPurpleIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 8 -> {
                FlatDraculaIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 9 -> {
                FlatGradiantoDarkFuchsiaIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 10 -> {
                FlatGradiantoDeepOceanIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 11 -> {
                FlatGradiantoMidnightBlueIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 12 -> {
                FlatGradiantoNatureGreenIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 13 -> {
                FlatGruvboxDarkHardIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 14 -> {
                FlatGruvboxDarkMediumIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 15 -> {
                FlatGruvboxDarkSoftIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 16 -> {
                FlatHiberbeeDarkIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 17 -> {
                FlatHighContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 18 -> {
                FlatMaterialDesignDarkIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 19 -> {
                FlatMonocaiIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 20 -> {
                FlatNordIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 21 -> {
                FlatOneDarkIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 22 -> {
                FlatSolarizedDarkIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 23 -> {
                FlatSpacegrayIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 24 -> {
                FlatVuesionIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 25 -> {
                com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 26 -> {
                FlatArcDarkContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 27 -> {
                FlatAtomOneDarkIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 28 -> {
                FlatAtomOneDarkContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 29 -> {
                com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 30 -> {
                FlatDraculaContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 31 -> {
                FlatGitHubDarkIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 32 -> {
                FlatGitHubDarkContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 33 -> {
                FlatMaterialDarkerIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 34 -> {
                FlatMaterialDarkerContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 35 -> {
                FlatMaterialDeepOceanIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 36 -> {
                FlatMaterialDeepOceanContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 37 -> {
                FlatMaterialOceanicIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 38 -> {
                FlatMaterialOceanicContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 39 -> {
                FlatMaterialPalenightIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 40 -> {
                FlatMaterialPalenightContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 41 -> {
                FlatMonokaiProIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 42 -> {
                FlatMonokaiProContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 43 -> {
                FlatMoonlightIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 44 -> {
                FlatMoonlightContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 45 -> {
                FlatNightOwlIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 46 -> {
                FlatNightOwlContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 47 -> {
                com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatSolarizedDarkIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            case 48 -> {
                FlatSolarizedDarkContrastIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
            default -> {
                FlatNordIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(super.rootPane);
                SwingUtilities.updateComponentTreeUI(helpFrame);
            }
        }
        help.setIcon(new FlatHelpButtonIcon());
    }

    ListSelectionListener listSelectionListener = new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            boolean adjust = listSelectionEvent.getValueIsAdjusting();
            System.out.println(", Adjusting? " + adjust);
            if (!adjust) {
                JList list = (JList) listSelectionEvent.getSource();
                int[] selections = list.getSelectedIndices();
                Object[] selectionValues = list.getSelectedValues();
                for (int i = 0, n = selections.length; i < n; i++) {
                    if (i == 0) {
                        System.out.print("  Selections: ");
                    }
                    System.out.print(selections[i] + "/" + selectionValues[i] + " ");
                    changeTheme(selections[i]);
                }
                System.out.println();
            }
        }
    };


}

class WinnersGreaterThanAmount extends Exception {
    public WinnersGreaterThanAmount() {
        super("HOW ARE THERE MORE WINNING CARDS THAN CARDS CREATED HUHHHH????");
    }
}