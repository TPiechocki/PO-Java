/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.Organisms;

import pl.piechocki.po.World.Field.Field;
import pl.piechocki.po.World.World;

public abstract class AbstractOrganism implements Organism, Comparable<Organism> {
    protected Species kind;
    protected int x, y, previous_x, previous_y;
    protected int initiative, strength, age;
    protected boolean killed;
    protected World world;

    protected void kill() {
        this.killed = true;
    }

    AbstractOrganism(int x, int y, World world) {
        this.x = x;
        this.y = y;
        this.world = world;
        killed = false;
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
            return this.getInitiative() - org.getInitiative();
        else
            return this.getAge() - org.getAge();
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

    @Override
    public boolean isKilled() {
        return killed;
    }
}
