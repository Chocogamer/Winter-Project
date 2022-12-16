import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Drink {
    private String name;
    private Color artificialColoring;
    private boolean hasIce;
    private boolean hasBoba;
    private boolean hasWhippedCream;

    public Drink(String name, Color artificialColoring, boolean hasIce, boolean hasBoba, boolean hasWhippedCream) {
        this.name = name;
        this.artificialColoring = artificialColoring;
        this.hasIce = hasIce;
        this.hasBoba = hasBoba;
        this.hasWhippedCream = hasWhippedCream;
    }
}
