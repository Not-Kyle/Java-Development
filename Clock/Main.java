public class Main {
    public static void main(String[] args) {
        ClockInt clock = new ClockInt();

        while (true) {
            System.out.println(clock);
            clock.advance();

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                return;
            }
        }
    }
}
