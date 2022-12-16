package Scenes;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class StartScene extends Snowy {
    public JLabel titleLabel;
    public JButton startButton;
    public Color skyColor;
    public Image bobaImage;
    private boolean bobaImageMovingLeft;
    private int bobaImageOffset;

    public StartScene() {
        super();
        this.setLayout(new BorderLayout());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      
        titleLabel = new JLabel("Winter Project");
        titleLabel.setPreferredSize(new Dimension(200, 200));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("Lobster", Font.PLAIN, 50));
        this.add(titleLabel);
      
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(200, 200));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(startButton);

        skyColor = new Color(98, 182, 183);

        try {
            bobaImage = ImageIO.read(new File("boba.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }


        bobaImageMovingLeft = true;
        bobaImageOffset = 0;

        ActionListener timerListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if((bobaImageOffset == -50) || (bobaImageOffset == 50)) {
                    bobaImageMovingLeft = !bobaImageMovingLeft;
                }
                if(bobaImageMovingLeft) {
                    bobaImageOffset -= 1;
                } else {
                    bobaImageOffset += 1;
                }
                repaint();
            }
        };

        Timer timer = new Timer(1, timerListener);
        timer.start();

    }

    public void actionPerformed(ActionEvent event) {}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(skyColor);
        g.drawImage(bobaImage, this.getWidth()/2 - (bobaImage.getWidth(this)/2) + bobaImageOffset, this.getHeight()/2 - (bobaImage.getHeight(this)/2), this);
    }

}