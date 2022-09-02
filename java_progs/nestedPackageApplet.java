//6. Develop an applet program using user defined package and user defined nested package(part 2)

package PACK_APL.PACK_APL2;

import java.applet.*;
import java.awt.*;

public class nestedPackageApplet extends Applet {
    public void init() {
        this.setSize(new Dimension(800, 600));
        setBackground(Color.RED);
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.drawString("Nested Package Applet", 100, 100);
    }
}