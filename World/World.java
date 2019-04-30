/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po.World;

import pl.piechocki.po.Game;
import pl.piechocki.po.Organisms.AbstractOrganism;
import pl.piechocki.po.World.Field.Field;

public interface World {
    /**
     * set Neighbours for all fields
     */
    void setNeighbours();

    void setListeners(Game game);

    /**
     * Make turn with moving all organisms
     */
    void makeTurn();

    /**
     * Display board of the world
     */
    void displayWorld();

    /**
     * Add organism to the entities list.
     */
    void addOrganism(AbstractOrganism org);

    /**
     * @param org organism to be inserted to the board
     */
    void setOrganismOnBoard(AbstractOrganism org);

    /**
     * @return field with given coordinates
     */
    Field getField(int x, int y);
}
