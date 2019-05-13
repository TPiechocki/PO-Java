/*
 * File created by Tomasz Piechocki on 2019/5/13.
 */

package pl.piechocki.po.Organisms.Animals;

import pl.piechocki.po.Organisms.AbstractOrganism;
import pl.piechocki.po.Organisms.Animal;
import pl.piechocki.po.Organisms.Organism;
import pl.piechocki.po.Organisms.Species;
import pl.piechocki.po.World.Directions.Directions;
import pl.piechocki.po.World.Field.Field;
import pl.piechocki.po.World.World;

import java.awt.*;
import java.util.Random;

public class Antelope extends Animal {
    private Random random;

    public Antelope(int x, int y, World world) {
        super(x, y, world);
        strength = 4;
        initiative = 4;
        kind = Species.ANTELOPE;
        random = new Random();
    }

    @Override
    public void action() {
        Field field = world.getField(this.x, this.y);
        Directions direction = field.getDirection().randomDirection();

        for (int i = 0; i < 2 && !(this.isKilled()); i++) {
            field = world.getField(this.x, this.y);
            travel(field, direction);
        }
    }

    @Override
    protected void collision(AbstractOrganism attacker) {
        if (random.nextDouble() <= 50)
            super.collision(attacker);
        else {
            world.setOrganismOnBoard(attacker);

            Field field = world.getField(this.x, this.y);
            Field target = field.randomEmptyNeighbour();

            this.x = target.getX();
            this.y = target.getY();
            target.setOrganism(this);

        }
    }

    @Override
    public Organism createNewInstance(int x, int y, World world) {
        return null;
    }

    @Override
    public Color color() {
        return new Color(0x0042FF);
    }

    @Override
    public String toString() {
        return "Antylopa";
    }
}
