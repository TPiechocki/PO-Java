/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po;

import pl.piechocki.po.Organisms.Animals.Sheep;
import pl.piechocki.po.World.SquareWorld;
import pl.piechocki.po.World.World;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * General app controler
 */
public class Game implements ActionListener {
    private World world;

    Game() {
        world = new SquareWorld(20, 20);
        world.setListeners(this);

        world.addOrganism(new Sheep(0,0, world));
        world.addOrganism(new Sheep(1,0, world));

        world.displayWorld();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String name = "";

        if (obj instanceof JButton) {
            JButton button = (JButton) obj;
             name = button.getName();
        }

        if (name.equals("turn")) {
            world.makeTurn();
        }
    }
}
