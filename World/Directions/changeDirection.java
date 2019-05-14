/*
 * File created by Tomasz Piechocki on 2019/5/9.
 */

package pl.piechocki.po.World.Directions;

import pl.piechocki.po.Organisms.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class changeDirection extends AbstractAction {
    private final Player player;
    private final Directions direction;

    public changeDirection(Player player, Directions dir) {
        this.player = player;
        this.direction = dir;
        if (dir instanceof SquareDirection) {
            System.out.println("Square");
        } else {
            System.out.println("Not Square");
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        player.setDirection(direction);
    }
}
