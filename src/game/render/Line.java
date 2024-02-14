package game.render;

import game.Screen;

public class Line {
    public static void line(int x1, int y1, int x2, int y2, String color, Screen screen){
        // line code

    }

    public static void triangleFrame(int x1, int y1, int x2, int y2, int x3, int y3, String color, Screen screen){
        line(x1,y1,x2,y2,color,screen);
        line(x2,y2,x3,y3,color,screen);
        line(x1,y1,x3,y3,color,screen);
    }

    public static void triangleFill(int x1, int y1, int x2, int y2, int x3, int y3, String color, Screen screen){
        line(x1,y1,x2,y2,color,screen);
        line(x2,y2,x3,y3,color,screen);
        line(x1,y1,x3,y3,color,screen);
        // fill code
    }
}
