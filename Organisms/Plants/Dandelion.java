/*
 * File created by Tomasz Piechocki on 2019/5/12.
 */

package pl.piechocki.po.Organisms.Plants;

import pl.piechocki.po.Organisms.Organism;
import pl.piechocki.po.Organisms.Plant;
import pl.piechocki.po.Organisms.Species;
import pl.piechocki.po.World.World;

import java.awt.*;

public class Dandelion extends Plant {
    public Dandelion(int x, int y, World world) {
        super(x, y, world);
        strength = 0;
        kind = Species.DANDELION;
    }

    @Override
    public void action() {
        for (int i = 0; i < 3; ++i)
            super.action();
    }

    @Override
    public Organism createNewInstance(int x, int y, World world) {
        return new Dandelion(x, y, world);
    }

    @Override
    public Color color() {
        return Color.yellow;
    }

    @Override
    public String toString() {
        return "Mlecz";
    }
}
