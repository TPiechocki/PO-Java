/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import javax.swing.*;
import java.awt.*;

class UISquareBoard extends JPanel {
    int rows, cols;

    private int GRID_BORDER = 1;

    JButton[][] buttons;

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
}
