import java.util.Scanner;

public class Userinput {
    private Scanner userInput;
    private Wordset wordSet;

    private boolean wordAlreadyIndexed;

    public Userinput(Scanner scanner, Wordset wordSet) {
        this.userInput = scanner;
        this.wordSet = wordSet;
    }

    public void start() {
        while (true) {
            Main.print("Enter a word: ");
            String word = userInput.nextLine();

            if (this.wordSet.contains(word)) {
                wordAlreadyIndexed = true;
                break;
            }

            if (ended(word)) {
                Main.print("Exitting Program");
                break; // No System.exit(0) here for a clean exit, System.exit() instantly stops as break lets the program finish
            }

            this.wordSet.add(word);
        }

        if (wordAlreadyIndexed) {
            Main.print("You've entered the same word twice");
        }

        Main.print(this.wordSet.palindromes() + " of the words were palidromes");
        userInput.close();
    }

    public boolean ended(String word) {
        return "end".equalsIgnoreCase(word); // equals only works if the word is "end" equalsIgnoreCase will exit the program regardless of the case
    }
}
