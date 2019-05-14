/*
 * File created by Tomasz Piechocki on 2019/5/13.
 */

package pl.piechocki.po.Organisms.Animals;

import pl.piechocki.po.Organisms.AbstractOrganism;
import pl.piechocki.po.Organisms.Animal;
import pl.piechocki.po.Organisms.Organism;
import pl.piechocki.po.Organisms.Species;
import pl.piechocki.po.World.World;

import java.awt.*;
import java.util.Random;

public class Tortoise extends Animal {
    private final Random random;

    public Tortoise(int x, int y, World world) {
        super(x, y, world);
        strength = 2;
        initiative = 1;
        kind = Species.TORTOISE;
        random = new Random();
    }

    @Override
    public void action() {
        // Action only for 25% of turns.
        if (random.nextDouble() < 0.25)
            super.action();
    }

    @Override
    protected void collision(AbstractOrganism attacker) {
        if (attacker.getStrength() < 5) {
            attacker.setPreviousXY();

            world.addNotification(this + " odparł atak " + attacker);
        } else
            super.collision(attacker);
    }

    @Override
    public Organism createNewInstance(int x, int y, World world) {
        return new Tortoise(x, y, world);
    }

    @Override
    public Color color() {
        return new Color(0x8B4513);
    }

    @Override
    public String toString() {
        return "Żółw";
    }
}
