/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.World.Directions;

public interface Directions {
    /**
     * @return int used in neighbour index
     */
    int toInt();

    Directions intToDirection(int x);

    int getNumberOfDirections();

    int getX();

    int getY();

    /**
     * @return next direction clockwise starting with north at 0
     */
    Directions getNextDirection();

    @SuppressWarnings("SameReturnValue")
    Directions defaultDirection();

    Directions randomDirection();
}
