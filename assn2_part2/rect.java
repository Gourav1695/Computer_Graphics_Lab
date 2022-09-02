import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
 
public class rect extends Applet{
 
 public void paint(Graphics g){
 
 //set color to red
 setForeground(Color.red);
 
 /*
 * to draw a filled rectangle in an applet window use,
 * void fillRect(int x1,int y1, int width, int height)
 * method.
 * 
 * This method draws a filled rectangle of specified width and
 * height at (x1,y1) 
 */
 
 //this will draw a filled rectangle of width 50 & height 100 at (10,10)
 g.fillRect(10,10,50,100);
 
 /*
 * If you speficy same width and height, the fillRect method
 * will draw a filled square!
 */
 
 //this will draw a filled square
 g.fillRect(100,100,50,50);
 }
 
}
