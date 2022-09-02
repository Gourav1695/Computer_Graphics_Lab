//2020CSB010 GOURAV KUMAR SHAW

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Qn1 extends Applet implements ActionListener {
    int scale = 40;
    int temp=1;
    // boolean flame;

    public void init() {
        setBackground(Color.white);
        Button b1 = new Button("Zoom In");// Making the Button
        Button b2 = new Button("Zoom Out");// Making the Button
        Button b3 = new Button("Toggle Flame");// Making the Button
        add(b1);
        add(b2);
        add(b3);
        b1.addActionListener(this);// adding the action Listener to allow the interface to increase or decrease
                                   // with the clicking the button of Zoom In or Zoon Out
        b2.addActionListener(this);// same as above
        b3.addActionListener(this);// same as above
       
    }
    // @Override
    public void plotPoint(int x, int y, Graphics g, Color c) {
        int newX = (getX() + getWidth()) / 2;// changing the coordinate in the origin at (0,0)
        int newY = (getY() + getHeight()) / 2;// same as above
        g.setColor(c);
        // g.fillOval(x*scale - (int)scale/4+newX,newY-y*scale - (int)scale /2,
        // (int)scale /2);
        g.fillOval(x * scale - (int) scale / 4 + newX -15, newY - y * scale - (int) scale / 2, (int) scale / 2 +30,
                (int) scale / 2 +30);// creating the circle to be ploted
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
        // g.setColor(Color.blue);
        // g.fillRect(x-40, y+40, 80, 300);
         // rectangle by DDA line drawing
        DDALine1(1, -2, 1, -14, g,Color.blue);
        DDALine1(-1, -14, 1, -14, g,Color.blue);
        DDALine1(-1, -2, -1, -14, g,Color.blue);
        DDALine1(-1, -2, +1, -2, g,Color.blue);
        DDALine1(0, -2, 0, -14, g,Color.blue);
        // setForeground(Color.red);
        // DDALine(1, 2, 4, -2, g);
        if(temp==1){

        //red 
       for(int i=0; i<3;i++){
        DDALine(0, 0, 3+i, 2+i,g, Color.red);
        DDALine(0, 0, 1+i, 5+i, g,Color.red);
        DDALine(0, 0, 0+i, 6+i, g,Color.red);
        DDALine(0, 0, -1+i, 4+i, g,Color.red);
        DDALine(0, 0, -2+i, 3+i, g,Color.red);
        DDALine(0, 0, 0+i, 9+i, g,Color.red);
        DDALine(0, 0, 3+i, 6+i, g,Color.red);
        DDALine(0, 0, -1+i, 6+i, g,Color.red);
        DDALine(0, 0, -1+i, 5+i, g,Color.red);
        DDALine(0, 0, -2+i, 4+i, g,Color.red);
        DDALine(0, 0, 2+i, 8+i, g,Color.red);
        DDALine(0, 0, 1+i, 8+i, g,Color.red);
        DDALine(0, 0, 3+i, 4+i, g,Color.red);
        DDALine(0, 0, 3+i, 3+i, g,Color.red);


        //orange
        DDALine(0, 0, 2+i, 1+i,g, Color.orange);
        DDALine(0, 0, 1+i, 3+i, g,Color.orange);
        DDALine(0, 0, 0+i, 4+i, g,Color.orange);
        DDALine(0, 0, -1+i, 3+i, g,Color.orange);
        DDALine(0, 0, -2+i, 1+i, g,Color.orange);
        DDALine(0, 0, 0+i, 6+i, g,Color.orange);
        DDALine(0, 0, 2+i, 3+i, g,Color.orange);
        DDALine(0, 0, -1+i, 4+i, g,Color.orange);
        DDALine(0, 0, -1+i, 3+i, g,Color.orange);
        DDALine(0, 0, -2+i, 2+i, g,Color.orange);
        DDALine(0, 0, 2+i, 5+i, g,Color.orange);
        DDALine(0, 0, 1+i, 6+i, g,Color.orange);

        //yellow

        DDALine(0, 0, 2+i, 1+i,g, Color.yellow);
        DDALine(0, 0, 1+i, 1+i, g,Color.yellow);
        DDALine(0, 0, 0+i, 2+i, g,Color.yellow);
        DDALine(0, 0, -1+i, 2+i, g,Color.yellow);
        DDALine(0, 0, -2+i, 1+i, g,Color.yellow);
        DDALine(0, 0, 0+i, 4+i, g,Color.yellow);
        DDALine(0, 0, 2, 2, g,Color.yellow);
        DDALine(0, 0, -1+i, 2+i, g,Color.yellow);
        DDALine(0, 0, -1+i, 3+i, g,Color.yellow);
        DDALine(0, 0, -2+i, 2+i, g,Color.yellow);
        DDALine(0, 0, 2+i, 3+i, g,Color.yellow);
        DDALine(0, 0, 1+i, 3+i, g,Color.yellow);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        repaint();
       
       }
        }
         // rectangle by DDA line drawing
        // DDALine1(1, -1, 1, -10, g,Color.blue);
        // DDALine1(-1, -10, 1, -10, g,Color.blue);
        // DDALine1(-1, -1, -1, -10, g,Color.blue);
        // DDALine1(-1, -1, +1, -1, g,Color.blue);
        // DDALine1(0, -1, 0, -10, g,Color.blue);
        
        //for rectangle
        // g.setColor(Color.blue);
        // g.fillRect(x-40, y+40, 80, 300);

    }
    // public void paint1(Graphics g) {
        
    // }
    // @Override
    public void plotPoint1(int x, int y, Graphics g, Color c) {// 
        int newX = (getX() + getWidth()) / 2;// changing the coordinate in the origin at (0,0)
        int newY = (getY() + getHeight()) / 2;// same as above
        g.setColor(c);
        // g.fillOval(x*scale - (int)scale/4+newX,newY-y*scale - (int)scale /2,
        // (int)scale /2);
        g.fillRect(x * scale - (int) scale / 4 + newX -15, newY - y * scale - (int) scale / 2, (int) scale / 2 +30,
                (int) scale / 2 +30);// creating the rectangle to be ploted
    }

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
    public void DDALine1(int x0, int y0, int x1, int y1, Graphics g, Color c) {

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
            plotPoint1(round(x), round(y),  g, c);// for rectangle point
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
        else if (st.equals("Zoom Out")){
            if(scale>5)
            scale = scale / 2;
        }
        else
            if (temp==1)
                temp=0;
                else
                temp=1;
                repaint();

        repaint();
    }
}
