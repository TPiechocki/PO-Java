/*
 * File created by Tomasz Piechocki on 2019/5/11.
 */

package pl.piechocki.po.Organisms.Plants;

import pl.piechocki.po.Organisms.Organism;
import pl.piechocki.po.Organisms.Plant;
import pl.piechocki.po.Organisms.Species;
import pl.piechocki.po.World.World;

import java.awt.*;

public class Grass extends Plant {
    public Grass(int x, int y, World world) {
        super(x, y, world);
        kind = Species.GRASS;
        strength = 0;
    }

    @Override
    public Organism createNewInstance(int x, int y, World world) {
        return new Grass(x, y, world);
    }

    @Override
    public Color color() {
        return Color.green;
    }

    @Override
    public String toString() {
        return "Trawa";
    }
}
