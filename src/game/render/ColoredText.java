package game.render;

import resources.ConsoleColors;

public class ColoredText {
    public static String format(String text, String color){
        return color+text;
    }

    public static String formatr(String text, String color){
        return color+text+ConsoleColors.RESET;
    }

    public static String format(String[] text, String[] color){
        String temp = "";
        for (int i = 0; i < text.length; i++)
            temp = temp + color[i] + text[i];
        return temp;
    }

    public static String formatr(String[] text, String[] color){
        String temp = "";
        for (int i = 0; i < text.length; i++)
            temp = temp + color[i] + text[i];
        return temp+ConsoleColors.RESET;
    }
}
