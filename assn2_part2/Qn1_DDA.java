//2020CSB010 GOURAV KUMAR SHAW

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Qn1_DDA extends Applet implements ActionListener {
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
    // @Override
    public void plotPoint(int x, int y, Graphics g, Color c) {
        int newX = (getX() + getWidth()) / 2;// changing the coordinate in the origin at (0,0)
        int newY = (getY() + getHeight()) / 2;// same as above
        g.setColor(c);
        g.fillOval(x*scale - (int)scale/4 + newX-15 ,newY-y*scale - (int)scale /2, (int)scale /2 + 30,(int)scale/2 + 30);
        // g.fillOval(x * scale - (int) scale / 4 + newX, newY - y * scale - (int) scale / 4, (int) scale / 2,
                // (int) scale / 2);// creating the circle to be ploted
                // g.fillO
                // int x, int y, int width,int height
    }
@Override
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
        // setForeground(Color.red);
        // DDALine(1, 2, 4, -2, g);
        DDALine(0, 0, -3, 3,g, Color.yellow);
        DDALine(0, 0, 3, 3, g,Color.yellow);
        DDALine(0, 0, 4, 4, g,Color.CYAN);
        DDALine(0, 0, -4, 4, g,Color.yellow);
        DDALine(0, 0, -3, 5, g,Color.orange);
        DDALine(0, 0, 3, 5, g,Color.orange);
        DDALine(0, 0, 1, 6, g,Color.orange);
        DDALine(0, 0, 2, 6, g,Color.orange);
        DDALine(0, 0, -1, 6, g,Color.orange);
        DDALine(0, 0, -2, 6, g,Color.orange);
        DDALine(0, 0, -2, 6, g,Color.orange);
        DDALine(0, 0, 0, 7, g,Color.orange);

        
        //for rectangle
        DDALine(1, 0, 1, -10, g,Color.blue);
        DDALine(-1, -10, 1, -10, g,Color.blue);
        DDALine(-1, 0, 1, 0, g,Color.blue);
        DDALine(-1, 0, -1, -10, g,Color.blue);
        DDALine(0, 0, 0, -10, g,Color.blue);




        // g.fillRect(50, 50, 50, 100);

    }
    // public void paint1(Graphics g) {
    //     DDALine(1, 0, 1, -10, g);
    //     DDALine(-1, -10, 1, -10, g);
    //     DDALine(-1, 0, 1, 0, g);
    //     DDALine(-1, 0, -1, -10, g);
    // }

    public int round(float n) {
        if (n - (int) n < 0.5)
            return (int) n;
        return (int) (n + 1);
    }
   

    public void DDALine(int x0, int y0, int x1, int y1, Graphics g, Color c) {

        // calculate dx and dy
        int dx = x1 - x0;
        int dy = y1 - y0;

        int step;

        // if dx > dy we will take step as dx
        // else we will take step as dy to draw the complete line
        if (Math.abs(dx) > Math.abs(dy))
            step = Math.abs(dx);
        else
            step = Math.abs(dy);

        // calculate x-increment and y-increment for each step
        float x_incr = (float) dx / step;
        float y_incr = (float) dy / step;

        // take the initial points as x and y
        float x = x0;
        float y = y0;

        for (int i = 0; i <= step; i++) {
            // plot(x, y, 255,0,0, g);
            // new Color(0, 0, 0)
            plotPoint(round(x), round(y),  g, c);
            System.out.println(x + "," + y + "\n");
            // putpixel(round(x), round(y), WHITE);
            // cout << round(x) << " " << round(y) << "\n";
            x += x_incr;
            y += y_incr;
            // delay(10);
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
