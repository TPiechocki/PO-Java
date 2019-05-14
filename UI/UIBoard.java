/*
 * File created by Tomasz Piechocki on 2019/5/9.
 */

package pl.piechocki.po.UI;

import pl.piechocki.po.Organisms.Player;

import javax.swing.*;

abstract class UIBoard extends JPanel {
    int rows;
    int cols;

    final int GRID_BORDER = 1;

    JButton[][] buttons;

    Player player;

    final int MAP = JComponent.WHEN_IN_FOCUSED_WINDOW;

    public abstract void setBindings();
}
