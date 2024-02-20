package game.render;

import game.camera.CameraPosition;
import game.render.render_sub.Graph;
import game.render.render_sub.Translation;
import game.world.World;

public class DisplayWork {
    public static void calculateWorld(World world, Screen screen){
        
    }

    public static void renderWireframe(int x1, int y1, int z1, int x2, int y2, int z2, String color, int intensity, Screen screen, CameraPosition camera){
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

    public static void lineRender(int x1, int y1, int z1, int x2, int y2, int z2, String color, int intensity, Screen screen, CameraPosition camera){
        int[] draw = Translation.line(x1, y1, z1, x2, y2, z2, camera);
        Graph.line(draw[0], draw[1], draw[2], draw[3], color, intensity, screen);
    }
}
