import game.MainGame;
import static resources.Constants.Game.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MainGame game = new MainGame();
        long lastTickUpdate = System.currentTimeMillis();
        long lastDisplayUpdate = System.currentTimeMillis();

        game.displayTick();

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