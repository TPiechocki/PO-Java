/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import javax.swing.*;
import java.awt.*;

public class UIWindow extends JFrame {

    private final String WINDOW_TITLE = "Tomasz Piechocki - 175690";

    // Windows dimensions
    private int WINDOW_HEIGHT = 720;
    private int WINDOW_WIDTH = 1280;

    public UIWindow() {
        // window properties
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(WINDOW_TITLE);
        setLocationRelativeTo(null);

        // background colour
        getContentPane().setBackground(Color.lightGray);

        UISquareBoard board = new UISquareBoard();

        UIInfo panel = new UIInfo();

        UINotifications notifications = new UINotifications();

        add(board, BorderLayout.CENTER);
        add(panel, BorderLayout.EAST);
        add(notifications, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
