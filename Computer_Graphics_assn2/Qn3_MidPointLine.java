//2020CSB010 GOURAV KUMAR SHAW

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Qn3_MidPointLine extends Applet implements ActionListener {
    int scale = 40;
    int count1 = 0;

    public void init() {
        setBackground(Color.white);
        Button b1 = new Button("Zoom In");// Making the Button
        Button b2 = new Button("Zoom Out");// Making the Button
        add(b1);
        add(b2);
        b1.addActionListener(this);// adding the action Listener to allow the interface to increase or decrease
                                   // with the clicking the button of Zoom In or Zoon Out
        b2.addActionListener(this);// same as above
    }

    public void plotPoint(int x, int y, int r, int gr, int b, Graphics g) {
        int newX = (getX() + getWidth()) / 2;// changing the coordinate in the origin at (0,0)
        int newY = (getY() + getHeight()) / 2;// same as above
        Color myColor = new Color(r, gr, b);
        g.setColor(myColor);
        // g.fillOval(x*scale - (int)scale/4+newX,newY-y*scale - (int)scale /2,
        // (int)scale /2);
        g.fillOval(x * scale - (int) scale / 4 + newX, newY - y * scale - (int) scale / 4, (int) scale / 2,
                (int) scale / 2);// creating the circle to be ploted
    }

    public void paint(Graphics g) {
        int x = (getX() + getWidth()) / 2;// changing the coordinate to the (0,0) base coordinate
        int y = (getY() + getHeight()) / 2;
        g.setColor(Color.red); // drawing the main coordinate for x and y
        g.drawLine(x, 0, x, getHeight());// x-axis as x value is changing
        g.drawLine(0, y, getWidth(), y);// y-axis as y value is changing
        g.setColor(Color.black);

        for (int i = x + scale; i < getWidth(); i += scale) {
            g.drawLine(i, 0, i, getHeight());
        }
        for (int i = scale; i < getWidth(); i += scale) {
            g.drawLine(x - i, 0, x - i, getHeight());
        }
        for (int i = y + scale; i < getHeight(); i += scale) {
            g.drawLine(0, i, getWidth(), i);
        }
        for (int i = scale; i < getHeight(); i += scale) {
            g.drawLine(0, y - i, getWidth(), y - i);
        }
        
        MidPointLine(1, 1, 5, 3, Color.red, g);
 

    }

    public void MidPointLine(int x, int y, int x2, int y2, Color c, Graphics g) {
        double dy = y2 - y;
        double dx = x2 - x;
        // int x = x;
        // int y = y;
        double m = (dy / dx);

        if (m < 1) {

            double p = (1 / 2) - m;
            
            while (x <= x2) {

                if (p >= 0) {

                    System.out.println(x + "," + y + "\n");
                    plotPoint(x, y, 252, 3, 169, g);
                    x = x + 1;
                    p = p - m;
                    // y = y;

                } else {
                    System.out.println(x + "," + y + "\n");
                    plotPoint(x, y, 252, 3, 169, g);
                    x = x + 1;
                    p = p + 1 - m;
                    y = y + 1;
                }

            }

        } else {
            double p = 1 - (m / 2);
            while (y <= y2) {
                System.out.println(x + "," + y + "\n");

                if (p >= 0) {
                    plotPoint(x, y, 252, 3, 169, g);
                    x = x + 1;
                    p = p + 1 - m;
                    y = y + 1;
                } else {
                    plotPoint(x, y, 252, 3, 169, g);
                    p = p + 1;
                    y = y + 1;

                }
                // y = y + 1;

            }

        }

    }

    public void actionPerformed(ActionEvent e) {
        String st = e.getActionCommand();
        if (st.equals("Zoom In"))
            scale = scale * 2;
        else
            scale = scale / 2;
        repaint();
    }
}
