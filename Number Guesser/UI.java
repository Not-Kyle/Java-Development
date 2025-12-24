import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.Objects;

public class UI extends JFrame {
    private final PointsManager pointsManager;

    private static final int backupFontSize = 18;
    private static final String backupFont = "Monospaced";

    private static int lastScored = 0;
    private static boolean cheatsActive = false;

    private int correctNumber;

    private JLabel label;
    private JLabel cheatLabel;
    private JLabel numberLabel;
    private JLabel highScoreLabel;

    private JButton button;
    private JButton button2;

    private JPanel panel;
    private JTextField textField;

    public UI(PointsManager manager) {
        this.pointsManager = manager;
        this.correctNumber = pointsManager.getTargetNumber();

        initializeUI();

        this.add(button);
        this.add(button2);

        this.add(cheatLabel);
        this.add(numberLabel);
        this.add(textField);

        this.add(panel, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    private void initializeUI() {
        panel = new JPanel();
        panel.setBackground(setRGBColor(10, 10, 10));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.setLayout(new FlowLayout());

        // Text field
        textField = new JTextField(3);
        textField.setBounds(95, 90, 100, 20);
        textField.setFont(setCustomFont());
        textField.setForeground(setRGBColor(225, 225, 225));

        // Points label
        label = new JLabel("Points: " + pointsManager.getPoints());
        label.setForeground(setRGBColor(225, 225, 225));
        label.setFont(setCustomFont());
        label.setBounds(10, 10, 200, 20);
        panel.add(label);

        // High score label
        highScoreLabel = new JLabel(" | High Score: " + pointsManager.getHighScore());
        highScoreLabel.setForeground(setRGBColor(225, 225, 225));
        highScoreLabel.setFont(setCustomFont());
        highScoreLabel.setBounds(10, 30, 200, 20);
        panel.add(highScoreLabel);

        // Number label
        numberLabel = new JLabel("Number is between 0 and " + pointsManager.getTargetNumber());
        numberLabel.setBounds(60, 50, 300, 20);
        numberLabel.setForeground(setRGBColor(225, 225, 225));
        numberLabel.setFont(setCustomFont(backupFontSize, Font.BOLD));

        // Cheat label
        cheatLabel = new JLabel("Correct Number: " + correctNumber);
        cheatLabel.setBounds(87, 150, 300, 20);
        cheatLabel.setForeground(setRGBColor(225, 225, 225));
        cheatLabel.setFont(setCustomFont());
        cheatLabel.setVisible(false);

        // Button
        button = new JButton("Confirm?");
        button.setBounds(95, 120, 100, 20);
        button.addActionListener(e -> handleGuess());

        button2 = new JButton("Cheats");
        button2.setBounds(178, 236, 100, 20);
        button2.addActionListener(e -> {
            cheatsActive = !cheatsActive;

            cheatLabel.setVisible(cheatsActive);
        });

        this.add(panel);
    }

    private void handleGuess() {
        String input = textField.getText().trim();

        if (Objects.equals(input, String.valueOf(correctNumber))) {
            lastScored++;

            if (lastScored > pointsManager.getHighScore()) {
                pointsManager.addHighScore();
            }

            pointsManager.addPoints(100);
            pointsManager.generateNextTarget();
            generateNewNumber();

        } else {
            lastScored = 0;

            pointsManager.setDefaultPoints();
            pointsManager.setDefaultTargetNumber();
            generateNewNumber();
        }

        updateLabels();
        eraseText(textField);
    }

    private void updateLabels() {
        label.setText("Points: " + pointsManager.getPoints());
        cheatLabel.setText("Correct Number: " + correctNumber);
        numberLabel.setText("Number is between 0 and " + pointsManager.getTargetNumber());
        highScoreLabel.setText(" | High Score: " + pointsManager.getHighScore());
    }

    private void generateNewNumber() {
        correctNumber = pointsManager.getRandomValue(pointsManager.getTargetNumber());
    }

    public void eraseText(JTextField field) {
        field.setText("");
    }

    public Color setRGBColor(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    public Font setCustomFont() {
        return setCustomFont(backupFontSize, Font.PLAIN);
    }

    public Font setCustomFont(float sizeOfFont, int emphasis) {
        try {
            InputStream fontStream = UI.class.getResourceAsStream("/fonts/gamefont.ttf");

            if (fontStream == null) {
                Main.error("File not found, reverting to backup Font: " + backupFont);
                return new Font(backupFont, emphasis, (int) sizeOfFont);
            }

            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            return font.deriveFont(sizeOfFont);

        } catch (Exception e) {
            e.printStackTrace();
            return new Font(backupFont, emphasis, (int) sizeOfFont);
        }
    }
}

