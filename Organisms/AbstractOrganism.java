/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.Organisms;

import pl.piechocki.po.World.Directions.Directions;
import pl.piechocki.po.World.Field.Field;
import pl.piechocki.po.World.World;

import java.io.Serializable;

public abstract class AbstractOrganism implements Organism, Comparable<Organism>, Serializable {
    protected Species kind;
    protected int x;
    protected int y;
    int previous_x;
    int previous_y;
    protected int initiative;
    protected int strength;
    int age;
    private boolean killed;
    protected final World world;
    Directions direction;

    AbstractOrganism(int x, int y, World world) {
        this.x = x;
        this.y = y;
        this.world = world;
        killed = false;
        direction = world.getField(x,y).getDirection();
    }

    /**
     * Collision of two organisms of different species
     * @param attacker organism which attack
     */
    protected void collision(AbstractOrganism attacker) {
        if (attacker.getStrength() < getStrength()) {
            world.addNotification("Broniący się " + this + " zabija " + attacker);
            world.setOrganismOnBoard(this);
            attacker.kill();
        } else {
            world.addNotification("Atakujący " + attacker + " zabija " + this);
            world.setOrganismOnBoard(attacker);
            this.kill();
        }
    }

    public void kill() {
        this.killed = true;
    }

    @Override
    public void setPreviousXY() {
        x = previous_x;
        y = previous_y;
        Field field = world.getField(x, y);
        if (field.isEmpty()) {
            field.setOrganism(this);
        } else
            try {
                throw new Exception("Organism can't go back to previous location");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Override
    public Species getKind() {
        return kind;
    }

    @Override
    public void changeStrength(int x) {
        strength += x;
    }

    @Override
    public void addOneAge() {
        age++;
    }

    @Override
    public int compareTo(Organism org) {
        if (this.getInitiative() != org.getInitiative())
            return org.getInitiative() - this.getInitiative();
        else
            return  org.getAge() - this.getAge();
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

    @SuppressWarnings("unused")
    @Override
    public Directions getDirection() {
        return direction;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean isKilled() {
        return killed;
    }
}
