package game.render;

import static resources.Constants.Render.*;

import resources.ConsoleColors;

public class Texture {
    String[] texture = new String[TEXTURE_AXIS*TEXTURE_AXIS]; // 8x8 textures

    public void setSolidTexture(String color){
        for (int i = 0; i < 64; i++) {
            texture[i] = color;
        }
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

}
