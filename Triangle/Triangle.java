public class Triangle {
    private int pointA;
    private int pointB;
    private int pointC;

    public Triangle(int pointA, int pointB, int pointC) {
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
        int base = this.pointB / 2;

        double area = 0.5 * (base) * (0.5 * base * Math.sqrt(3));

        return area;
    }

    public String toString() {
        return "PointA: " + pointA + "\nPointB: " + pointB + "\nPointC: " + pointC + "\nArea: " + surfaceArea();
    }
}
