import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Qn1 extends Applet implements ActionListener
{
        int scale=40;


	
        public void plot(int x, int y, int r, int gr, int b, Graphics g){
                int newX = (getX()+getWidth())/2;
                int newY = (getY()+getHeight())/2;
                Color myColor = new Color(r,gr,b);
                g.setColor(myColor);
                g.fillOval(x*scale - (int)scale/4 +newX,newY-y*scale - (int)scale/4,(int)scale/2,(int)scale/2); 
        }

	public void paint(Graphics g)
	{  
                int x =( getX()+getWidth())/2;
                int y = (getY()+getHeight())/2;
                g.setColor(Color.red);
                g.drawLine(x,0,x,getHeight());
                g.drawLine(0,y,getWidth(),y);
                g.setColor(Color.black); 
                for(int i=x+scale; i<getWidth(); i+=scale){
                g.drawLine(i,0,i,getHeight());
                }
                for(int i=scale; i<getWidth(); i+=scale){
                g.drawLine(x-i,0,x-i,getHeight());
                }
               for(int i=y+scale; i<getHeight(); i+=scale){
                g.drawLine(0,i,getWidth(),i);
                }
               for(int i=scale; i<getHeight(); i+=scale){
                g.drawLine(0,y-i,getWidth(),y-i);
                }
             
                // plot(0,0,255,0,0,g);
                plot(2,3,0,255,0,g);

        
	}

        public void actionPerformed(ActionEvent e) {
                String st = e.getActionCommand();
                if(st.equals("Zoom In"))
                scale=scale*2;
                else
                scale=scale/2;
                repaint();
        }
}