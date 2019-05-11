/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import javax.swing.*;
import java.awt.*;

class UIInfo extends JPanel {
    JButton turn_button;    // new turn
    JButton new_button; // new game

    UIInfo() {
        setBackground(new Color(0,0,0,0));

        turn_button = new JButton("Nowa tura");
        turn_button.setName("turn");
        add(turn_button);

        new_button = new JButton("Nowa gra");
        new_button.setName("new_game");
        add(new_button);
    }
}
