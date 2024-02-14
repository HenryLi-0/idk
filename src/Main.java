import game.MainGame;
import static resources.Constants.Game.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // System.out.println(ConsoleColors.Background.BLACK_BACKGROUND_BRIGHT+ConsoleColors.Text.BLUE+"/"+ConsoleColors.RESET);
        MainGame game = new MainGame();
        long lastTickUpdate = System.currentTimeMillis();
        long lastDisplayUpdate = System.currentTimeMillis();

        while (true){
            if (System.currentTimeMillis()>=lastDisplayUpdate+MAX_FPS_DELAY){
                lastDisplayUpdate=System.currentTimeMillis();
                game.displayTick();
            }
            if (System.currentTimeMillis()>=lastTickUpdate+TICK_DELAY){
                lastTickUpdate=System.currentTimeMillis();
                game.tick();
            }
        }
    }
}