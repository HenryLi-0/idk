package resources;

public class Constants {
    public class Render {
        // Imagery Related
        public static final String[] INTENSITY = {" ", ".", ".", "░", "░", "▒", "▒", "▓", "▓", "█"};
        public static final int[] DISPLAY_DIMENSIONS = {75,15};
        public static final int TEXTURE_AXIS = 8; // Describes pixel length of a texture (ex: TEXTURE_AXIS = 8, texture will be 8x8)
        public static final int TEXTURE_SIZE = TEXTURE_AXIS*TEXTURE_AXIS;

        // Rendering Engine Related
        public static final int VIEW_FACTOR = 1; 
        public static final int NEAR_PLANE = 0; // Has to be greater than 0 
    }

    public class Game {
        // Ticking Related
        public static final int MAX_FPS = 10;
        public static final int MAX_FPS_DELAY = 1000/MAX_FPS;
        public static final int TPS = 20;
        public static final long TICK_DELAY = 1000/TPS;

        // Gameplay Related
        public static final int[] WORLD_DIMENSIONS = {10,10,10};


        // Camera Movement Related
        public static final double SIDEWAYS_VELOCITY_MULTIPLIER = 0.8; // Limits sideways velocity
        public static final double GRAVITY = 0.8; // Gravity

        public static final boolean PLAYER_GRAVITY = false;
        public static final boolean PLAYER_COLLISION = false;
        
    }
}
