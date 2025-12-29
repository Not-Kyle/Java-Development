import javax.swing.*;
import java.awt.event.ActionEvent;

public class MoveAction extends AbstractAction {
    JComponent component;

    public MoveAction(JComponent component) {
        this.component = component;
    }

    @Override // Overriding the actionPerformed method from AbstractAction
    public void actionPerformed(ActionEvent e) {
        Main.print("Keybind Indexed");
    }
}
