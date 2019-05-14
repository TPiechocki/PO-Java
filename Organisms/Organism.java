/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.Organisms;

import pl.piechocki.po.World.Directions.Directions;
import pl.piechocki.po.World.World;

import java.awt.*;

@SuppressWarnings("unused")
public interface Organism {
    Organism createNewInstance(int x, int y, World world);

    void action();

    /**
     * Move to the previous location
     */
    void setPreviousXY();

    Color color();

    int getX();
    int getY();
    int getInitiative();
    int getStrength();
    Directions getDirection();

    /**
     * Change strength by x value
     */
    void changeStrength(int x);

    int getAge();
    /**
     * Add one to the age at every turn
     */
    void addOneAge();

    Species getKind();

    /**
     * Set organism flag and then organism will be deleted before next turn.
     */
    void kill();

    /**
     * @return value of killed flag
     */
    boolean isKilled();
    /**
     * @return true for animals and false for the rest
     */
    boolean isAnimal();
}
