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
        previous_x = x;
        previous_y = y;

        if (target != null) {
            this.x = target.getX();
            this.y = target.getY();
            field.setOrganism(null);

            if (target.isEmpty()) {     // move to empty field
                target.setOrganism(this);
            } else if (target.getOrganism().getKind() == this.kind) {
                this.breed(target.getOrganism());
            }
            else {
                collision(target.getOrganism());
            }
        }
        // else - target is out of board
    }

    private void breed(AbstractOrganism other) {
        AbstractOrganism new_org;
        this.setPreviousXY();

        Field field = world.getField(other.getX(), other.getY());

        if(field.hasEmptyNeighbour())
            field = field.randomNeighbour();    // empty field within board for new organism
        else
            return;     // no breed if 'other' doesn't have empty neighbour

        new_org = (AbstractOrganism)other.createNewInstance(field.getX(), field.getY(), other.world);
        world.addOrganism(new_org);
        world.addNotification(this + ": Zwierzę się rozmnożyło.");
    }

    @Override
    public void action() {
        Field field = world.getField(this.x, this.y);
        Directions direction = field.getDirection().randomDirection();

        travel(field, direction);
    }
}
