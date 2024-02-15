package game.render.render_sub;

import resources.ConsoleColors;

// FTC: Format Text (Colored)
public class ColoredText {
    public static String format(String text, String color){
        return color+text;
    }

    public static String format(String text, String color, String background){
        return color+background+text+ConsoleColors.RESET;
    }

    public static String format(String[] text, String[] color){
        String temp = "";
        for (int i = 0; i < text.length; i++)
            temp = temp + color[i] + text[i];
        return temp;
    }
}
