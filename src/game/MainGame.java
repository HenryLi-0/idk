package game;

import game.camera.Camera;
import game.render.DisplayWork;
import game.render.Screen;
import game.world.World;
import resources.ConsoleColors;

import static resources.Constants.Render.*;

import java.awt.MouseInfo;

import static resources.Constants.Game.*;

public class MainGame {
    private Screen screen = new Screen(DISPLAY_DIMENSIONS[0], DISPLAY_DIMENSIONS[1]);
    private Camera camera = new Camera(PLAYER_GRAVITY, PLAYER_COLLISION);
    private int gametime = 0;

    private World world = new World();

    public MainGame(){
        screen.init();
        tick();
        gametime+=1;
    }

    public void displayTick(){
        camera.setRotation(MouseInfo.getPointerInfo().getLocation().x/5 + PHYSICAL_DISPLAY_DIMENSIONS[0]/2,MouseInfo.getPointerInfo().getLocation().y/5 + PHYSICAL_DISPLAY_DIMENSIONS[1]/2);
        DisplayWork.calculateWorld(world, screen, camera);
        // for (int i = -3; i<=3; i++){
            //     for (int ie = -3; ie<=3; ie++){
                //         DisplayWork.renderWireframe(i*3, 1, ie*3, (i+1)*3, 4, (ie+1)*3, ConsoleColors.Text.RED, 5, screen, cameraPos);
                //     }
                // } 
        camera.updateTrigRotations();
        DisplayWork.renderWireframe(-10, -10, 2, 10, 10, 5, ConsoleColors.Text.CYAN, 5, screen, camera);
        screen.display();
    }

    public void tick(){
        gametime+=1;
    }

    public int getGametime(){
        return gametime;
    }
}
