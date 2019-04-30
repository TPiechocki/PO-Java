/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po.World;

import pl.piechocki.po.UI.UIWindow;
import pl.piechocki.po.World.Field.SquareField;

public class SquareWorld extends AbstractWorld {
    public SquareWorld(int x, int y) {
        super(x, y);
        fields = new SquareField[x_size][y_size];

        // fill array
        for (int j = 0; j < y_size; j++) {
            for (int i = 0; i < x_size; i++) {
                fields[i][j] = new SquareField(i, j);
            }
        }
        setNeighbours();

        window = new UIWindow(true, x_size, y_size);
    }
}
