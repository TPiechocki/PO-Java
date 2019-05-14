/*
 * File created by Tomasz Piechocki on 2019/5/13.
 */

package pl.piechocki.po.Organisms.Animals;

import pl.piechocki.po.Organisms.Animal;
import pl.piechocki.po.Organisms.Organism;
import pl.piechocki.po.Organisms.Species;
import pl.piechocki.po.World.Directions.Directions;
import pl.piechocki.po.World.Field.Field;
import pl.piechocki.po.World.World;

import java.awt.*;

public class Fox extends Animal {

    public Fox(int x, int y, World world) {
        super(x, y, world);
        strength = 3;
        initiative = 7;
        kind = Species.FOX;
    }

    @Override
    public void action() {
        Field field = world.getField(this.x, this.y);
        Directions direction = field.getDirection().randomDirection();

        // look for next field with not stronger organism starting with random direction
        for (int i = 0; i < direction.getNumberOfDirections(); ++i){
            Field target = field.getNeighbour(direction);
            if (target == null) {
                direction = direction.getNextDirection();
                ++i;
                continue;
            }
            if (target.getOrganism() == null || target.getOrganism().getStrength() <= this.strength) {      // normal action
                travel(field, direction);
                return;
            }
            else {      // check next direction
                direction.getNextDirection();
            }
        }

    }

    @Override
    public Organism createNewInstance(int x, int y, World world) {
        return new Fox(x, y, world);
    }

    @Override
    public Color color() {
        return new Color(0xFF991D);
    }

    @Override
    public String toString() {
        return "Lis";
    }
}
