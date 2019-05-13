/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.Organisms.Animals;

import pl.piechocki.po.Organisms.Animal;
import pl.piechocki.po.Organisms.Organism;
import pl.piechocki.po.Organisms.Species;
import pl.piechocki.po.World.World;

import java.awt.*;

public class Sheep extends Animal {
    public Sheep(int x, int y, World world) {
        super(x, y, world);
        strength = 4;
        initiative = 4;
        kind = Species.SHEEP;
    }

    @Override
    public Organism createNewInstance(int x, int y, World world) {
        return new Sheep(x, y, world);
    }

    @Override
    public Color color() {
        return new Color(141, 224, 255, 255);
    }

    @Override
    public String toString() {
        return "Owca";
    }
}
