import java.awt.event.*;
import javax.swing.*;

import Scenes.CreateScene;
import Scenes.MenuScene;
import Scenes.StartScene;

public class GUI implements ActionListener {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem exitMenuItem;
    private StartScene startScenePanel;
    private MenuScene menuScenePanel;
    private CreateScene createScenePanel;
    
    public GUI() {
        frame = new JFrame("Winter Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        menu = new JMenu("Menu");
        menuBar.add(menu);

        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(this);
        menu.add(exitMenuItem);

        startScenePanel = new StartScene();
        startScenePanel.startButton.addActionListener(this);
        frame.add(startScenePanel);

        menuScenePanel = new MenuScene();
        menuScenePanel.goCafeButton.addActionListener(this);

        createScenePanel = new CreateScene();

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object e = event.getSource();
        if(e == exitMenuItem) {
            System.exit(0);
        }
        if(e == startScenePanel.startButton) {
            // Transitions from StartScene to MenuScene
            frame.setVisible(false);
            frame.remove(startScenePanel);
            frame.add(menuScenePanel);
            frame.setVisible(true);
        }
        if(e == menuScenePanel.goCafeButton) {
            // Transitions from MenuScene to CreateScene
            frame.setVisible(false);
            frame.remove(menuScenePanel);
            frame.add(createScenePanel);
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }

}