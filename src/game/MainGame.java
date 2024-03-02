package game;

import game.camera.CameraPosition;
import game.render.DisplayWork;
import game.render.Screen;
import game.world.World;
import resources.ConsoleColors;

import static resources.Constants.Render.*;

import java.awt.MouseInfo;

import static resources.Constants.Game.*;

public class MainGame {
    private Screen screen = new Screen(DISPLAY_DIMENSIONS[0], DISPLAY_DIMENSIONS[1]);
    private CameraPosition cameraPos = new CameraPosition(PLAYER_GRAVITY, PLAYER_COLLISION);
    private int gametime = 0;

    private World world = new World();

    public MainGame(){
        screen.init();
        tick();
        gametime+=1;
    }

    public void displayTick(){
        cameraPos.setRotation(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y);
        DisplayWork.calculateWorld(world, screen);
        // for (int i = -3; i<=3; i++){
        //     for (int ie = -3; ie<=3; ie++){
        //         DisplayWork.renderWireframe(i*3, 1, ie*3, (i+1)*3, 4, (ie+1)*3, ConsoleColors.Text.RED, 5, screen, cameraPos);
        //     }
        // } 
        DisplayWork.renderWireframe(-10, -10, 2, 10, 10, 5, ConsoleColors.Text.CYAN, 5, screen, cameraPos);
        screen.display();
    }

    public void tick(){
        gametime+=1;
    }

    public int getGametime(){
        return gametime;
    }
}
