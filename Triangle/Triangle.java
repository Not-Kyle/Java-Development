import java.awt.*;
import java.lang.Math;

public class Triange {

    private int pointA;
    private int pointB;
    private int pointC;

    public Triange(int pointA, int pointB, int pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public void widen() {
        this.pointA++;
        this.pointB++;
        this.pointC++;
    }

    public double surfaceArea() {
        int perimeter = 1/2 * (this.pointA + this.pointB + this.pointC);

        int a = this.pointA;
        int b = this.pointB;
        int c = this.pointC;

        double area = Math.sqrt(4 * a^2 * b^2 - (a^2 + b^2 - c^2)^2);

        return area;
    }

    public String toString() {
        return "PointA: " + pointA + "\nPointB: " + pointB + "\nPointC: " + pointC;
    }
}
