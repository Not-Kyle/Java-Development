import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
    JButton button = new JButton("TEXT");
    JButton button2 = new JButton("TEXT2");

    Frame() {
        button.setBounds(100, 100, 100, 100);
        button.addActionListener((e) -> Main.print("Button pressed"));

        button2.setBounds(100, 200, 100, 100);
        button2.addActionListener((e) -> Main.print("Button pressed 2"));

        this.add(button);
        this.add(button2);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(null);
        this.setVisible(true);
    };
}
