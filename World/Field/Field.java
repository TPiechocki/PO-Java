/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.World.Field;

import pl.piechocki.po.Organisms.Organism;
import pl.piechocki.po.World.Directions.Directions;

import java.awt.*;

/**
 * Represents one field of the board in the logic of the game
 */
public interface Field {

    /**
     * @return color to be drawn on this field
     */
    Color color();

    /**
     * @return true if there is no organism at that field
     */
    boolean isEmpty();

    /**
     * Set neighbours of this field
     * @param fields all fields
     * @param x_size x dimension max element
     * @param y_size y dimension max element
     */
    void setNeighbours(Field[][] fields, int x_size, int y_size);

    /**
     * Set organism on the field
     * @param org organism to insert
     */
    void setOrganism(Organism org);

    int getX();

    int getY();

    /**
     * @param direction direction of neighbouring field
     * @return proper field
     */
    Field getNeighbour(Directions direction);

    /**
     * @return neighbours which aren't null
     */
    Field[] getFullNeighbours();

    /**
     * @return random full neighbour
     */
    Field randomNeighbour();

    Directions getDirection();
}
