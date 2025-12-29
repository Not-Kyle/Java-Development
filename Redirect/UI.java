import javax.swing.*;

public class UI {
    public UI() {};

    public static JPanel initializeUI() {
        JFrame frame = new JFrame("Test");
        JPanel panel = new JPanel();

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return panel;
    }

    public static void initializeKeybind(JPanel panel, String name, String keybind) {
        InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();

        KeyStroke newKeybind = KeyStroke.getKeyStroke(keybind);

        inputMap.put(newKeybind, name);
        actionMap.put(name, new MoveAction(panel));
    }
}
