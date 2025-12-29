import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String actionName = "testingAction";
        String keybind = "X"; // Set Keybind

        JFrame frame = new JFrame("Test");
        JPanel panel = new JPanel();

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();

        KeyStroke newKeybind = KeyStroke.getKeyStroke(keybind);

        inputMap.put(newKeybind, actionName);
        actionMap.put(actionName, new MoveAction(panel));
    }

    public static <T> void print(T message) {
        System.out.println(message);
    }
}
