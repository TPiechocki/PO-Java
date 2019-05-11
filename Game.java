/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po;

import pl.piechocki.po.Organisms.Animals.Sheep;
import pl.piechocki.po.Organisms.Plants.Grass;
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
    private InputMap inputMap;
    private ActionMap actionMap;

    private void newGame() {
        world = new SquareWorld(20, 20);
        world.setListeners(this);

        world.addOrganism(new Sheep(0,0, world));
        world.addOrganism(new Sheep(1,0, world));
        world.addOrganism(new Sheep(0,1, world));

        world.addOrganism(new Grass(10, 10, world));

        Player player = new Player(1,1,world);
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
