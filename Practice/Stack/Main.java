public class Main {
    public static void main(String[] arg) {
        Stack stack = new Stack();

        print(String.valueOf(stack.isEmpty()));
        stack.add("okay");
        stack.add("yes");

        print(String.valueOf(stack.values()));

        String taken = stack.take();
        print(taken);

        print(String.valueOf(stack.values()));
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
