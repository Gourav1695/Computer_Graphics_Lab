
    // public void MidPointLine(int x, int y, int x2, int y2, Color c, Graphics g) {
    //     double dy = y2 - y;
    //     double dx = x2 - x;
    //     // int x = x;
    //     // int y = y;
    //     double m = (dy / dx);

    //     if (m < 1) {

    //         double p = (1 / 2) - m;
            
    //         while (x <= x2) {

    //             if (p >= 0) {

    //                 System.out.println(x + "," + y + "\n");
    //                 plotPoint(x, y, 255, 0, 0, g);
    //                 x = x + 1;
    //                 p = p - m;
    //                 // y = y;

    //             } else {
    //                 System.out.println(x + "," + y + "\n");
    //                 plotPoint(x, y, 255, 0, 0, g);
    //                 x = x + 1;
    //                 p = p + 1 - m;
    //                 y = y + 1;
    //             }

    //         }

    //     } else {
    //         double p = 1 - (m / 2);
    //         while (y <= y2) {
    //             System.out.println(x + "," + y + "\n");

    //             if (p >= 0) {
    //                 plotPoint(x, y, 255, 0, 0, g);
    //                 x = x + 1;
    //                 p = p + 1 - m;
    //                 y = y + 1;
    //             } else {
    //                 plotPoint(x, y, 255, 0, 0, g);
    //                 p = p + 1;
    //                 y = y + 1;

    //             }
    //             // y = y + 1;

    //         }

    //     }

    // }