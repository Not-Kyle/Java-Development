import java.util.ArrayList;

public class Main {
    public static void main(String[] arg) {
        ArrayList<Example> examples = new ArrayList<>();

        examples.add(new Example("", (short) 5));
        examples.add(new Example("Example", (short) 8));

        for (Example arguments : examples) {
            print(arguments.getName() + " " + arguments.getId());
        }
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
