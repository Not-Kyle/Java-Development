import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("PointA: ");
        int pointA = userInput.nextInt();

        System.out.print("PointB: ");
        int pointB = userInput.nextInt();

        System.out.print("PointC: ");
        int pointC = userInput.nextInt();

        Triangle triangle = new Triangle(pointA, pointB, pointC);

        System.out.print("Widen [y/n]: ");
        String answer = userInput.next();

        if (answer.equals("y") || answer.equals("Y")) {
            triangle.widen();
        }

        System.out.println(triangle);
    }
}
