/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

class UINotifications extends JPanel  implements Runnable {
    private transient Thread worker;
    private final String threadName;
    private volatile boolean finishWork;

    private LinkedList<String> messages;

    private final JLabel notif;

    UINotifications() {
        setBackground(Color.lightGray);

        notif = new JLabel("Hello");

        add(notif);

        threadName = "Notifications";
        finishWork = false;
    }

    @Override
    public void run() {
        try {
            while (!(messages.isEmpty()) && !finishWork){
                notif.setText(messages.removeFirst());

                Thread.sleep(2000);
            }
            notif.setText("");
        } catch (InterruptedException e) {
            finishWork = false;
            notif.setText("");
        }
    }

    void stopNotifications() {
        if (worker != null && worker.isAlive()) {
            finishWork = true;
            worker.interrupt();
            while (finishWork && worker.isAlive()) {
                Thread.onSpinWait();
            }
        }
    }

    void renderNotifications(LinkedList<String> msg) {
        stopNotifications();

        messages = msg;
        finishWork = false;
        worker = new Thread(this, threadName);
        worker.start();

    }
}
