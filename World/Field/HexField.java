/*
 * File created by Tomasz Piechocki on 2019/5/16.
 */

package pl.piechocki.po.World.Field;


import pl.piechocki.po.World.Directions.HexDirection;

public class HexField extends AbstractField {
    public HexField(int x, int y) {
        super(x, y);

        org = null;
        neighbours = new Field[6];

        direction = HexDirection.NONE;
    }

    @Override
    public void setNeighbours(Field[][] fields, int x_size, int y_size) {
        if ((getX() + getY()) % 2 == 0)
        super.setNeighbours(fields, x_size, y_size);
    }
}
