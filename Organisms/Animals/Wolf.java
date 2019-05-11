/*
 * File created by Tomasz Piechocki on 2019/5/11.
 */

package pl.piechocki.po.Organisms.Animals;

import pl.piechocki.po.Organisms.Animal;
import pl.piechocki.po.Organisms.Organism;
import pl.piechocki.po.Organisms.Species;
import pl.piechocki.po.World.World;

import java.awt.*;

public class Wolf extends Animal {
    public Wolf(int x, int y, World world) {
        super(x, y, world);
        initiative = 5; // TODO check these values
        strength = 9;
        kind = Species.WOLF;
    }

    @Override
    public Organism createNewInstance(int x, int y, World world) {
        return new Wolf(x, y, world);
    }

    @Override
    public Color color() {
        return Color.gray;
    }

    @Override
    public String toString() {
        return "Wilk";
    }
}
