//2020CSB010 GOURAV KUMAR SHAW

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class mpc extends Applet implements ActionListener {
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

  
    public void plotPoint(int x, int y, Graphics g, Color c) {
        int newX = (getX() + getWidth()) / 2;// changing the coordinate in the
        //origin at (0,0)
        int newY = (getY() + getHeight()) / 2;//
        g.setColor(c);
        g.fillOval(x * scale - (int) scale / 4 + newX -15, newY - y * scale -
        (int) scale / 2, (int) scale / 2 +30,

        (int) scale / 2 +30);// creating the circle to be ploted
            //  g.fillOval(x * scale - (int) scale / 4 + newX, newY - y * scale - (int) scale / 4, (int) scale / 2,
            //   (int) scale / 2);// creating the circle to be ploted

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
        
        // MidPointLine(1, 1, 5, 3, Color.red, g);

        midPointCircleDraw(2,2,9,g);

    }

    
    public void midPointCircleDraw(int x_centre,
							int y_centre, int r,Graphics g)
	{
		
		// int x = r, y = 0;
        int x=0, y=r;
        plotPoint(0+x_centre,r+y_centre,g,Color.red);
        plotPoint(r+x_centre,0+y_centre,g,Color.red);
        plotPoint(0+x_centre,-r+y_centre,g,Color.red);
        plotPoint(-r+x_centre,0+y_centre,g,Color.red);
	
		int P = 1 - r;
		while (x < y) {
			// Mid-point is inside or on the perimeter
			if (P < 0){
				P= P+2*x+1;
                x=x+1;
                y = y;
                plotPoint(x+x_centre,y+y_centre,g,Color.red);
                plotPoint(-x+x_centre,y+y_centre,g,Color.red);
                plotPoint(x+x_centre,-y+y_centre,g,Color.red);
                plotPoint(-x+x_centre,-y+y_centre,g,Color.red);
                plotPoint(y+y_centre,x+x_centre,g,Color.red);
                plotPoint(-y+y_centre,x+x_centre,g,Color.red);
                plotPoint(y+y_centre,-x+x_centre,g,Color.red);
                plotPoint(-y+y_centre,-x+x_centre,g,Color.red);
                
            }
			// Mid-point is outside the perimeter
			else {
				
				P = P + 2 * x - 2 * y + 1;
                x= x+1;
                y = y-1;
                plotPoint(x+x_centre,y+y_centre,g,Color.red);
                plotPoint(-x+x_centre,y+y_centre,g,Color.red);
                plotPoint(x+x_centre,-y+y_centre,g,Color.red);
                plotPoint(-x+x_centre,-y+y_centre,g,Color.red);
                plotPoint(y+y_centre,x+x_centre,g,Color.red);
                plotPoint(-y+y_centre,x+x_centre,g,Color.red);
                plotPoint(y+y_centre,-x+x_centre,g,Color.red);
                plotPoint(-y+y_centre,-x+x_centre,g,Color.red);
                
			}
		
			// All the perimeter points have already
			// been printed
			if (x > y)
				break;
		
			// Printing the generated point and its
			// reflection in the other octants after
			// translation
			System.out.print("(" + (x + x_centre)
					+ ", " + (y + y_centre) + ")");
					
			System.out.print("(" + (-x + x_centre)
					+ ", " + (y + y_centre) + ")");
					
			System.out.print("(" + (x + x_centre) +
					", " + (-y + y_centre) + ")");
					
			System.out.println("(" + (-x + x_centre)
					+ ", " + (-y + y_centre) + ")");
		
			// If the generated point is on the
			// line x = y then the perimeter points
			// have already been printed
			if (x != y) {
				
				System.out.print("(" + (y + x_centre)
					+ ", " + (x + y_centre) + ")");
					
				System.out.print("(" + (-y + x_centre)
					+ ", " + (x + y_centre) + ")");
					
				System.out.print("(" + (y + x_centre)
					+ ", " + (-x + y_centre) + ")");
					
				System.out.println("(" + (-y + x_centre)
					+ ", " + (-x + y_centre) +")");
			}
		}
    }
    // private static void plotpoint(int x, int y, Color red) {
    // }

    public void actionPerformed(ActionEvent e) {
        String st = e.getActionCommand();
        if (st.equals("Zoom In"))
            scale = scale * 2;
        else
            scale = scale / 2;
        repaint();
    }
}
// public class circle{

// }

