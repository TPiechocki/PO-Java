/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.World.Field;

import pl.piechocki.po.World.Directions.SquareDirection;

public class SquareField extends AbstractField {
    public SquareField(int x, int y) {
        super(x,y);
        org = null;
        neighbours = new Field[4];

        direction = SquareDirection.NONE;
    }
}
