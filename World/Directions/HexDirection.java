/*
 * File created by Tomasz Piechocki on 2019/5/15.
 */

package pl.piechocki.po.World.Directions;

import java.util.Random;

public enum HexDirection implements Directions {
    SOUTH(0,2),              // 0
    SOUTHWEST(-1,1),         // 1
    NORTHWEST(-1,-1),        // 2
    NORTH(0,-2),             // 3
    NORTHEAST(1,-1),       // 4
    SOUTHEAST(1,1),        // 5
    NONE(0,0);              // -1

    private final int x;
    private final int y;
    private final int amount = 6;

    HexDirection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int toInt() {
        if (x == 0 && y == 2)
            return 0;
        else if (x == -1 && y == 1)
            return 1;
        else if (x == -1 && y == -1)
            return 2;
        else if (x  == 0 && y == -2)
            return 3;
        else if (x == 1 && y == -1)
            return 4;
        else if (x == 1 && y == 1)
            return 5;
        else
            return 0;
    }

    @Override
    public Directions intToDirection(int x) {
        switch (x) {
            case 0:
                return SOUTH;
            case 1:
                return SOUTHWEST;
            case 2:
                return NORTHWEST;
            case 3:
                return NORTH;
            case 4:
                return NORTHEAST;
            case 5:
                return SOUTHEAST;
        }
        return NONE;
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
            case SOUTH:
                return SOUTHWEST;
            case SOUTHWEST:
                return NORTHWEST;
            case NORTHWEST:
                return NORTH;
            case NORTH:
                return NORTHEAST;
            case NORTHEAST:
                return SOUTHEAST;
            case SOUTHEAST:
                return SOUTH;
            default:
                return NONE;
        }
    }

    @Override
    public Directions defaultDirection() {
        return SOUTH;
    }

    @Override
    public Directions randomDirection() {
        return intToDirection(new Random().nextInt(amount));
    }
}
