package game.world;

import game.world.Cube.CubeType;
import static resources.Constants.Game.*;

public class World {
    CubeType[][][] world = new CubeType[WORLD_DIMENSIONS[0]][WORLD_DIMENSIONS[1]][WORLD_DIMENSIONS[2]];
    
    public World(){
        init();
    }

    public void init(){

    }

    public void setCube(int x, int y, int z, CubeType type){

    }
}
