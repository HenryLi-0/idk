package resources;

public class Constants {
    public class Render {
        public static final String[] INTENSITY = {" ", ".", ".", "░", "░", "▒", "▒", "▓", "▓", "█"};
        public static final int[] DISPLAY_DIMENSIONS = {225,15};
    }

    public class Game {
        public static final int MAX_FPS = 30;
        public static final int MAX_FPS_DELAY = 1000/MAX_FPS;
        public static final int TPS = 20;
        public static final long TICK_DELAY = 1000/TPS;

    }
}
