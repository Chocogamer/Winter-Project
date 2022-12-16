package Scenes;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public abstract class Snowy extends JPanel implements ActionListener {
    private ArrayList<Snowball> snowballs;

    public Snowy() {
        snowballs = new ArrayList<Snowball>();
        Random rand = new Random();

        ActionListener timer1Listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                snowballs.add(new Snowball(rand.nextInt(getWidth()), 0));
                if(snowballs.size()  > 400) {
                    snowballs.remove(0);
                }
            }
        };

        ActionListener timer2Listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                for(Snowball s : snowballs) {
                    s.y += 2;
                    if(s.inflection >= 0) {
                      if(s.inflection == 5) {
                        s.inflection = -5;
                      }
                      s.x += 1;
                      s.inflection++;
                    }
                    if(s.inflection >= -5) {
                      if(s.inflection == -1) {
                        s.inflection = 0;
                      }
                      s.x -= 1;
                      s.inflection++;
                    }
                }
                repaint();
            }
        };

        Timer timer1 = new Timer(200, timer1Listener);
        timer1.start();

        Timer timer2 = new Timer(20, timer2Listener);
        timer2.start();
    }

    class Snowball {
        int x;
        int y;
        int inflection;
        Snowball(int x, int y) {
            this.x = x;
            this.y = y;
            inflection = 0;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        for(Snowball s : snowballs) {
            g.fillOval(s.x, s.y, 10, 10);
        }
    }

}