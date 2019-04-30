/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po.World;

import pl.piechocki.po.Game;
import pl.piechocki.po.UI.UIWindow;
import pl.piechocki.po.World.Field.Field;

public abstract class AbstractWorld implements World {
    int x_size, y_size;
    UIWindow window;
    Field[][] fields;

    AbstractWorld(int x_size, int y_size) {
        this.x_size = x_size;
        this.y_size = y_size;
    }

    @Override
    public void setNeighbours() {
        for (int j = 0; j < y_size; j++) {
            for (int i = 0; i < x_size; i++) {
                fields[i][j].setNeighbours(fields, x_size, y_size);
            }
        }
    }

    @Override
    public void makeTurn() {
        displayWorld();
    }

    @Override
    public void displayWorld() {
        window.drawFields(fields);
    }

    @Override
    public void setListeners(Game game) {
        window.setListeners(game);
    }
}
