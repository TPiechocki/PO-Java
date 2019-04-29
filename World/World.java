/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po.World;

import pl.piechocki.po.Game;

public interface World {
    void makeTurn();

    void displayWorld();

    void setListeners(Game game);
}
