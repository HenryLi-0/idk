package game.render;

import game.Screen;

public class Graph {
    public static void plot(int x, int y, String color, int intensity, Screen screen){
        screen.setColor(x, y, color);
        if (intensity != -1){
            screen.setIntensity(x, y, intensity);
        }
    }

    public static void line(int x1, int y1, int x2, int y2, String color, int intensity, Screen screen){
        // line code credit: https://youtu.be/vfPGuUDuwmo?si=LOlGcDL95R-CBI1k&t=765 
        int x = x1;
        int y = y1;
        double deltaX = Math.abs(x2-x1);
        double deltaY = Math.abs(y2-y1);
        int sign1 = (x2-x1)/Math.abs(x2-x1);
        int sign2 = (y2-y1)/Math.abs(y2-y1);
        double temp;
        double interchange;
        if (deltaY>deltaX){
            temp = deltaX;
            deltaX = deltaY;
            deltaY = temp;
            interchange = 1;
        } else {
            interchange = 0;
        }
        double e = 2 * deltaY - deltaX;
        double a = 2 * deltaY;
        double b = 2 * deltaY - 2 * deltaX;
        plot(x,y,color,intensity,screen);
        for (int i = 1; i <= deltaX; i++){
            if (e < 0){
                if (interchange == 1){
                    y = y + sign2;
                } else {
                    x = x + sign1;
                    e = e + a;
                }
            } else {
                y = y + sign2;
                x = x + sign1;
                e = e + b;                
            }
            plot(x,y,color,intensity,screen);
        }
    }

    public static void triangleFrame(int x1, int y1, int x2, int y2, int x3, int y3, String color, int intensity,Screen screen){
        line(x1,y1,x2,y2,color,intensity,screen);
        line(x2,y2,x3,y3,color,intensity,screen);
        line(x1,y1,x3,y3,color,intensity,screen);
    }

    public static void triangleFill(int x1, int y1, int x2, int y2, int x3, int y3, String color, int intensity,Screen screen){
        line(x1,y1,x2,y2,color,intensity,screen);
        line(x2,y2,x3,y3,color,intensity,screen);
        line(x1,y1,x3,y3,color,intensity,screen);
        // fill code
    }
}
