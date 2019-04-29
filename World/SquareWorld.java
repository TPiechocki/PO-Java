/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po.World;

import pl.piechocki.po.UI.UIWindow;

public class SquareWorld extends AbstractWorld {
    public SquareWorld(int x, int y) {
        super(x, y);

        window = new UIWindow(true, x_size, y_size);
    }
}
