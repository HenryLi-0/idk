package resources;

// Credit to https://stackoverflow.com/a/45444716 for original code

public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset
    
    public class Text {
        // Regular Colors
        public static final String WHITE = "\033[0;37m";   // WHITE
        public static final String BLACK = "\033[0;30m";   // BLACK
        public static final String RED = "\033[0;31m";     // RED
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String CYAN = "\033[0;36m";    // CYAN
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE

        // High Intensity
        public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE
        public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
        public static final String RED_BRIGHT = "\033[0;91m";    // RED
        public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
        public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
        public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    }

    public class Background {
        // Bold High Intensity
        public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
        public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
        public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
        public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
        public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
        public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
        public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
        public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE

        // High Intensity backgrounds
        public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
        public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
        public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
        public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
        public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
        public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
        public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
        public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    }
}