/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.World.Field;

import pl.piechocki.po.Organisms.AbstractOrganism;
import pl.piechocki.po.Organisms.Organism;
import pl.piechocki.po.World.Directions.Directions;

import java.awt.*;
import java.util.Random;

public abstract class AbstractField implements Field {
    int x, y;       // coordinates
    int full_neighbours;     // amount neighbouring fields inside board
    Field[] neighbours;
    AbstractOrganism org;
    Directions direction;

    AbstractField(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Color color() {
        if (org != null)
            return org.color();
        // else
        return Color.white;
    }

    @Override
    public boolean isEmpty() {
        return org == null;
    }

    @Override
    public void setNeighbours(Field[][] fields, int x_size, int y_size) {
        direction = direction.defaultDirection();
        int temp_full = 0;

        for (int i = 0; i < direction.getNumberOfDirections(); i++) {
            int x_temp = x + direction.getX();
            int y_temp = y + direction.getY();
            if (x_temp >= 0 && x_temp < x_size && y_temp >= 0 && y_temp < y_size) {
                neighbours[direction.toInt()] = fields[x_temp][y_temp];
                temp_full++;
            }
            direction = direction.getNextDirection();
        }

        full_neighbours = temp_full;
    }

    @Override
    public void setOrganism(AbstractOrganism org) {
        this.org = org;
    }

    @Override
    public AbstractOrganism getOrganism() {
        return org;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Field getNeighbour(Directions direction) {
        return neighbours[direction.toInt()];
    }

    @Override
    public Field[] getFullNeighbours() {
        int index = 0;
        Field[] temp = new Field[full_neighbours];
        direction = direction.defaultDirection();
        for (int i = 0; i < direction.getNumberOfDirections(); i++) {
            if (neighbours[i] != null) {
                temp[index] = neighbours[i];
                index++;
            }
        }

        return temp;
    }

    @Override
    public Field randomNeighbour() {
        Field[] full = getFullNeighbours();

        return full[new Random().nextInt(full_neighbours)];
    }

    @Override
    public boolean hasEmptyNeighbour() {
        for (int i = 0; i < direction.getNumberOfDirections(); i++) {
            if (neighbours[i] != null && neighbours[i].isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Field randomEmptyNeighbour() {
        int index = 0;
        Field[] temp = new Field[full_neighbours];
        for (int i = 0; i < direction.getNumberOfDirections(); i++) {
            if (neighbours[i] != null) {
                temp[index] = neighbours[i];
                index++;
            }
        }

        return temp[new Random().nextInt(index)];
    }

    @Override
    public Directions getDirection() {
        return direction;
    }
}
