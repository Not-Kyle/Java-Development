import javax.swing.*;
import java.awt.event.ActionEvent;

public class MoveAction extends AbstractAction {
    String url = "https://github.com/Not-Kyle";
    JComponent component;

    public MoveAction(JComponent component) {
        this.component = component;
    }

    @Override // Overriding the actionPerformed method from AbstractAction
    public void actionPerformed(ActionEvent e) {
        Main.print("Redirecting to: " + url);
        Redirect.redirectToUrl(url);
    }
}
