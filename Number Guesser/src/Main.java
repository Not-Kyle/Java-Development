public class Main {
    public static void main(String[] arg) {
        PointsManager pointsManager = new PointsManager();
        UI ui = new UI(pointsManager);
    }

    public static <T> void print(T message) {
        System.out.println(message);
    }

    public static <T> void error(T message) {
        System.err.println(message);
    }
}