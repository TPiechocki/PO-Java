/*
 * File created by Tomasz Piechocki on 2019/5/9.
 */

package pl.piechocki.po.Organisms;

import pl.piechocki.po.World.Directions.Directions;
import pl.piechocki.po.World.Field.Field;
import pl.piechocki.po.World.World;

import java.awt.*;

public class Player extends Animal {
    private int immortality_end;        // stores age at which immortality will end

    public Player(int x, int y, World world) {
        super(x, y, world);
        strength = 5;
        initiative = 4;
        kind = Species.HUMAN;
        immortality_end = -10;
    }

    public void setDirection(Directions dir) {
        this.direction = dir;
        world.stopNotifications();
        world.addPriorityNotification("Zmieniono kierunek");
        world.displayNotifications();
    }

    public void activateImmortality() {
        if (immortality_end < age - 5) {
            immortality_end = age + 5;
            world.addPriorityNotification("Nieśmiertelność aktywowana");
        } else if (immortality_end >= age) {
            world.addPriorityNotification("Nieśmiertelność jeszcze aktywna przez " + (immortality_end - age) + " tur.");
        } else {
            world.addPriorityNotification("Nie możesz jeszcze aktywować nieśmiertelności. Możliwe za " + (immortality_end + 5 - age + 1) + " tur.");
        }
    }

    public boolean isImmortalityReady() {
        return immortality_end < age - 5;
    }

    public String immortaltalityStatus() {
        if (immortality_end < age - 5) {
            return "";
        } else if (immortality_end >= age) {
            return "Niesmiertelnosc jeszcze aktywna przez " + (immortality_end - age) + " tur.";
        } else {
            return "<html><body style='text-align: center'>Nie możesz jeszcze aktywować nieśmiertelności. <br /> " +
                    "Możliwe za " + (immortality_end + 5 - age + 1) + " tur.</html>";
        }
    }

    @Override
    public void kill() {
        if (immortality_end >= age) {
            world.addNotification("Ale dzięki nieśmiertelności człowiek przeżył.");

            if (world.getField(this.x, this.y).isEmpty())
                world.setOrganismOnBoard(this);
            else {
                Field field = world.getField(this.x, this.y);
                Field target = field.randomEmptyNeighbour();

                this.x = target.getX();
                this.y = target.getY();
                target.setOrganism(this);
            }
        } else {
            super.kill();
        }
    }

    @Override
    public Organism createNewInstance(int x, int y, World world) {
        return new Player(x, y, world);
    }

    @Override
    public void action() {
        Field field = world.getField(this.x, this.y);
        travel(field, direction);
    }

    @Override
    public Color color() {
        return Color.black;
    }

    @Override
    public String toString() {
        return "Człowiek";
    }
}
