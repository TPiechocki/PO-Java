/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import javax.swing.*;
import java.awt.*;

class UINotifications extends JPanel {

    UINotifications() {
        setBackground(new Color(0,0,0,0));

        JLabel notif = new JLabel("Hello");

        add(notif);
    }
}
