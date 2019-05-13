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

public class Belladonna extends Plant {
    public Belladonna(int x, int y, World world) {
        super(x, y, world);
        strength = 99;
        kind = Species.BELLADONNA;
    }

    @Override
    protected void collision(AbstractOrganism attacker) {
        world.addNotification(attacker + " został zatruty przez " + this);

        world.getField(this.x, this.y).setOrganism(null);

        attacker.kill();
        this.kill();
    }

    @Override
    public Organism createNewInstance(int x, int y, World world) {
        return new Belladonna(x, y, world);
    }

    @Override
    public Color color() {
        return new Color(135, 19, 255);
    }

    @Override
    public String toString() {
        return "Wilcza jagoda";
    }
}
