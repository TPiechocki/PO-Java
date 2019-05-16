/*
 * File created by Tomasz Piechocki on 2019/5/15.
 */

package pl.piechocki.po.UI;

import pl.piechocki.po.World.Field.Field;

import javax.swing.*;
import java.awt.*;

class HexButton extends JButton {
    private final int SIDES = 6;
    private final int side_length;

    private final int height;
    private final int width;

    private transient Graphics2D g2;
    private final Polygon hex;

    private final Field field;

    //private final int height = 2 * SIDE_LENGTH;
    //private final int width = (int)(Math.sqrt(3) * SIDE_LENGTH);

    HexButton(String name, int height, int width, Field field) {
        super(name);
        this.height = height;
        this.width = width;
        this.side_length = width/2;

        this.field = field;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setPreferredSize(new Dimension(width, height));

        hex = new Polygon();
        for (int i = 0; i < SIDES; i++) {
            hex.addPoint((int) (side_length + side_length * Math.cos(i * 2 * Math.PI / SIDES)), //calculation for side
                    (int) (side_length + side_length * Math.sin(i * 2 * Math.PI / SIDES)));   //calculation for side
        }
    }

    public void fillHex(Color color) {
        if (g2 != null) {
            g2.setColor(color);
            g2.fill(hex);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.drawPolygon(hex);
        g2.setColor(field.color());
        g2.fill(hex);
    }
}
