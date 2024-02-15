package game.render.render_sub;

import static resources.Constants.Render.*;

import resources.ConsoleColors;

public class Texture {
    String[] texture = new String[TEXTURE_SIZE]; // 8x8 textures

    public void setSolidTexture(String color){
        for (int i = 0; i < TEXTURE_SIZE; i++) {
            texture[i] = color;
        }
    }

    public void setPixelTexture(String color, int index){
        texture[index] = color;
    }

    public String[] get(){
        return texture;
    }


    public static Texture createEmptyTexture(){
        Texture returnTexture = new Texture();
        returnTexture.setSolidTexture(ConsoleColors.RESET);
        return returnTexture;
    }

    public static Texture createSolidTexture(String color){
        Texture returnTexture = new Texture();
        returnTexture.setSolidTexture(color);
        return returnTexture;
    }

    public static Texture createCustomTexture(String[] colors){
        Texture returnTexture = new Texture();
        if (colors.length == TEXTURE_SIZE){
            for (int i = 0; i < 64; i++) {
                returnTexture.setPixelTexture(colors[i], i);
            }
        } else {
            returnTexture.setSolidTexture(ConsoleColors.Text.PURPLE);
        }
        return returnTexture;
    }

}
