/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import javax.swing.*;
import java.awt.*;

import pl.piechocki.po.World.Directions.SquareDirection;
import pl.piechocki.po.World.Directions.changeDirection;


class UISquareBoard extends UIBoard {
    UISquareBoard(int x, int y) {
        rows = y;
        cols = x;

        setBackground(new Color(0,0,0,0));

        setLayout(new GridLayout(rows, cols,0,0));

        buttons = new JButton[rows][cols];
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < cols; i++) {
                buttons[i][j] = new JButton("");

                int top = GRID_BORDER;
                int bot = GRID_BORDER;
                int left = GRID_BORDER;
                int right = GRID_BORDER;

                // set outer border thicker to maintain proper thickness
                if (i == 0)
                    left *= 2;
                if (i == cols-1)
                    right *= 2;
                if (j == 0)
                    top *= 2;
                if (j == rows-1)
                    bot *= 2;

                buttons[i][j].setBackground(Color.white);
                buttons[i][j].setBorder(BorderFactory.createMatteBorder(top,left,bot,right, Color.black));

                add(buttons[i][j]);
            }
        }
    }

    @Override
    public void setBindings() {

        this.getInputMap(MAP).put(KeyStroke.getKeyStroke("UP"), SquareDirection.NORTH);
        this.getInputMap(MAP).put(KeyStroke.getKeyStroke("DOWN"), SquareDirection.SOUTH);
        this.getInputMap(MAP).put(KeyStroke.getKeyStroke("LEFT"), SquareDirection.WEST);
        this.getInputMap(MAP).put(KeyStroke.getKeyStroke("RIGHT"), SquareDirection.EAST);

        this.getActionMap().put(SquareDirection.NORTH, new changeDirection(player ,SquareDirection.NORTH));
        this.getActionMap().put(SquareDirection.SOUTH, new changeDirection(player ,SquareDirection.SOUTH));
        this.getActionMap().put(SquareDirection.WEST, new changeDirection(player ,SquareDirection.WEST));
        this.getActionMap().put(SquareDirection.EAST, new changeDirection(player ,SquareDirection.EAST));
    }
}
