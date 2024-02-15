package game;

import game.render.Graph;
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
        Graph.line(0, 0, 149, 14, ConsoleColors.Text.GREEN, 9, screen);
        screen.display();
        System.out.println("seperater");
    }

    public void tick(){
        for (int iy = 0; iy < Constants.Render.DISPLAY_DIMENSIONS[1]; iy++){
            for (int ix = 0; ix < Constants.Render.DISPLAY_DIMENSIONS[0]; ix++){
                screen.setIntensity(ix, iy, (ix+iy+gametime)%10);
                switch ((iy) % 10){
                    case 0: screen.setColor(ix, iy, ConsoleColors.Text.WHITE); break;
                    case 1: screen.setColor(ix, iy, ConsoleColors.Text.BLACK); break;
                    case 2: screen.setColor(ix, iy, ConsoleColors.Text.RED); break;
                    case 3: screen.setColor(ix, iy, ConsoleColors.Text.YELLOW); break;
                    case 4: screen.setColor(ix, iy, ConsoleColors.Text.GREEN); break;
                    case 5: screen.setColor(ix, iy, ConsoleColors.Text.CYAN); break;
                    case 6: screen.setColor(ix, iy, ConsoleColors.Text.BLUE); break;
                    case 7: screen.setColor(ix, iy, ConsoleColors.Text.PURPLE); break;
                    case 8: screen.setColor(ix, iy, ConsoleColors.Text.WHITE); break;
                    case 9: screen.setColor(ix, iy, ConsoleColors.Text.WHITE); break;
                }
            }
        }
        gametime+=1;
    }

    public int getGametime(){
        return gametime;
    }
}
