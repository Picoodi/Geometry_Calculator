package math.functions;

import math.classes.Line;
import math.classes.Plane;
import math.classes.Point;
import math.classes.Vector;

public class Plane_Functions {

    public static boolean Point_in_Plane(Point point, Plane plane){
        if (plane.normal_vector == null){
            plane.create_normal_form();
        }
        double eq = (plane.normal_vector.x * point.x) + (plane.normal_vector.y * point.y) + (plane.normal_vector.z * point.z) - plane.constant;

        return eq == 0;
    }

    public static boolean Line_parallel_Plane(Line line, Plane plane){
        if (plane.normal_vector == null){
            plane.create_normal_form();
        }

        return 0 == Vector_Functions.scalar_product(plane.normal_vector, line.direction_vector);
    }

    public static boolean Line_in_Plane(Line line, Plane plane){
        return Point_in_Plane(new Point(line.support_vector.x, line.support_vector.y, line.support_vector.z), plane) && Line_parallel_Plane(line, plane);
    }


    public static Line Line_of_intersection(Plane E, Plane F){
        double a = E.normal_vector.x;
        double b = E.normal_vector.y;
        double c = E.normal_vector.z;
        double k = E.constant;

        double l = F.normal_vector.x;
        double m = F.normal_vector.y;
        double n = F.normal_vector.z;
        double j = F.constant;

        double A1 = (k / a) - (b / a) * ( (j / (-(l * b) / a + m)) - (l * k / (a * (-(l * b) / a + m))) );
        double A2 = (j / (-(l * b) / a + m)) - (l * k / (a * (-(l * b) / a + m)));


        double u1_inner = (((l * c) / a - n) * (1.0 / (-(l * b) / a + m)));
        double u1 = (-b * u1_inner - c) / a;

        double u2 = (((l * c) / a - n) * (1.0 / (-(l * b) / a + m)));

        return new Line(new Vector(A1,A2,0), new Vector(u1,u2,1));
    }
}
