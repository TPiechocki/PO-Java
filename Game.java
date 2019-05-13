/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po;

import pl.piechocki.po.Organisms.Animals.*;
import pl.piechocki.po.Organisms.Plants.*;
import pl.piechocki.po.Organisms.Player;
import pl.piechocki.po.World.SquareWorld;
import pl.piechocki.po.World.World;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * General app controler
 */
public class Game implements ActionListener {
    private World world;

    private void newGame() {
        world = new SquareWorld(20, 20);
        world.setListeners(this);

        world.addOrganism(new Sheep(0,0, world));
        world.addOrganism(new Sheep(1,0, world));
        world.addOrganism(new Sheep(0,1, world));
        world.addOrganism(new Wolf(19,  19, world));
        world.addOrganism(new Fox(18, 19, world));
        world.addOrganism(new Tortoise(5, 8, world));
        world.addOrganism(new Antelope(2,2, world));

        world.addOrganism(new Grass(10, 10, world));
        world.addOrganism(new Dandelion(12, 12, world));
        world.addOrganism(new Guarana(1,2, world));
        world.addOrganism(new Belladonna(5, 2, world));
        world.addOrganism(new Hogweed(0, 15, world));

        Player player = new Player(6,8,world);
        world.setPlayer(player);
        world.addOrganism(player);

        world.displayWorld();
    }

    Game() {
        newGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String name = "";

        if (obj instanceof JButton) {
            JButton button = (JButton) obj;
             name = button.getName();

            if (name.equals("turn")) {
                world.makeTurn();
            }

            if (name.equals("new_game")) {
                world.closeWindow();
                newGame();
            }
        }
    }
}
