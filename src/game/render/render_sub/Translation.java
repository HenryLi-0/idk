package game.render.render_sub;

import static resources.Constants.Render.*;

import game.camera.CameraPosition;

public class Translation {
    // 3D frame rendering code credit: https://scratch.mit.edu/users/MathMathMath/
    // (translated and modified from Scratch to Java)

    public static int[] point(double rawX, double rawY, double rawZ, CameraPosition camera){
        double[] cameraPosition = camera.getPosition();
        double x = rawX - cameraPosition[0];
        double y = rawY - cameraPosition[1];
        double z = rawZ - cameraPosition[2];
        double rx = VIEW_FACTOR * x/z; 
        double ry = VIEW_FACTOR * y/z;
        int[] returning = {(int) Math.round(rx), (int) Math.round(ry)};
        return returning;
    }

    // NO ROUNDING
    private static double[] pointNR(double rawX, double rawY, double rawZ, CameraPosition camera){
        double[] cameraPosition = camera.getPosition();
        double x = rawX - cameraPosition[0];
        double y = rawY - cameraPosition[1];
        double z = rawZ - cameraPosition[2];
        double rx = VIEW_FACTOR * x/z; 
        double ry = VIEW_FACTOR * y/z;
        double[] returning = {rx,ry};
        return returning;
    }

    private static double[] pointFixOff(double rawX, double rawY, double rawZ, CameraPosition camera){
        double[] cameraPosition = camera.getPosition();
        double[] returning = {cameraPosition[0], cameraPosition[1], cameraPosition[2]};
        return returning;
    }

    public static double[] line(double x1, double y1, double z1, double x2, double y2, double z2, CameraPosition camera){
        double[] point1 = pointFixOff(x1,y1,z1,camera);
        double[] point2 = pointFixOff(x2,y2,z2,camera);

        if (!((z1 < NEAR_PLANE) && (z2 < NEAR_PLANE))) {
            // Z Clipping
            if ( (z1 < NEAR_PLANE) || (x2 < NEAR_PLANE)){
                double percent = ((NEAR_PLANE-z1)/(z2-z1));
                if (z1 < NEAR_PLANE){
                    point1[0] = x1 + ((x2 - x1) * percent);
                    point1[1] = y1 + ((y2 - y1) * percent);
                    point1[2] = NEAR_PLANE;
                } else if (z2 < NEAR_PLANE) {
                    point2[0] = x1 + ((x2 - x1) * percent);
                    point2[1] = y1 + ((y2 - y1) * percent);
                    point2[2] = NEAR_PLANE;
                } else {}
            }
            double[] point1r = pointNR(x1, y1, z1, camera);
            double[] point2r = pointNR(x2, y2, z2, camera);
            double[] returning = {point1r[0], point1r[1], point2r[0], point2r[1]};
            return returning;
        }
        // System.out.println("Uh Oh! the coords (" + x1 + "," + y1 + "," + z1 + ") to (" + x2 + "," + y2 + "," + z2 + ") are illegal!");
        double[] illegal = {-999,-999,-999,-999};
        return illegal;
    }
}
