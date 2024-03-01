package game.world;

import game.render.render_sub.Cube;

public class Generation {
    public static Cube[][][] generate(int x, int y, int z){
        // x and z flat plane
        // y vertical axis
        Cube[][][] world= new Cube[x][y][z];
        for (int ix = 0; ix<x; ix++){
            for (int iy = 0; iy<y; iy++){
                for (int iz = 0; iz<z; iz++){
                    if (iy<3){
                        world[ix][iy][iz] = Cube.STONE;
                    } else {
                        world[ix][iy][iz] = Cube.AIR;
                    }
                }
            }
        }
        return world;
    }
}
