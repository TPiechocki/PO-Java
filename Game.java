/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po;

import pl.piechocki.po.World.SquareWorld;
import pl.piechocki.po.World.World;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * General app controler
 */
public class Game implements MouseListener {
    private World world;

    Game() {
        world = new SquareWorld(20, 20);
        world.setListeners(this);

        world.displayWorld();
    }

    /**
     * Catch mouse events
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton)e.getSource();

        String name = button.getName();

        if (SwingUtilities.isLeftMouseButton(e)) {
            if (name.equals("turn")) {
                world.makeTurn();
            }
        }
    }


    // EMPTY FUNCTIONS
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
