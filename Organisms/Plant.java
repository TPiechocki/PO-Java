/*
 * File created by Tomasz Piechocki on 2019/5/11.
 */

package pl.piechocki.po.Organisms;

import pl.piechocki.po.World.Field.Field;
import pl.piechocki.po.World.World;

import java.util.Random;

public abstract class Plant extends AbstractOrganism {
    protected double scatter_possibility;
    private Random random_generator;

    public Plant(int x, int y, World world) {
        super(x, y, world);
        scatter_possibility = 0.1;
        random_generator = new Random();
        initiative = 0;
    }

    @Override
    public void action() {
        Field field = world.getField(this.x, this.y);
        field = field.getNeighbour(direction.randomDirection());

        if (field != null && field.isEmpty() && random_generator.nextDouble() < scatter_possibility) {
            int new_x = field.getX();
            int new_y = field.getY();
            world.addOrganism((AbstractOrganism) createNewInstance(new_x, new_y, this.world));
            world.addNotification(toString() + ": Roślina się rozprzestrzeniła.");
        }
    }

    @Override
    public boolean isAnimal() {
        return false;
    }
}
