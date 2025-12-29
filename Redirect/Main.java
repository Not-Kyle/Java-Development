import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String actionName = "testingAction";
        String keybind = "X"; // Set Keybind

        JPanel panel = UI.initializeUI();
        UI.initializeKeybind(panel, actionName, keybind);
    }

    public static <T> void print(T message) {
        System.out.println(message);
    }
}
