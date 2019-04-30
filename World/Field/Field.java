/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.World.Field;

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
     * Set neighbours of this field
     * @param fields all fields
     * @param x_size x dimension max element
     * @param y_size y dimension max element
     */
    void setNeighbours(Field[][] fields, int x_size, int y_size);
}
