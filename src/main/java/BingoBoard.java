import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import javax.swing.*;


public class BingoBoard extends JPanel {
    public static final int PAGEWID = 1100;
    public static final int PAGEHIH = 1325;
    public static final String IMGTYPE = "png";
    private Font TWBlack, TWBold, GSBold, DMRegular, DMItalic, JBExtraBold, TWBoldItalic, TWExtraLight, TWExtraLightItalic, TWItalic, TWLight, TWLightItalic, TWRegular, TWSemiBold, TWSemiBoldItalic;
    private BingoCard bc;
    private int count;
    private BufferedImage cardImage;
    private JPanel p;
    private JFrame f;
    private BingoCardObj[] bingoCardObjs;
    private ArrayList<BingoCardObj2> cards;
    ArrayList<String> files;
    private int seed, amount;
    private String formattedDate, dir;
    private Dimension size;
    private String cardsDir;
    private JProgressBar progressBar;
    private static int max;

    public BingoBoard(int s, int a, int w, int d) throws IOException {
//        progressBar = jp;
        seed = s;
        amount = a;
        count = 0;
        try {

            JBExtraBold = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("JetBrainsMono-ExtraBold.ttf")).deriveFont(120f);
            DMItalic = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("DankMono-Italic.ttf")).deriveFont(40f);
            DMRegular = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("DankMono-Regular.ttf")).deriveFont(80f);
            GSBold = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("Gill Sans Bold.otf")).deriveFont(12f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            ge.registerFont(JBExtraBold);
            ge.registerFont(DMItalic);
            ge.registerFont(DMRegular);
            ge.registerFont(GSBold);
        } catch (IOException | FontFormatException e) {
            System.out.println("Error");
        }
        try {
            bc = new BingoCard(seed, a,w);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("error");
        }
        bingoCardObjs = bc.getBingoCards();
        files = new ArrayList<String>();
        paint(getGraphics());

        GameResults gameResults = new GameResults(bc,d,seed);

        if(amount>=1000) {
            ExecutorService executor = java.util.concurrent.Executors.newSingleThreadExecutor();
            executor.submit(() -> {

                String outputFile = "BingoCards/output"+((amount/1000)+1)+".pdf";
                File dest = new File(outputFile);
                try {
                    dest.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PdfWriter writer = null;
                try {
                    writer = new PdfWriter(dest);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                PdfDocument pdfDoc = new PdfDocument(writer);
                pdfDoc.addNewPage();
                Document document = new Document(pdfDoc);
                for (String f : files.subList(((amount/4)-((amount/4)%250)), files.size())) {
                    ImageData data = null;
                    try {
                        data = ImageDataFactory.create(f);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    Image img = new Image(data);
                    document.add(img);
                }
                document.close();
            });
            int cards = files.size();
            System.out.print(cards);
            for (int i = 1, j = 1; i < cards - (cards % 250); i += 250, j++) {
                String outputFile = "BingoCards/output" + j + ".pdf";
                File dest = new File(outputFile);
                dest.createNewFile();
                PdfWriter writer = new PdfWriter(dest);
                PdfDocument pdfDoc = new PdfDocument(writer);
                pdfDoc.addNewPage();
                Document document = new Document(pdfDoc);
                for (String f : files.subList(i - 1, i + 249)) {
                    ImageData data = ImageDataFactory.create(f);
                    Image img = new Image(data);
                    document.add(img);
                }
                document.close();
            }

        }
        else {
            String outputFile = "BingoCards/output.pdf";
            File dest = new File(outputFile);
            dest.createNewFile();
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdfDoc = new PdfDocument(writer);
            pdfDoc.addNewPage();
            Document document = new Document(pdfDoc);
            for (String f : files) {
                ImageData data = ImageDataFactory.create(f);
                Image img = new Image(data);
                document.add(img);
            }
            document.close();
        }







    }

    public void makePage(Graphics g2, BufferedImage image) {
        Graphics2D g2d = (Graphics2D) g2;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        int[][] board;
        g2.setColor(new Color(59, 66, 82));
        g2.fillRect(0, 0, 500, 625);
        g2.setColor(new Color(229, 233, 240));
        g2.setFont(GSBold);
        g2.drawString("#" + (count + 1), 0, 620);
        g2.setColor(new Color(76, 86, 106));
        g2.fillRect(0, 100, 500, 500);
        g2.setColor(new Color(67, 76, 94));
        g2.fillRect(0, 200, 100, 100);
        g2.fillRect(0, 400, 100, 100);
        g2.fillRect(100, 100, 100, 100);
        g2.fillRect(100, 300, 100, 100);
        g2.fillRect(100, 500, 100, 100);
        g2.fillRect(200, 200, 100, 100);
        g2.fillRect(200, 400, 100, 100);
        g2.fillRect(300, 100, 100, 100);
        g2.fillRect(300, 300, 100, 100);
        g2.fillRect(300, 500, 100, 100);
        g2.fillRect(400, 200, 100, 100);
        g2.fillRect(400, 400, 100, 100);
        g2.setColor(new Color(229, 233, 240));
        g2.setFont(JBExtraBold);
        g2.drawString("B", 13, 93);
        g2.drawString("I", 113, 93);
        g2.drawString("N", 213, 93);
        g2.drawString("G", 313, 93);
        g2.drawString("O", 410, 93);
        g2.setFont(DMItalic);
        g2.drawString("FREE", 205, 365);
        board = bingoCardObjs[count].getBoard();
        for (int i = 0; i < 5; i++) {
            for (int x = 1; x < 6; x++) {
                if (!(i == 2 && x == 3))
                    g2.drawString(String.valueOf(board[x - 1][i]), ((i) * 100) + 5, (x * 100) + 78);
            }
        }
        count++;

        g2.setColor(new Color(59, 66, 82));
        g2.fillRect(600, 0, 500, 625);
        g2.setColor(new Color(229, 233, 240));
        g2.setFont(GSBold);
        g2.drawString("#" + (count + 1), 600, 620);
        g2.setColor(new Color(76, 86, 106));
        g2.fillRect(600, 100, 500, 500);
        g2.setColor(new Color(67, 76, 94));
        g2.fillRect(600, 200, 100, 100);
        g2.fillRect(600, 400, 100, 100);
        g2.fillRect(700, 100, 100, 100);
        g2.fillRect(700, 300, 100, 100);
        g2.fillRect(700, 500, 100, 100);
        g2.fillRect(800, 200, 100, 100);
        g2.fillRect(800, 400, 100, 100);
        g2.fillRect(900, 100, 100, 100);
        g2.fillRect(900, 300, 100, 100);
        g2.fillRect(900, 500, 100, 100);
        g2.fillRect(1000, 200, 100, 100);
        g2.fillRect(1000, 400, 100, 100);
        g2.setColor(new Color(229, 233, 240));
        g2.setFont(JBExtraBold);
        g2.drawString("B", 613, 93);
        g2.drawString("I", 713, 93);
        g2.drawString("N", 813, 93);
        g2.drawString("G", 913, 93);
        g2.drawString("O", 1010, 93);
        g2.setFont(DMItalic);
        g2.drawString("FREE", 805, 365);
        board = bingoCardObjs[count].getBoard();
        for (int i = 0; i < 5; i++) {
            for (int x = 1; x < 6; x++) {
                if (!(i == 2 && x == 3))
                    g2.drawString(String.valueOf(board[x - 1][i]), ((i) * 100) + 605, (x * 100) + 78);
            }
        }
        count++;


        g2.setColor(new Color(59, 66, 82));
        g2.fillRect(0, 700, 500, 625);
        g2.setColor(new Color(229, 233, 240));
        g2.setFont(GSBold);
        g2.drawString("#" + (count + 1), 0, 1320);
        g2.setColor(new Color(76, 86, 106));
        g2.fillRect(0, 800, 500, 500);
        g2.setColor(new Color(67, 76, 94));
        g2.fillRect(0, 900, 100, 100);
        g2.fillRect(0, 1100, 100, 100);
        g2.fillRect(100, 800, 100, 100);
        g2.fillRect(100, 1000, 100, 100);
        g2.fillRect(100, 1200, 100, 100);
        g2.fillRect(200, 900, 100, 100);
        g2.fillRect(200, 1100, 100, 100);
        g2.fillRect(300, 800, 100, 100);
        g2.fillRect(300, 1000, 100, 100);
        g2.fillRect(300, 1200, 100, 100);
        g2.fillRect(400, 900, 100, 100);
        g2.fillRect(400, 1100, 100, 100);
        g2.setColor(new Color(229, 233, 240));
        g2.setFont(JBExtraBold);
        g2.drawString("B", 13, 793);
        g2.drawString("I", 113, 793);
        g2.drawString("N", 213, 793);
        g2.drawString("G", 313, 793);
        g2.drawString("O", 410, 793);
        g2.setFont(DMItalic);
        g2.drawString("FREE", 205, 1065);
        board = bingoCardObjs[count].getBoard();
        for (int i = 0; i < 5; i++) {
            for (int x = 1; x < 6; x++) {
                if (!(i == 2 && x == 3))
                    g2.drawString(String.valueOf(board[x - 1][i]), ((i) * 100) + 5, (x * 100) + 778);
            }
        }
        count++;


        g2.setColor(new Color(59, 66, 82));
        g2.fillRect(600, 700, 500, 625);
        g2.setColor(new Color(229, 233, 240));
        g2.setFont(GSBold);
        g2.drawString("#" + (count + 1), 600, 1320);
        g2.setColor(new Color(76, 86, 106));
        g2.fillRect(600, 800, 500, 500);
        g2.setColor(new Color(67, 76, 94));
        g2.fillRect(600, 900, 100, 100);
        g2.fillRect(600, 1100, 100, 100);
        g2.fillRect(700, 800, 100, 100);
        g2.fillRect(700, 1000, 100, 100);
        g2.fillRect(700, 1200, 100, 100);
        g2.fillRect(800, 900, 100, 100);
        g2.fillRect(800, 1100, 100, 100);
        g2.fillRect(900, 800, 100, 100);
        g2.fillRect(900, 1000, 100, 100);
        g2.fillRect(900, 1200, 100, 100);
        g2.fillRect(1000, 900, 100, 100);
        g2.fillRect(1000, 1100, 100, 100);
        g2.setColor(new Color(229, 233, 240));
        g2.setFont(JBExtraBold);
        g2.drawString("B", 613, 793);
        g2.drawString("I", 713, 793);
        g2.drawString("N", 813, 793);
        g2.drawString("G", 913, 793);
        g2.drawString("O", 1010, 793);
        g2.setFont(DMItalic);
        g2.drawString("FREE", 805, 1065);
        board = bingoCardObjs[count].getBoard();
        for (int i = 0; i < 5; i++) {
            for (int x = 1; x < 6; x++) {
                if (!(i == 2 && x == 3))
                    g2.drawString(String.valueOf(board[x - 1][i]), ((i) * 100) + 605, (x * 100) + 778);
            }
        }
        count++;


        try {
            ImageIO.write(image, "png", new File(dir + "/card" + (count / 4) + ".png"));
            files.add(dir + "/card" + (count / 4) + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Done");


    }

    private void PDF(){
        int complete = amount/4;
        new File("BingoCards").mkdirs();
        try{
            int pos=0;
            for(int i=0; i<complete; i++){
                BufferedImage image = new BufferedImage(2048, 1536, BufferedImage.TYPE_INT_ARGB);
                Graphics g = image.getGraphics();
                for(int r=0; r<= 700&&pos<bingoCardObjs.length; r+=700){
                    for(int c=0; c<=700; c+=700 ) {
                        g.drawImage(cards.get(pos).getImage(), c, r, null);
                        pos++;
                    }
                }
                ImageIO.write(image, "png", new File("BingoCards/"+(i+1)+ ".png"));
            }
            if(complete*4!=amount){
                BufferedImage image = new BufferedImage(2550, 3300, BufferedImage.TYPE_INT_ARGB);
                Graphics g = image.getGraphics();
                for (int r = 0; r <= 700; r += 700) {
                    for (int c = 0; c <= 700&&pos<cards.size(); c += 700) {
                        g.drawImage(cards.get(pos).getImage(), c, r, null);
                        pos++;
                    }
                }
                ImageIO.write(image, "png", new File("BingoCards/" + (complete + 1) + ".png"));
            }
        }
        catch(Exception e){e.printStackTrace();}
    }
    private BufferedImage createOutline(){
        try {
            BufferedImage image = new BufferedImage(600, 700, BufferedImage.TYPE_INT_ARGB);
            Graphics g = image.getGraphics();
            int i = 0;

            g.setColor(new Color(255, 216, 102));
            g.fillRect(100,0,500,150);
            g.setColor(new Color(229, 233, 240));
            g.setFont(JBExtraBold);
            g.drawString("B", 120, 95);
            g.drawString("I", 235, 95);
            g.drawString("N", 318, 95);
            g.drawString("G", 418, 95);
            g.drawString("O", 517, 95);
            g.setFont(GSBold);
            g.setColor(new Color(229, 233, 240));
            g.drawString("#" + (count + 1), 600, 620);
            for(int r=0; r<500; r+=100){
                for(int c=100; c<=500; c+=100){
                    if(i==0){
                        g.setColor(new Color(76, 86, 106));
                        g.fillRect(r, c, 100, 100);
                        //System.out.println("x: " + r + " y: " + c);
                        i++;
                    }
                    else if(i==1){
                        g.setColor(new Color(67, 76, 94));
                        g.fillRect(r, c, 100, 100);
                        i--;
                    }
                }
            }
            return image;

//            ImageIO.write(image, "png", new File("BingoBoard.png"));
//            System.out.println("Done");
        }
        catch(Exception e){return null;}
    }
    private void createCard(){
        try {
            BufferedImage image = createOutline();
            Graphics g = image.getGraphics();
            g.setFont(DMItalic);
            int[][] board = bingoCardObjs[count].getBoard();
            for (int i = 0; i < 5; i++) {
                for (int x = 1; x < 6; x++) {
                    if (!(i == 2 && x == 3))
                        g.drawString(String.valueOf(board[x - 1][i]), ((i) * 100) + 5, (x * 100) + 78);
                }
            }
            g.setColor(new Color(76, 86, 106));
            g.fillRect(200, 300, 100, 100);
            g.setColor(new Color(229, 233, 240));
            g.setFont(DMItalic);
            g.drawString("FREE", 325, 360);
//            new File("C:\\Users\\Cyric\\Downloads\\BingoProjectTest\\BingoCards1").mkdirs();
//            ImageIO.write(image, "png", new File("C:\\Users\\Cyric\\Downloads\\BingoProjectTest\\BingoCards1/"+i+ ".png"));
            System.out.println(count + " Done");
            count++;
            cardImage = image;
        }
        catch(Exception e){e.printStackTrace();}

    }


//    public void export() {
//
//        //joins 4 per page
//        final int PAGECT = (cards.size() + 3)/4;
//        BufferedImage pages[] = new BufferedImage[PAGECT];
//        int pageno = 0;
//
//        for(int i = 4; i < bingoCardObjs.length ; i += 4)
//        {
//            Raster i1 = cards.get(i - 4).getCard(i - 4).getData(),
//                    i2 = cards.get(i - 3).getCard(i - 3).getData(),
//                    i3 = cards.get(i - 2).getCard(i - 2).getData(),
//                    i4 = cards.get(i - 1).getCard(i - 1).getData();
//
//            BufferedImage page = new BufferedImage(
//                    PAGEWID,
//                    PAGEHIH,
//                    BufferedImage.TYPE_INT_ARGB);
//            WritableRaster wr = page.getRaster();
//
//            wr.setRect(0, 0, i1);
//            wr.setRect(PAGEWID / 2, 0, i2);
//            wr.setRect(0, PAGEHIH / 2, i3);
//            wr.setRect(PAGEWID / 2, PAGEHIH / 2, i4);
//
//            pages[pageno] = page;
//
//            pageno++;
//        }
//
//        //last page if pagect not divisible by 4
//        if(PAGECT * 4 != bingoCardObjs.length)
//        {
//            BufferedImage page = new BufferedImage(
//                    PAGEWID,
//                    PAGEHIH,
//                    BufferedImage.TYPE_INT_ARGB);
//            WritableRaster wr = page.getRaster();
//
//            int lastCard = bingoCardObjs.length - 1;
//            switch(bingoCardObjs.length % 4)
//            {
//                case 3:
//                    Raster i3 = cards.get(lastCard).getCard(lastCard).getData();
//                    wr.setRect(0, PAGEHIH / 2, i3);
//                    lastCard--;
//                case 2:
//                    Raster i2 = cards.get(lastCard).getCard(lastCard).getData();
//                    wr.setRect(PAGEWID / 2, 0, i2);
//                    lastCard--;
//                case 1:
//                    Raster i1 = cards.get(lastCard).getCard(lastCard).getData();
//                    wr.setRect(0, 0, i1);
//            }
//
//            pages[pageno] = page;
//        }
//
//        //print
//        PrinterJob job = PrinterJob.getPrinterJob();
//        job.setPrintable(new Printable(){
//            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException
//            {
//                if(pageIndex >= PAGECT)
//                    return NO_SUCH_PAGE;
//                graphics.drawImage(pages[pageIndex], (int)pageFormat.getImageableX(), (int)pageFormat.getImageableY(),
//                        (int)pageFormat.getImageableWidth(), (int)pageFormat.getImageableHeight(), null);
//                return PAGE_EXISTS;
//            }
//        });
//        if(job.printDialog())
//            try {
//                job.print();
//            } catch (PrinterException e) {
//                e.printStackTrace();
//            }
//    }

    public void paint(Graphics g) {
        BufferedImage image = new BufferedImage(1100, 1325, BufferedImage.TYPE_INT_ARGB);
        Graphics g2 = image.getGraphics();
        LocalDateTime localDate = LocalDateTime.now(); // Create a date object
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        formattedDate = localDate.format(myFormatObj);
        System.out.println(formattedDate);
        dir = "BingoCards/cards";
        File theDir = new File(dir);
        theDir.mkdirs();


        for (int i = 0; i < amount; i += 4) {
            makePage(g2, image);
            System.out.println(i);
        }

//        for (int i = 0; i < amount; i += 4) {
//            BingoCardObj2 bingoCardObj2 = new BingoCardObj2(count,)
//            System.out.println(i);
//        }

    }
}
