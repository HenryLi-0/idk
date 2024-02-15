package game.world;

import static resources.Constants.Game.*;

import game.render.Cube;

public class World {
    Cube[][][] world = new Cube[WORLD_DIMENSIONS[0]][WORLD_DIMENSIONS[1]][WORLD_DIMENSIONS[2]];
    
    public World(){
        init();
    }

    public void init(){
        world = Generation.generate(WORLD_DIMENSIONS[0],WORLD_DIMENSIONS[1],WORLD_DIMENSIONS[2]);
    }

    public void setCube(int x, int y, int z, Cube type){
        world[x][y][z] = type;
    }

    public Cube getCube(int x, int y, int z){
        return world[x][y][z];
    }

    public void tick(){
        // tick stuff (ex. leaves decay, water flows...)
    }
}
