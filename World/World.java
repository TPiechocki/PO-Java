/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po.World;

import pl.piechocki.po.Game;

public interface World {
    /**
     * set Neighbours for all fields
     */
    void setNeighbours();

    /**
     * Make turn with moving all organisms
     */
    void makeTurn();

    /**
     * Display board of the world
     */
    void displayWorld();

    void setListeners(Game game);
}
