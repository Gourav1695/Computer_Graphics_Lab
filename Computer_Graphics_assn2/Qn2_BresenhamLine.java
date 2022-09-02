//2020CSB010 GOURAV KUMAR SHAW

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Qn2_BresenhamLine extends Applet implements ActionListener {
    int scale = 40;

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
       
        BresenhamLine(5, -5, 25, 50, Color.red, g);

    }

    public void BresenhamLine(int x0, int y0, int x4, int y4, Color c, Graphics g) {
        int dy = y4 - y0;
        int dx = x4 - x0;
        int x = x0;
        int y = y0;
        double m = Math.abs((y4 - y0) / (x4 - x0));
        if (m < 1) {
            int p = 2 * dy - dx;
            while (x <= x4) {
                System.out.println(x + "," + y + "\n");
                if (p >= 0) {
                    plotPoint(x, y, 143, 0, 255, g);
                    y = y + 1;
                    p = p + 2 * dy - 2 * dx;
                } else {
                    plotPoint(x, y, 143, 0, 255, g);
                    p = p + 2 * dy;
                }
                x = x + 1;

            }

        } else {
            int p = 2 * dx - dy;
            while (y <= y4) {
                System.out.println(x + "," + y + "\n");

                if (p >= 0) {
                    plotPoint(x, y, 143, 0, 255, g);
                    x = x + 1;
                    p = p + 2 * dx - 2 * dy;
                } else {
                    plotPoint(x, y, 143, 0, 255, g);
                    p = p + 2 * dx;
                }
                y = y + 1;

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
