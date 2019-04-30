/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.World.Field;

import pl.piechocki.po.Organisms.Organism;
import pl.piechocki.po.World.Directions.Directions;

import java.awt.*;

public abstract class AbstractField implements Field {
    int x, y;
    Field[] neighbours;     // TODO set neighbours etc.
    Organism org;
    Directions direction;

    AbstractField(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Color color() {
        return Color.white;
    }

    @Override
    public void setNeighbours(Field[][] fields, int x_size, int y_size) {
        direction = direction.defaultDirection();

        for (int i = 0; i < direction.getNumberOfDirections(); i++) {
            int x_temp = x + direction.getX();
            int y_temp = y + direction.getY();
            if (x_temp >= 0 && x_temp < x_size && y_temp >= 0 && y_temp < y_size) {
                neighbours[direction.toInt()] = fields[x_temp][y_temp];
            }
            direction = direction.getNextDirection();
        }
    }
}
