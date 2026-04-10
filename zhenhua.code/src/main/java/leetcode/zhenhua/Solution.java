import java.util.*;

public class Solution {

    public static double areaOfIntersection(int x1, int y1, int r1,
                                            int x2, int y2, int r2) {

        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // No overlap
        if (d >= r1 + r2) {
            return 0.0;
        }

        // One circle completely inside another
        if (d <= Math.abs(r1 - r2)) {
            int r = Math.min(r1, r2);
            return Math.PI * r * r;
        }

        // Partial overlap
        double alpha = Math.acos((r1*r1 + d*d - r2*r2) / (2 * r1 * d)) * 2;
        double beta  = Math.acos((r2*r2 + d*d - r1*r1) / (2 * r2 * d)) * 2;

        double area1 = 0.5 * r1 * r1 * (alpha - Math.sin(alpha));
        double area2 = 0.5 * r2 * r2 * (beta - Math.sin(beta));

        return area1 + area2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int centerX1 = in.nextInt();
        int centerY1 = in.nextInt();
        int radius1  = in.nextInt();
        int centerX2 = in.nextInt();
        int centerY2 = in.nextInt();
        int radius2  = in.nextInt();

        double result = areaOfIntersection(centerX1, centerY1, radius1,
                centerX2, centerY2, radius2);

        System.out.printf("%.6f\n", result);
    }
}