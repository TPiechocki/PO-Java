/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import javax.swing.*;
import java.awt.*;

class UIInfo extends JPanel {
    final JButton turn_button;    // new turn
    final JButton new_button;     // new game
    final JButton skill;      // for activating skill
    final JButton save;
    final JButton load;

    final JLabel skill_end;

    UIInfo() {
        setBackground(Color.lightGray);

        final JPanel buttons1 = new JPanel(new GridLayout(10,1,2,2));
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

        save = new JButton("Zapisz grę");
        save.setName("save");
        buttons1.add(save);

        load = new JButton("Ładuj grę");
        load.setName("load");
        buttons1.add(load);

        add(buttons1);
    }
}
