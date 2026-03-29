package math.functions;

import math.classes.Plane;
import math.classes.Point;

import java.util.Objects;

public class Point_Functions {

    public static Point mirror_point(String mirror, Point point, Point mirror_point, Plane mirror_plane){
        // we check which plane it is and change the coordinates accordingly
        // For origin ist the mirror then every coordinate times -1
        if (Objects.equals(mirror, "o")){
            double new_x = point.x * -1;
            double new_y = point.y * -1;
            double new_z = point.z * -1;
            return new Point(new_x,new_y,new_z);
        }
        else if (Objects.equals(mirror, "xy")) {
            double new_z = point.z * -1;
            return new Point(point.x,point.y,new_z);
        }
        else if(Objects.equals(mirror, "xz")){
            double new_y = point.y * -1;
            return new Point(point.x, new_y, point.z);
        }
        else if (Objects.equals(mirror, "yz")) {
            double new_x = point.x * -1;
            return new Point(new_x,point.y,point.z);

        }
        else if(Objects.equals(mirror, "x")){
            double new_y = point.y * -1;
            double new_z = point.z * -1;
            return new Point(point.x, new_y, new_z);
        }
        else if(Objects.equals(mirror, "y")){
            double new_x = point.x * -1;
            double new_z = point.z * -1;
            return new Point(new_x, point.y, new_z);
        }
        else if(Objects.equals(mirror, "z")){
            double new_x = point.x * -1;
            double new_y = point.y * -1;
            return new Point(new_x, new_y, point.z);
        }
        else if(Objects.equals(mirror, "point") && mirror_point != null){
            //We calculate the vector between the points double it and add it to the point that needs to be mirrored
            double new_x = point.x + (2*(mirror_point.x - point.x));
            double new_y = point.y + (2*(mirror_point.y - point.y));
            double new_z = point.z + (2*(mirror_point.z - point.z));
            return new Point(new_x, new_y, new_z);
        }

        else{
        System.out.println("Sry your mirror is not defined.");
        return null;
        }
    }
}