package game.camera;

import game.world.World;
import static resources.Constants.Game.*;

public class CameraPosition {
    private double x = 0; 
    private double y = 0; 
    private double z = 0;
    
    private double xrot = 0; 
    private double yrot = 0;
    
    private double xv = 0; 
    private double yv = 0; 
    private double zv = 0;

    private boolean gravity;
    private boolean collision;

    public CameraPosition(boolean ngravity, boolean ncollision){
        gravity = ngravity;
        collision = ncollision;
    }

    public void update(World world){
        x+=xv; 
        y+=yv; 
        z+=zv;
        if (gravity){
            // change yv
        }
        if (collision){
            //collision code
        }
        xv*=SIDEWAYS_VELOCITY_MULTIPLIER;
        zv*=SIDEWAYS_VELOCITY_MULTIPLIER;
    }




    public void setPositions(double[] positions){
        if (positions.length == 3){
            x=positions[0];
            y=positions[1];
            z=positions[2];
        }
    }

    public void setVelocities(double[] velocities){
        if (velocities.length == 3){
            xv=velocities[0];
            yv=velocities[1];
            zv=velocities[2];
        }
    }

    public void setRotation(double[] rotations){
        if (rotations.length == 2){
            xrot=rotations[0];
            yrot=rotations[1];
        }
    }



    public double[] getPosition(){
        double[] temp = {x,y,z};
        return temp;
    }

    public double[] getVelocity(){
        double[] temp = {xv,yv,zv};
        return temp;
    }

    public double[] getRotation(){
        double[] temp = {xrot,yrot};
        return temp;
    }

    

}
