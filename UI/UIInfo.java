/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import pl.piechocki.po.Organisms.Player;

import javax.swing.*;
import java.awt.*;

class UIInfo extends JPanel {
    JButton turn_button;    // new turn
    JButton new_button;     // new game
    JButton skill;      // for activating skill
    JLabel skill_end;

    UIInfo() {
        setBackground(Color.lightGray);

        final JPanel buttons1 = new JPanel(new GridLayout(5,1,2,2));
        buttons1.setBackground(new Color(0,0,0,0));

        turn_button = new JButton("Nowa tura");
        turn_button.setName("turn");
        buttons1.add(turn_button);

        new_button = new JButton("Nowa gra");
        new_button.setName("new_game");
        buttons1.add(new_button);

        skill_end = new JLabel("");
        buttons1.add(skill_end);

        skill = new JButton("Aktywuj nieśmiertelność");
        skill.setName("skill");
        buttons1.add(skill);

        add(buttons1);
    }
}
