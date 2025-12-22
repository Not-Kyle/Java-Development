public class Main {
    public static void main(String[] arg) {
        String user = "Cory";
        char symbol = '!';

        /*
        Run run = () -> Main.print("Working");
        run.running();
        */ // Single statement lambda

        /*
        Run run = () -> {
            Main.print("Is multi lamba?");
            Main.print("Yes");
        };

        run.running();
        */ // Multi lambda expressions

        // What about arguments?

        Run run = (name, expression) -> {
            Main.print("Can I print my user?");
            Main.print("Yes its, " + name + expression);
        };

        run.running(user, symbol);
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
