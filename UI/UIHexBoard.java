/*
 * File created by Tomasz Piechocki on 2019/5/15.
 */

package pl.piechocki.po.UI;

import pl.piechocki.po.World.Directions.HexDirection;
import pl.piechocki.po.World.Directions.changeDirection;
import pl.piechocki.po.World.Field.Field;

import javax.swing.*;
import java.awt.*;

public class UIHexBoard extends UIBoard {
    UIHexBoard(int x, int y, Field[][] fields) {
        rows = y;
        cols = x;

        setBackground(new Color(0,0,0,0));
        setLayout(null);

        int side = Math.min((int)(400/rows*(3.0/2)), (int) ((1000)/(Math.sqrt(3)*cols)));

        int height = (int)(Math.sqrt(3) * side);
        int width = 2*side;


        int offsetX = 50;
        int offsetY = 50;

        buttons = new HexButton[cols][rows];

        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {
                if ((i + j) % 2 == 0) {
                    buttons[i][j] = new HexButton("", height, width, fields[i][j]);

                    buttons[i][j].setName(i + "," + j);

                    int top = GRID_BORDER;
                    int bot = GRID_BORDER;
                    int left = GRID_BORDER;
                    int right = GRID_BORDER;

                    // set outer border thicker to maintain proper thickness
                    if (i == 0)
                        left *= 2;
                    if (i == cols - 1)
                        right *= 2;
                    if (j == 0)
                        top *= 2;
                    if (j == rows - 1)
                        bot *= 2;

                    //buttons[i][j].setBackground(Color.white);
                    buttons[i][j].setBorder(BorderFactory.createMatteBorder(top,left,bot,right, Color.black));

                    add(buttons[i][j]);
                    buttons[i][j].setBounds(offsetX, offsetY, (int)(1.05 * width), (int)(1.15 *height));
                    offsetX += (int)(3.0/2 * width);
                }
                else {
                    buttons[i][j] = null;
                }
            }
            if (j % 2 == 0)
                offsetX = (int)(3.0/4 * width) + 50;
            else
                offsetX = 50;
            offsetY += height/2;
        }
    }

    @Override
    public void setBindings() {
        this.getInputMap(MAP).put(KeyStroke.getKeyStroke("W"), HexDirection.NORTH);
        this.getInputMap(MAP).put(KeyStroke.getKeyStroke("E"), HexDirection.NORTHEAST);
        this.getInputMap(MAP).put(KeyStroke.getKeyStroke("D"), HexDirection.SOUTHEAST);
        this.getInputMap(MAP).put(KeyStroke.getKeyStroke("S"), HexDirection.SOUTH);
        this.getInputMap(MAP).put(KeyStroke.getKeyStroke("A"), HexDirection.SOUTHWEST);
        this.getInputMap(MAP).put(KeyStroke.getKeyStroke("Q"), HexDirection.NORTHWEST);

        this.getActionMap().put(HexDirection.NORTH, new changeDirection(player ,HexDirection.NORTH));
        this.getActionMap().put(HexDirection.NORTHEAST, new changeDirection(player ,HexDirection.NORTHEAST));
        this.getActionMap().put(HexDirection.SOUTHEAST, new changeDirection(player ,HexDirection.SOUTHEAST));
        this.getActionMap().put(HexDirection.SOUTH, new changeDirection(player ,HexDirection.SOUTH));
        this.getActionMap().put(HexDirection.SOUTHWEST, new changeDirection(player ,HexDirection.SOUTHWEST));
        this.getActionMap().put(HexDirection.NORTHWEST, new changeDirection(player ,HexDirection.NORTHWEST));
    }
}
