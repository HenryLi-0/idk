package game.camera;

import game.world.World;
import static resources.Constants.Game.*;

public class CameraPosition {
    private double x = 0; private double xv = 0;
    private double y = 0; private double yv = 0;
    private double z = 0; private double zv = 0;
    
    private double xrot = 0; private double sinx = 0; private double siny = 0;
    private double yrot = 0; private double cosx = 0; private double cosy = 0;

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




    public void setPositions(double nx, double ny, double nz){
        x=nx;
        y=ny;
        z=nz;
    }

    public void setVelocities(double nxv, double nyv, double nzv){
        xv=nxv;
        yv=nyv;
        zv=nzv;
    }

    public void setRotation(double xrotation, double yrotation){
        xrot=xrotation;
        yrot=yrotation;
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

    /**
     * Update Trignometric Rotations
     * @return void
     */
    public void updateTrigRotations(){
        sinx = Math.sin(xrot);
        siny = Math.sin(yrot);
        cosx = Math.cos(xrot);
        cosy = Math.cos(yrot); 
    }

    /**
     * Get Trignometric Rotations
     * NOTE: RUN updateTrigRotations() TO GET UP-TO-DATE MEASURES
     * @return double[]
     */
    public double[] getTrigRotations(){
        double[] temp = {};
        return temp;
    }

    

}
