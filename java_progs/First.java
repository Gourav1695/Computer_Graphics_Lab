// 1.Develop a class 'First' that uses object of another class 'Second' using default package 

package PACK1;

import PACK1.PACK2.Second;

import PACK1.PACK2.PACK3.Third;
import PACK_D.Second_D;

public class First {
    public static void main(String args[]) {
        System.out.println("In First main()");
        Second p = new Second();
        p.f();
        Third p1=new Third();
        p1.f22();
        Second_D d =new Second_D();
        d.fd();
        d.f();

    }
}