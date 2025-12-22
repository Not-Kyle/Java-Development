public class Main {
    public static void main(String[] arg) {
        
        Run run = new Run() {
            @Override
            public void running() {
                Main.print("Working");
            }
        };

        run.running();
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
