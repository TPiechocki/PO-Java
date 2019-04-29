/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po.World;

import pl.piechocki.po.Game;
import pl.piechocki.po.UI.UIWindow;

public abstract class AbstractWorld implements World {
    int x_size, y_size;
    UIWindow window;

    AbstractWorld(int x_size, int y_size) {
        this.x_size = x_size;
        this.y_size = y_size;
    }

    @Override
    public void makeTurn() {
        displayWorld();
    }

    @Override
    public void displayWorld() {
        window.setButtons();
    }

    @Override
    public void setListeners(Game game) {
        window.setListeners(game);
    }
}
