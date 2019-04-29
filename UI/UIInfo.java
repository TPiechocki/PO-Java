/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import javax.swing.*;
import java.awt.*;

class UIInfo extends JPanel {
    JButton turn_button;

    UIInfo() {
        setBackground(new Color(0,0,0,0));

        turn_button = new JButton("Nowa tura");
        turn_button.setName("turn");

        add(turn_button);
    }
}
