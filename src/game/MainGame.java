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
        DisplayWork.renderWireframe(1, 1, 1, 10, 10, 10, ConsoleColors.Text.CYAN, 5, screen, cameraPos);
        screen.display();
    }

    public void tick(){
        
        gametime+=1;
    }

    public int getGametime(){
        return gametime;
    }
}
