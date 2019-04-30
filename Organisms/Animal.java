/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.Organisms;

import pl.piechocki.po.World.Directions.Directions;
import pl.piechocki.po.World.Field.Field;
import pl.piechocki.po.World.World;

public abstract class Animal extends AbstractOrganism {
    public Animal(int x, int y, World world) {
        super(x, y, world);
    }

    /**
     * @param field where organism is now
     * @param direction of move
     */
    private void travel(Field field, Directions direction) {
        Field target = field.getNeighbour(direction);

        if (target != null) {
            if (target.isEmpty()) {     // move to empty field
                field.setOrganism(null);
                target.setOrganism(this);

                this.x = target.getX();
                this.y = target.getY();
            }   // TODO else collision etc.
        }
        // else - target is out of board
    }

    @Override
    public void action() {
        Field field = world.getField(this.x, this.y);
        Directions direction = field.getDirection().randomDirection();

        travel(field, direction);
    }
}
