/*
 * File created by Tomasz Piechocki on 2019/5/12.
 */

package pl.piechocki.po.Organisms.Plants;

import pl.piechocki.po.Organisms.AbstractOrganism;
import pl.piechocki.po.Organisms.Organism;
import pl.piechocki.po.Organisms.Plant;
import pl.piechocki.po.Organisms.Species;
import pl.piechocki.po.World.World;

import java.awt.*;

public class Guarana extends Plant {
    public Guarana(int x, int y, World world) {
        super(x, y, world);
        strength = 0;
        kind = Species.GUARANA;
    }

    @Override
    protected void collision(AbstractOrganism attacker) {
        world.addNotification("Atakujący " + attacker + " zjada " + this + ". Siła atakującego wzrasta o 3.");

        world.setOrganismOnBoard(attacker);
        attacker.changeStrength(3);

        this.kill();
    }

    @Override
    public Organism createNewInstance(int x, int y, World world) {
        return new Guarana(x, y, world);
    }

    @Override
    public Color color() {
        return Color.red;
    }

    @Override
    public String toString() {
        return "Guarana";
    }
}
