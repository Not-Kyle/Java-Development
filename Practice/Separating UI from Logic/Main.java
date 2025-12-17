import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        Wordset set = new Wordset();

        Userinput userinput = new Userinput(scanner, set);
        userinput.start();
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
