package game.render;

import java.util.function.Supplier;

import static resources.ConsoleColors.Text.*;

public enum Cube{
    AIR(() -> Texture.createEmptyTexture()),
    GRASS(() -> Texture.createSolidTexture(GREEN)),
    STONE(() -> Texture.createSolidTexture(WHITE))
    ;

    public final Supplier<Texture> texture; 

    private Cube(Supplier<Texture> incoming){
        this.texture = incoming;
    }
}



