

import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class cir extends Applet implements ActionListener {
    int scale = 40;
    int count1 = 0;

    public void init() {
        setBackground(Color.white);
        Button b1 = new Button("Zoom In");
        Button b2 = new Button("Zoom Out");
        add(b1);
        add(b2);
        b1.addActionListener(this);
                                  
        b2.addActionListener(this);
    }

  
    public void plotPoint(double x, double y, Graphics g, Color c) {
        int newX = (getX() + getWidth()) / 2;
        //origin at (0,0)
        int newY = (getY() + getHeight()) / 2;//
        g.setColor(c);
        
            g.fillOval((int)x * scale - (int) scale  + (int)newX, (int)newY -(int) y * scale - (int) scale , (int) scale * 2,
              (int) scale * 2);// creating the circle to be ploted
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
        
       
   midCircle(g, 100, 0, 0);
        
   midCircle(g, 46, 46, 27);
   midCircle(g, 46, -46, 27);
   midCircle(g, 46, 0, -54);
   midCircle(g, 100, 0, 0);
   midCircle(g, 8, 0, 0);
   midCircle(g, 22, 0, 78);
   midCircle(g, 22, 65, -38);
   midCircle(g, 22, -65, -38);
   midCircle(g, 10, 33, 82);
   midCircle(g, 10, -33, 82);
   midCircle(g, 10, 88, -14);
   midCircle(g, 10, -88, -14);
   midCircle(g, 10, -54, -70);
   midCircle(g, 10, 54, -70);
   midCircle(g, 5, 50, 80);
   midCircle(g, 5, -50, 80);
   midCircle(g, 6, 94, 3);
   midCircle(g, 6, -94, 3);
   midCircle(g, 6, 45, -83);
   midCircle(g, 6, -45, -83);
   midCircle(g, 4, 58, 76);
   midCircle(g, 4, -58, 76);
   midCircle(g, 3, 95, 14);
   midCircle(g, 3, -95, 14);
   midCircle(g, 3, 36, -88);
   midCircle(g, 3, -36, -88);
   midCircle(g, 4, 0, 50);
   midCircle(g, 4, 42, -24);
   midCircle(g, 4, -42, -24);
   midCircle(g, 2, 65, 72);
   midCircle(g, 2, -65, 72);
   midCircle(g, 3, 95, 22);
   midCircle(g, 3, -95, 22);
   midCircle(g, 2, 31, -92);
   midCircle(g, 2, -31, -92);
   midCircle(g, 4, 23, 92);
   midCircle(g, 4, -23, 92);
   midCircle(g, 4, 91, -30);
   midCircle(g, 4, -91, -30);
   midCircle(g, 4, 69, -64);
   midCircle(g, 4, -69, -64);

    }

    
    public void midCircle(Graphics g, double r,double x_centre,
							double y_centre)
	{
		
		// int x = r, y = 0;
        double x=0, y=r;
        plotPoint(0+x_centre,r+y_centre,g,Color.red);
        plotPoint(r+x_centre,0+y_centre,g,Color.red);
        plotPoint(0+x_centre,-r+y_centre,g,Color.red);
        plotPoint(-r+x_centre,0+y_centre,g,Color.red);
	
		double P = 1 - r;
		while (x < y) {
			// Mid-point is inside or on the perimeter
			if (P < 0){
				P= P+2*x+1;
                x=x+1;
                // y = y;
                plotPoint(x+x_centre,y+y_centre,g,Color.red);
                plotPoint(-x+x_centre,y+y_centre,g,Color.red);
                plotPoint(x+x_centre,-y+y_centre,g,Color.red);
                plotPoint(-x+x_centre,-y+y_centre,g,Color.red);
                plotPoint(y+x_centre,x+y_centre,g,Color.red);
                plotPoint(-y+x_centre,x+y_centre,g,Color.red);
                plotPoint(y+x_centre,-x+y_centre,g,Color.red);
                plotPoint(-y+x_centre,-x+y_centre,g,Color.red);
                
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
                plotPoint(y+x_centre,x+y_centre,g,Color.red);
                plotPoint(-y+x_centre,x+y_centre,g,Color.red);
                plotPoint(y+x_centre,-x+y_centre,g,Color.red);
                plotPoint(-y+x_centre,-x+y_centre,g,Color.red);
                
			}
		
			if (x > y)
				break;
		
			
			System.out.print("(" + (x + x_centre)
					+ ", " + (y + y_centre) + ")");
					
			System.out.print("(" + (-x + x_centre)
					+ ", " + (y + y_centre) + ")");
					
			System.out.print("(" + (x + x_centre) +
					", " + (-y + y_centre) + ")");
					
			System.out.println("(" + (-x + x_centre)
					+ ", " + (-y + y_centre) + ")");
		
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
  

    public void actionPerformed(ActionEvent e) {
        String st = e.getActionCommand();
        if (st.equals("Zoom In"))
            scale = scale * 2;
        
        else
            scale = scale / 2;
           
        repaint();
    }
}




