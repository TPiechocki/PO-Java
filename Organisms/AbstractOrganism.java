/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.Organisms;

import pl.piechocki.po.World.Directions.Directions;
import pl.piechocki.po.World.Field.Field;
import pl.piechocki.po.World.World;

public abstract class AbstractOrganism implements Organism, Comparable<Organism> {
    protected int x, y;
    protected int initiative, strength, age;
    protected boolean killed;
    protected World world;

    public AbstractOrganism(int x, int y, World world) {
        this.x = x;
        this.y = y;
        this.world = world;
        killed = false;
    }

    @Override
    public int compareTo(Organism org) {
        if (this.getInitiative() != org.getInitiative())
            return this.getInitiative() - org.getInitiative();
        else
            return this.getAge() - org.getAge();
    }


    @Override
    public void action() {

    }


    //GETTERS
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getInitiative() {
        return initiative;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getAge() {
        return age;
    }
}
