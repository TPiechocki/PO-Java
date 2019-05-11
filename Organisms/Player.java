/*
 * File created by Tomasz Piechocki on 2019/5/9.
 */

package pl.piechocki.po.Organisms;

import pl.piechocki.po.World.Directions.Directions;
import pl.piechocki.po.World.Field.Field;
import pl.piechocki.po.World.World;

import java.awt.*;

public class Player extends Animal {
        public Player(int x, int y, World world) {
        super(x, y, world);
        strength = 5;
        initiative = 4;
        kind = Species.HUMAN;
    }

    public void setDirection(Directions dir) {
        this.direction = dir;
        world.stopNotifications();
        world.addPriorityNotification("Zmieniono kierunek");
        world.displayNotifications();
    }

    @Override
    public Organism createNewInstance(int x, int y, World world) {
        return new Player(x, y, world);
    }

    @Override
    public void action() {
        Field field = world.getField(this.x, this.y);
        travel(field, direction);
    }

    @Override
    public Color color() {
        return Color.black;
    }

    @Override
    public String toString() {
        return "Człowiek";
    }
}
