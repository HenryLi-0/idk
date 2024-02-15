package resources;

public class Constants {
    public class Render {
        public static final String[] INTENSITY = {" ", ".", ".", "░", "░", "▒", "▒", "▓", "▓", "█"};
        public static final int[] DISPLAY_DIMENSIONS = {150,15};
        public static final int TEXTURE_AXIS = 8; // describes pixel length of a texture (ex: TEXTURE_AXIS = 8, texture will be 8x8)
    }

    public class Game {
        // Ticking Related
        public static final int MAX_FPS = 1;
        public static final int MAX_FPS_DELAY = 1000/MAX_FPS;
        public static final int TPS = 20;
        public static final long TICK_DELAY = 1000/TPS;

        // Gameplay Related
        public static final int[] WORLD_DIMENSIONS = {10,10,10};
        
    }
}
