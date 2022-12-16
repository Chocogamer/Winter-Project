package Scenes;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuScene extends JPanel implements ActionListener {
    public final Color BROWNISHCOLOR = new Color(180, 130, 100);
    // Name Panel
    public JPanel namePanel;
    public JTextField nameTextField;
    public JButton goButton;
    public String name;
    public JTextField messageTextField;
    // Second Panel
    public JPanel panel2;
    public JButton goCafeButton;
    public Color skyColor;

    public MenuScene() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Name Panel
        namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout());
        this.add(namePanel);

        nameTextField = new JTextField("Name");
        nameTextField.setPreferredSize(new Dimension(100, 50));
        namePanel.add(nameTextField);

        goButton = new JButton("Go");
        goButton.addActionListener(this);
        goButton.setPreferredSize(new Dimension(100, 50));
        namePanel.add(goButton);

        messageTextField = new JTextField();
        messageTextField.setPreferredSize(new Dimension(200, 50));
        messageTextField.setBackground(Color.WHITE);
        messageTextField.setEditable(false);
        namePanel.add(messageTextField);

        // Second Panel
        panel2 = new JPanel();
        this.add(panel2);

        goCafeButton = new JButton("Go to Cafe");
        goCafeButton.setPreferredSize(new Dimension(100, 50));
        panel2.add(goCafeButton);

        skyColor = new Color(98, 182, 183);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == goButton) {
            name = nameTextField.getText();
            nameTextField.setText("");
            messageTextField.setText("Welcome, "+name+"!");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(skyColor);
        namePanel.setBackground(BROWNISHCOLOR);
        panel2.setBackground(skyColor);
    }
}
