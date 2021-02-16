/*
 * This program simply draws the ASCII characters on the console
 * Sources:
 *  * https://en.wikipedia.org/wiki/ASCII_art
 *  * https://stackoverflow.com/questions/7098972/ascii-art-java
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int w = 100;
        int h = 40;
        int px = 10;        // image position in x axis
        int py = 30;        // image position in y axis
        /*
         * To have the image's RGB color represented as an integer
         * we set the image type to integer mode:
         */
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        g.setFont(new Font("SansSerif", Font.ITALIC, 15));
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2D.drawString(text,px,py);

        for (int y=0; y<h; ++y) {
            // creates empty string
            StringBuilder sb = new StringBuilder();
            for (int x=0; x<w; ++x) {
                /*
                 * The red, green and blue use 8 bits each, which have integer values from 0 to 255.
                 * This makes 256*256*256=16777216 possible colors
                 * Replace the values assigned to non-zero indices of image matrix with "*"
                 * Zero indices are replace with spaces i.e " "
                 * Zero equivalent for integer mode is -16777216
                 */
                sb.append(img.getRGB(x,y) == -16777216 ? " " : "*");
            }
            if (sb.toString().trim().isEmpty()) continue;
            System.out.println(sb);
        }
    }
}