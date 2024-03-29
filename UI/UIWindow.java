/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import pl.piechocki.po.Game;
import pl.piechocki.po.Organisms.Player;
import pl.piechocki.po.World.Field.Field;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class UIWindow extends JFrame {

    private final String WINDOW_TITLE = "Tomasz Piechocki - 175690";

    // Windows dimensions
    private final int WINDOW_HEIGHT = 720;
    private final int WINDOW_WIDTH = 1280;

    private final UIBoard board;
    private final UIInfo panel;
    private final UINotifications notifications;

    public UIWindow(boolean square, int x, int y, Field[][] fields) {
        // window properties
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(WINDOW_TITLE);
        setLocationRelativeTo(null);

        // background colour
        getContentPane().setBackground(Color.lightGray);

        if (square)
            board = new UISquareBoard(x, y);
        else
            board = new UIHexBoard(x, y, fields);

        panel = new UIInfo();

        notifications = new UINotifications();

        add(board, BorderLayout.CENTER);
        add(panel, BorderLayout.EAST);
        add(notifications, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void closeWindow() {
        setVisible(false);
    }

    public void openWindow() {
        setVisible(true);
    }

    /**
     * Draw fields with proper colouring
     */
    public void drawFields(Field[][] fields) {
        for (int y = 0; y < board.rows; y++) {
            for (int x = 0; x < board.cols; x++) {
                if (board.buttons[x][y] != null)
                    if (board instanceof UIHexBoard) {
                        repaint();
                        return;
                    }
                    else
                        board.buttons[x][y].setBackground(fields[x][y].color());
            }
        }
    }

    public void refreshInfo() {
        if (board.player.isImmortalityReady() && !(board.player.isKilled()))
            panel.skill.setEnabled(true);
        else
            panel.skill.setEnabled(false);

        panel.skill_end.setText(board.player.immortaltalityStatus());

        panel.revalidate();
        panel.repaint();
    }

    /**
     * Stop displaying notifications so list can be modified
     */
    public void stopNotifications() {
        notifications.stopNotifications();
    }

    /**
     * Display notifications
     * @param msg list of notifications
     */
    public void displayNotification(LinkedList<String> msg) {
        notifications.renderNotifications(msg);
    }

    public void setListeners(Game game) {
        panel.turn_button.addActionListener(game);
        panel.new_button.addActionListener(game);
        panel.skill.addActionListener(game);
        panel.save.addActionListener(game);
        panel.load.addActionListener(game);

        for (int i = 0; i < board.cols; i++)
            for (int j = 0; j < board.rows; j++)
                if (board.buttons[i][j] != null)
                    board.buttons[i][j].addActionListener(game);
    }

    public void setPlayer(Player player) {
        board.player = player;
        board.setBindings();
    }
}
