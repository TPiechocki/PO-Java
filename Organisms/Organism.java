/*
 * File created by Tomasz Piechocki on 2019/4/30.
 */

package pl.piechocki.po.Organisms;

import java.awt.*;

public interface Organism {
    void action();

    Color color();

    int getX();

    int getY();

    int getInitiative();

    int getStrength();

    int getAge();
}
