import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ListCellRenderer;
import java.io.IOException;
import java.util.Objects;

public class HelpFrame extends BingoGame{
    private Font TWBlack,TWBold,TWLight,TWBoldItalic,TWExtraLight,TWExtraLightItalic,TWItalic,TWLightItalic,TWRegular,TWSemiBold,TWSemiBoldItalic,JBExtraBold,DMItalic,DMRegular,DMRegular2,GSBold;
    private JButton fc;
    private JLabel l;
    private JList<Object> list;
    private String folderDir;

    public HelpFrame(){

        //super("How to Use");
        try {
            TWBlack = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Black.ttf"))).deriveFont(12f);
            TWBold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Bold.ttf"))).deriveFont(12f);
            TWBoldItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-BoldItalic.ttf"))).deriveFont(12f);
            TWExtraLight = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-ExtraLight.ttf"))).deriveFont(12f);
            TWExtraLightItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-ExtraLightItalic.ttf"))).deriveFont(12f);
            TWItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Italic.ttf"))).deriveFont(12f);
            TWLight = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Light.ttf"))).deriveFont(12f);
            TWLightItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-LightItalic.ttf"))).deriveFont(12f);
            TWRegular = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-Regular.ttf"))).deriveFont(30f);
            TWSemiBold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-SemiBold.ttf"))).deriveFont(12f);
            TWSemiBoldItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("TitilliumWeb-SemiBoldItalic.ttf"))).deriveFont(24f);
            JBExtraBold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("JetBrainsMono-ExtraBold.ttf"))).deriveFont(24f);
            DMItalic = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("DankMono-Italic.ttf"))).deriveFont(12f);
            DMRegular = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("DankMono-Regular.ttf"))).deriveFont(24f);
            DMRegular2 = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("DankMono-Regular.ttf"))).deriveFont(12f);
            GSBold = Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("Gill Sans Bold.otf"))).deriveFont(24f);

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


        //Container helpFrame = getContentPane();
        JFrame helpFrame = new JFrame("How to Use");
        helpFrame.setSize(500,575);
        helpFrame.setLayout(null);
        helpFrame.setLocationRelativeTo(null);
        helpFrame.setResizable(false);
        //setAlwaysOnTop(true);
        helpFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        helpFrame.setVisible(true);
        //popup.pack();
        JPanel help = new JPanel(), settings = new JPanel();
        help.setLayout(null);
        //settings.setLayout(new BorderLayout());
        help.setSize(getWidth(),getHeight());



        JLabel helpHeading = new JLabel("How to Use:",SwingConstants.CENTER);
        helpHeading.setFont(TWRegular);
        helpHeading.setSize(250,50);
        helpHeading.setLocation(getWidth()/2-135,0);
        help.add(helpHeading);
        JTextArea helpBody1 = new JTextArea();
        helpBody1.setFont(TWLight);
        helpBody1.setEditable(false);
        helpBody1.setLineWrap(true);
        helpBody1.setWrapStyleWord(true);
        helpBody1.setSize(400,400);
        helpBody1.setLocation(25,75);
        helpBody1.setText("""
                How to use the Main Menu:
                Enter a game code for your bingo game, this game code will allow you to run the program again with the same code and get the same bingo cards.Enter the number of bingo cards you want, the number of winners you want to play until, and the number of days you want to play the game over.Next, you can choose to either "Print Cards" which will save a pdf of all your bingo cards, or "Play Simulation" which will allow you to see how the game will play out and look at the game results.
                *For printing Bingo cards you only need a game code and number of cards.

                How to use the Bingo Simulation:
                Use the spinner at the top by clicking the arrows on the side, or by manually entering a number, to change the card shown on the left side. From here you can click the button at the bottom right to draw a bingo ball and mark all the boards that have that number. The simulation will go on until set amount of winners have been reached and then you will be able to view the game results that have a table of the winning cards and drawn bingo balls, listed by the day and round they were pulled/won.""");
        help.add(helpBody1);
        //helpFrame.add(help);


        JLabel themeHeading = new JLabel("**Changing theme doesn't change the colors of the Bingo board**",SwingConstants.CENTER);
        themeHeading.setFont(TWLightItalic);

//        themeHeading.setSize(250,50);
//        themeHeading.setLocation(getWidth()/2-135,0);
        settings.add(themeHeading);
        Object[] data = {
                "Flat Dark","Flat Darcula","Ark Dark","Ark Dark - Orange","Carbon","Carbon 2","Dark Flat","Dark Purple","Dracula","Gradiento Dark Fuchsia","Gradiento Deep Ocean","Gradiento Midnight Blue","Gradiento Nature Green","Gruvbox Dark Hard","Gruvbox Dark Medium","Gruvbox Dark Soft","Hiberbee Dark","High Contrast","Material Design Dark","Monocai","Nord","One Dark","Solarized Dark","Spacegray","Vuesion","Arc Dark","Ark Dark Contrast","Atom One Dark","Atom One Dark Contrast","Dracula","Dracula Contrast","Github Dark","Github Dark Contrast","Material Darker","Material Darker Contrast","Material Deep Ocean","Material Deep Ocean Contrast","Material Oceanic","Material Oceanic Contrast","Material Palenight","Material Palenight Contrast","Monokai Pro","Monokai Pro Contrast","Moonlight","Moonlight Contrast","Night Owl","Night Owl Contrast","Solarized Dark","Solarized Dark Contrast"
        };
        list = new JList<>(data); //data has type Object[]
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLocation(getWidth()/2-135,30);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setVisibleRowCount(-1);
        list.setSelectedIndex(20);
        list.setSize(400,450);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(200, 450));
        settings.add(list);


        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(0,0,getWidth(),getHeight());
        tp.addTab("How to Play",help);
        tp.addTab("Theme",settings);
        helpFrame.add(tp);
        helpFrame.revalidate();
        list.addListSelectionListener(listSelectionListener);



    }
    public String getFolderDir(){
        return folderDir;
    }
    ListSelectionListener listSelectionListener = new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            System.out.print("First index: " + listSelectionEvent.getFirstIndex());
            System.out.print(", Last index: " + listSelectionEvent.getLastIndex());
            boolean adjust = listSelectionEvent.getValueIsAdjusting();
            System.out.println(", Adjusting? " + adjust);
            if (!adjust) {
                JList list = (JList) listSelectionEvent.getSource();
                int selections[] = list.getSelectedIndices();
                Object selectionValues[] = list.getSelectedValues();
                for (int i = 0, n = selections.length; i < n; i++) {
                    if (i == 0) {
                        System.out.print("  Selections: ");
                    }
                    System.out.print(selections[i] + "/" + selectionValues[i] + " ");
                    HelpFrame.super.changeTheme(selections[i]);
                }
                System.out.println();
            }
        }

    };
}

