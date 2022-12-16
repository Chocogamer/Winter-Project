package Scenes;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.*;

public class CreateScene extends JPanel implements ActionListener {
    // Northern Panel
    private JPanel topPanel;
    private JButton drinkColorButton;
    private JButton iceButton;
    private JButton bobaButton;
    private JButton whippedCreamButton;
    // Central Panel
    private CentralPanel centralPanel;
    // Southern Panel
    private JPanel bottomPanel;
    private JButton trashButton;
    private JButton finishButton;
    private final Color BROWNISHCOLOR = new Color(180, 130, 100);

    public CreateScene() {
        this.setLayout(new BorderLayout());

        // Northern Panel
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 2));
        this.add(topPanel, BorderLayout.NORTH);

        drinkColorButton = new JButton("Add Artificial Coloring");
        drinkColorButton.addActionListener(this);
        drinkColorButton.setBackground(BROWNISHCOLOR);
        topPanel.add(drinkColorButton);

        iceButton = new JButton("Add Ice");
        iceButton.addActionListener(this);
        iceButton.setBackground(BROWNISHCOLOR);
        topPanel.add(iceButton);

        bobaButton = new JButton("Add Boba");
        bobaButton.addActionListener(this);
        bobaButton.setBackground(BROWNISHCOLOR);
        topPanel.add(bobaButton);

        whippedCreamButton = new JButton("Add Whipped Cream");
        whippedCreamButton.addActionListener(this);
        whippedCreamButton.setBackground(BROWNISHCOLOR);
        topPanel.add(whippedCreamButton);

        // Central Panel
        centralPanel = new CentralPanel();
        this.add(centralPanel, BorderLayout.CENTER);
        
        // Southern Panel
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2));
        this.add(bottomPanel, BorderLayout.SOUTH);

        trashButton = new JButton("Trash");
        trashButton.setBackground(Color.RED);
        bottomPanel.add(trashButton);

        finishButton = new JButton("Finish");
        finishButton.setBackground(Color.GREEN);
        finishButton.addActionListener(this);
        bottomPanel.add(finishButton);
    }

    public void actionPerformed(ActionEvent event) {
        Object e = event.getSource();
        if(e == drinkColorButton) {
            JColorChooser colorChooser = new JColorChooser();
            Color c = JColorChooser.showDialog(colorChooser, "Choose", Color.BLACK);
            centralPanel.setDrinkColor(c);
            centralPanel.setIsStarting(true);
        }
        if(e == bobaButton) {
            centralPanel.setBobaMode(true);
        }
        if(e == finishButton) {
            centralPanel.setIsFinished(true);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    class CentralPanel extends JPanel {
        private Timer fillTimer;
        private Color drinkColor;
        private boolean isStarting;
        private int offSet;
        private boolean bobaMode;
        private Random rand;
        private boolean isFinished;
        private boolean isTrashed;
        private final Color BROWNISHCOLOR2 = new Color(230, 180, 150);

        public CentralPanel() {

            drinkColor = Color.BLACK;
            isStarting = false;
            offSet = 0;
            bobaMode = false;
            rand = new Random();
            isFinished = false;
            isTrashed = false;

            ActionListener fillTimerListener = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    if(offSet >= 175) {
                        fillTimer.stop();
                    }
                    offSet += 1;
                    repaint();
                }
            };

            fillTimer = new Timer(1, fillTimerListener);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            this.setBackground(BROWNISHCOLOR2);

            // Makes center of panel the origin
            g.translate(this.getWidth()/2, this.getHeight()/2);
            // Draws cup
            int cupWidth = 100;
            int cupHeight = 200;
            g.setColor(Color.WHITE);
            g.fillRoundRect(0 - cupWidth/2, 0 - cupHeight/2, cupWidth, cupHeight, 20, 20);

            if(isStarting) {
                g.setColor(drinkColor);
                g.fillRect(0 - cupWidth/2, 0 + cupHeight/2 - offSet, cupWidth, offSet);
            }

            if(bobaMode) {
                g.setColor(Color.BLACK);
                for(int i = 0; i < 15; i++) {
                    g.fillOval(rand.nextInt(cupWidth-10) - cupWidth/2, 0 + cupHeight/2 - 10, 10, 10);
                }
            }

            if(isFinished) {
                g.setColor(Color.BLACK);
                // straw
                int strawWidth = 10;
                int strawHeight = 250;
                g.fillRect(0 - strawWidth/2, 0 - strawHeight + cupHeight/2, strawWidth, strawHeight);
            }

            if(isTrashed) {
                //
            }
        }

        public void setDrinkColor(Color c) {
            drinkColor = c;
        }

        public void setIsStarting(boolean b) {
            isStarting = b;
            if(isStarting) {
                fillTimer.start();
            } 
            repaint();
        }

        public void setBobaMode(boolean b) {
            bobaMode = b;
            repaint();
        }

        public void setIsFinished(boolean b) {
            isFinished = b;
            repaint();
        }

        public void setIsTrashed(boolean b) {
            isTrashed = b;
            repaint();
        }

    }
}
