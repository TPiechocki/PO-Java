/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import javax.swing.*;
import java.awt.*;

class UIInfo extends JPanel {

    UIInfo() {
        setBackground(new Color(0,0,0,0));

        add(new JButton("Hello"), BorderLayout.CENTER);
    }
}
