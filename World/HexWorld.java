/*
 * File created by Tomasz Piechocki on 2019/5/16.
 */

package pl.piechocki.po.World;

import pl.piechocki.po.UI.UIWindow;
import pl.piechocki.po.World.Field.HexField;

public class HexWorld extends AbstractWorld {
    public HexWorld(int x_size, int y_size) {
        super(x_size, y_size);

        fields = new HexField[x_size][y_size];

        for (int j = 0; j < y_size; j++) {
            for (int i = 0; i < x_size; i++) {
                if ((i+j) %2 == 0 )
                    fields[i][j] = new HexField(i, j);
            }
        }
        setNeighbours();

        window = new UIWindow(false, x_size, y_size, fields);
    }
}
