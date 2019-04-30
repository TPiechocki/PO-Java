/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import pl.piechocki.po.Game;
import pl.piechocki.po.World.Field.Field;

import javax.swing.*;
import java.awt.*;

public class UIWindow extends JFrame {

    private final String WINDOW_TITLE = "Tomasz Piechocki - 175690";

    // Windows dimensions
    private int WINDOW_HEIGHT = 720;
    private int WINDOW_WIDTH = 1280;

    private UISquareBoard board;
    private UIInfo panel;
    private UINotifications notifications;

    public UIWindow(boolean square, int x, int y) {
        // window properties
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(WINDOW_TITLE);
        setLocationRelativeTo(null);

        // background colour
        getContentPane().setBackground(Color.lightGray);

        if (square)
            board = new UISquareBoard(x, y);

        panel = new UIInfo();

        notifications = new UINotifications();

        add(board, BorderLayout.CENTER);
        add(panel, BorderLayout.EAST);
        add(notifications, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Draw fields with proper colouring
     */
    public void drawFields(Field[][] fields) {
        for (int y = 0; y < board.rows; y++) {
            for (int x = 0; x < board.cols; x++) {
                board.buttons[x][y].setBackground(fields[x][y].color());
            }
        }
    }

    public void setListeners(Game game) {
        panel.turn_button.addMouseListener(game);
    }
}
