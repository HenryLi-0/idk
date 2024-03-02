package game.render;

import game.camera.Camera;
import game.render.render_sub.Graph;
import game.render.render_sub.Translation;
import game.world.World;

import static resources.Constants.Render.*;

public class DisplayWork {
    public static void calculateWorld(World world, Screen screen, Camera camera){
        // camera.updateTrigRotations();
    }

    public static void renderWireframe(double x1, double y1, double z1, double x2, double y2, double z2, String color, int intensity, Screen screen, Camera camera){
        if (x1==x2){
            lineRender(x1, y1, z1, x1, y1, z2, color, intensity, screen, camera);
            lineRender(x1, y1, z1, x1, y2, z1, color, intensity, screen, camera);
            lineRender(x1, y1, z2, x1, y2, z2, color, intensity, screen, camera);
            lineRender(x1, y2, z1, x1, y2, z2, color, intensity, screen, camera);
        } else if (y1==y2) {
            lineRender(x1, y1, z1, x1, y1, z2, color, intensity, screen, camera);
            lineRender(x1, y1, z1, x2, y1, z1, color, intensity, screen, camera);
            lineRender(x1, y1, z2, x2, y1, z2, color, intensity, screen, camera);
            lineRender(x2, y1, z1, x2, y1, z2, color, intensity, screen, camera);
        } else if (z1==z2) {
            lineRender(x1, y1, z1, x1, y2, z1, color, intensity, screen, camera);
            lineRender(x1, y1, z1, x2, y1, z1, color, intensity, screen, camera);
            lineRender(x1, y2, z1, x2, y2, z1, color, intensity, screen, camera);
            lineRender(x2, y1, z1, x2, y2, z1, color, intensity, screen, camera);
        } else {
            lineRender(x1, y1, z1, x2, y1, z1, color, intensity, screen, camera);
            lineRender(x1, y1, z2, x2, y1, z2, color, intensity, screen, camera);
            lineRender(x1, y2, z1, x2, y2, z1, color, intensity, screen, camera);
            lineRender(x1, y2, z2, x2, y2, z2, color, intensity, screen, camera);
            
            lineRender(x1, y1, z1, x1, y2, z1, color, intensity, screen, camera);
            lineRender(x1, y1, z2, x1, y2, z2, color, intensity, screen, camera);
            lineRender(x2, y1, z1, x2, y2, z1, color, intensity, screen, camera);
            lineRender(x2, y1, z2, x2, y2, z2, color, intensity, screen, camera);

            lineRender(x1, y1, z1, x1, y1, z2, color, intensity, screen, camera);
            lineRender(x1, y2, z1, x1, y2, z2, color, intensity, screen, camera);
            lineRender(x2, y1, z1, x2, y1, z2, color, intensity, screen, camera);
            lineRender(x2, y2, z1, x2, y2, z2, color, intensity, screen, camera);
        }
    }

    public static void lineRender(double x1, double y1, double z1, double x2, double y2, double z2, String color, int intensity, Screen screen, Camera camera){
        int[] draw = Translation.line(x1, y1, z1, x2, y2, z2, camera);
        if (!(draw[0]== -999 && draw[1]== -999 && draw[2]== -999 && draw[3]== -999)){
            double slope = (y2-y1)/(x2-x1+0.000001);
            double y_int = y1-(x1*slope);

            // Cut off off screen based on slope (limits x)
            if (draw[0] < -HALF_X){draw[0] = (int) Math.ceil(-HALF_X); draw[1] = (int) Math.ceil((-HALF_X) * slope + y_int);}
            if (draw[0] >  HALF_X){draw[0] = (int) Math.ceil( HALF_X); draw[1] = (int) Math.ceil(( HALF_X) * slope + y_int);}
            if (draw[2] < -HALF_X){draw[2] = (int) Math.ceil(-HALF_X); draw[3] = (int) Math.ceil((-HALF_X) * slope + y_int);}
            if (draw[2] >  HALF_X){draw[2] = (int) Math.ceil( HALF_X); draw[3] = (int) Math.ceil(( HALF_X) * slope + y_int);}

            // Cut off off screen based on slope (limits y)


            Graph.line((int) Math.floor(draw[0] + (HALF_X)), (int) Math.floor(draw[1] + (HALF_Y)), (int) Math.floor(draw[2] + (HALF_X)), (int) Math.floor(draw[3] + (HALF_Y)),  color, intensity, screen);
        }
    }
}
