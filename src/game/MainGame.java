package game;

import resources.ConsoleColors;
import resources.Constants;

public class MainGame {
    private Screen screen = new Screen(Constants.Render.DISPLAY_DIMENSIONS[0], Constants.Render.DISPLAY_DIMENSIONS[1]);
    private int gametime = 0;

    public MainGame(){
        screen.init();
        tick();
        gametime+=1;
    }

    public void displayTick(){
        screen.display();
    }

    public void tick(){
        screen.display();
        for (int iy = 0; iy < Constants.Render.DISPLAY_DIMENSIONS[1]; iy++){
            for (int ix = 0; ix < Constants.Render.DISPLAY_DIMENSIONS[0]; ix++){
                screen.setIntensity(ix, iy, (ix+iy+gametime)%10);
                screen.setColor(ix, iy, ConsoleColors.Text.GREEN);
            }
        }
        gametime+=1;
    }

    public int getGametime(){
        return gametime;
    }
}
