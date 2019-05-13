/*
 * File created by Tomasz Piechocki on 2019/5/13.
 */

package pl.piechocki.po.Organisms.Plants;

import pl.piechocki.po.Organisms.AbstractOrganism;
import pl.piechocki.po.Organisms.Organism;
import pl.piechocki.po.Organisms.Plant;
import pl.piechocki.po.Organisms.Species;
import pl.piechocki.po.World.Field.Field;
import pl.piechocki.po.World.World;

import java.awt.*;

public class Hogweed extends Plant {
    public Hogweed(int x, int y, World world) {
        super(x, y, world);
        strength = 10;
        kind = Species.HOGWEED;
    }

    @Override
    public void action() {
        Field[] neighbours = world.getField(this.x, this.y).getFullNeighbours();

        for (Field neighbour : neighbours) {
            if (neighbour.getOrganism() != null && neighbour.getOrganism().isAnimal()) {
                Organism temp = neighbour.getOrganism();

                world.addNotification(this + " zatruł " + temp);

                temp.kill();
                world.getField(temp.getX(), temp.getY()).setOrganism(null);
            }
        }
        super.action();
    }

    @Override
    protected void collision(AbstractOrganism attacker) {
        world.addNotification(attacker + " został zatruty przez " + this);

        world.getField(this.x, this.y).setOrganism(null);

        attacker.kill();
        this.kill();
    }

    @Override
    public Organism createNewInstance(int x, int y, World world) {
        return new Hogweed(x, y, world);
    }

    @Override
    public Color color() {
        return new Color(0xE500FF);
    }

    @Override
    public String toString() {
        return "Barszcz Sosnowskiego";
    }
}