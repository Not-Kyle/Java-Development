import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Set your players name: ");
        String playerName = userInput.nextLine();

        System.out.print("Set your age: ");
        int age = userInput.nextInt();

        System.out.print("Set your strength: ");
        int strength = userInput.nextInt();

        Player player = new Player(playerName, age, 100, strength);
        System.out.println(player);
    }
}
