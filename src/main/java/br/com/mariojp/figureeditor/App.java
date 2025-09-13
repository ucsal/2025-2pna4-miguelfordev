package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;
import br.com.mariojp.factory.*;
import br.com.mariojp.Colors.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Figure Editor — Clique para inserir figuras");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            DrawingPanel panel = new DrawingPanel();
            
            JComboBox<String> shapeSelector = new JComboBox<>(new String[]{"Círculo", "Quadrado", "Triângulo"});
            JComboBox<String> colorSelector = new JComboBox<>(new String[]{"Azul", "Vermelho", "Verde"});

            shapeSelector.addActionListener(e -> {
                switch ((String) shapeSelector.getSelectedItem()) {
                    case "Círculo" -> panel.setShapeFactory(new CircleFactory());
                    case "Quadrado" -> panel.setShapeFactory(new SquareFactory());
                    case "Triângulo" -> panel.setShapeFactory(new TriangleFactory());
                }
            });

            colorSelector.addActionListener(e -> {
                switch ((String) colorSelector.getSelectedItem()) {
                    case "Azul" -> panel.setColorStrategy(new BlueColorStrategy());
                    case "Vermelho" -> panel.setColorStrategy(new RedColorStrategy());
                    case "Verde" -> panel.setColorStrategy(new GreenColorStrategy());
                }
            });

            JPanel controls = new JPanel();
            controls.add(new JLabel("Forma:"));
            controls.add(shapeSelector);
            controls.add(new JLabel("Cor:"));
            controls.add(colorSelector);

            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.CENTER);
            frame.add(controls, BorderLayout.NORTH);

            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
