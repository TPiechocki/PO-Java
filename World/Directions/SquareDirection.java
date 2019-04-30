/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.World.Directions;

public enum SquareDirection implements Directions {
    NORTH(0,-1),        // 0
    EAST(1,0),          // 1
    SOUTH(0,1),         // 2
    WEST(-1,0),         // 3
    NONE(0,0);          // -1

    private int x, y;
    private final int amount = 4;

    SquareDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int toInt() {
        if (x == 0 && y == -1)
            return 0;
        else if (x == 0 && y == 1)
            return 2;
        else if (x == 1 && y == 0)
            return 1;
        else if (x  == -1 && y == 0)
            return 3;
        else
            return 0;
    }



    @Override
    public int getNumberOfDirections() {
        return amount;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Directions getNextDirection() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            default:
                return NORTH;
        }
    }

    @Override
    public Directions defaultDirection() {
        return NORTH;
    }


}
