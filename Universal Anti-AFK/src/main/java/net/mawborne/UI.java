package net.mawborne;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.Getter;

public class UI extends JFrame {
    private static final Logger LOGGER = LogManager.getLogger(UI.class);

    private static final int UI_WIDTH = 200;
    private static final int UI_HEIGHT = 200;

    private String uiTitle;
    @Getter private int sliderValue = 2; // Default value
    private Consumer<Boolean> toggleCallback;

    public UI(String title) {
        this.uiTitle = title;

        initializeUI();
    };

    public void setToggleListener(Consumer<Boolean> callback) {
        this.toggleCallback = callback;
    }

    private void initializeUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        this.setLayout(null);
        this.getContentPane().setBackground(new Color(10, 10, 10));

        // Title Label
        JLabel insideTitle = new JLabel(uiTitle);
        insideTitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
        insideTitle.setForeground(new Color(225, 225, 225));
        insideTitle.setBounds(8, -3, 200, 25);
        this.add(insideTitle);

        // Movement Intervals Label
        JLabel movementClock = new JLabel("Movement Intervals: " + sliderValue + " min(s)");
        movementClock.setFont(new Font("Segoe UI", Font.BOLD, 12));
        movementClock.setForeground(new Color(225, 225, 225));
        movementClock.setBounds(3, 138, 200, 25);
        this.add(movementClock);

        // Toggle Button
        JToggleButton toggleButton = new JToggleButton("Enable");
        toggleButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        toggleButton.setBackground(new Color(225, 225, 225));
        toggleButton.setFocusPainted(false);
        toggleButton.setBounds(42, 30, 100, 35);

        toggleButton.addActionListener(e -> {
            boolean isEnabled = toggleButton.isSelected();

            if (isEnabled) {
                toggleButton.setText("Disable");
                toggleButton.setForeground(new Color(200, 0, 0));
            } else {
                toggleButton.setText("Enable");
                toggleButton.setForeground(Color.BLACK);
            }

            if (toggleCallback != null) {
                toggleCallback.accept(isEnabled);
            }
        });
        this.add(toggleButton);

        // Slider Label
        JLabel sliderLabel = new JLabel("Intervals (Minutes)");
        sliderLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        sliderLabel.setForeground(new Color(225, 225, 225));
        sliderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sliderLabel.setBounds(-9, 75, 200, 20);
        this.add(sliderLabel);

        // Movement Slider
        JSlider movementSlider = new JSlider(JSlider.HORIZONTAL, 1, 20, 2);
        movementSlider.setBounds(22, 95, 140, 45);
        movementSlider.setBackground(new Color(10, 10, 10));
        movementSlider.setForeground(new Color(200, 200, 200));
        movementSlider.setPaintTicks(true);
        movementSlider.setSnapToTicks(false);
        movementSlider.setFocusable(false);
        movementSlider.setOpaque(false);

        movementSlider.addChangeListener(e -> {
            movementClock.setText("Movement Intervals: " + movementSlider.getValue() + " min(s)");
            movementSlider.setToolTipText(movementSlider.getValue() + " minutes");

            sliderValue = movementSlider.getValue();
            this.repaint(); // Fixes glitching in slider bar
        });
        this.add(movementSlider);

        // Window Settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setSize(UI_WIDTH, UI_HEIGHT);
        this.setTitle(uiTitle);
        this.setIconImage(loadImageSafely("/assets/ak-47.png"));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private static Image loadImageSafely(String path) {
        try (InputStream icon = UI.class.getResourceAsStream(path)) {
            if (icon == null) {
                throw new IllegalArgumentException("Image not found: " + path);
            }

            return ImageIO.read(icon);
        } catch (IOException err) {
            LOGGER.error("Image failed to load: {}, Cause: {}", err.getMessage(), err.getCause());
            return null;
        }
    }
}
