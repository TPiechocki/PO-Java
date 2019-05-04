/*
 * File created by Tomasz Piechocki on 2019/4/28.
 */

package pl.piechocki.po.UI;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

class UINotifications extends JPanel  implements Runnable {
    private Thread worker;
    private String threadName;
    volatile boolean finishWork;

    private LinkedList<String> messages;

    JLabel notif;
    UIWindow window;

    UINotifications(UIWindow window) {
        setBackground(Color.lightGray);

        notif = new JLabel("Hello");
        this.window = window;

        add(notif);

        threadName = "Notifications";
        finishWork = false;
    }

    @Override
    public void run() {
        try {
            while (!(messages.isEmpty()) && !finishWork){
                System.out.println(messages.getFirst());
                notif.setText(messages.removeFirst());

                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread stopped");
            finishWork = false;
            // empty
        }
    }

    @SuppressWarnings("unchecked")
    void renderNotifications(LinkedList<String> msg) {
        if (worker != null && worker.isAlive()) {
            finishWork = true;
            worker.interrupt();
            while (finishWork) {
                Thread.onSpinWait();
            }
        }

        messages = (LinkedList<String>) msg.clone();

        worker = new Thread(this, threadName);
        worker.start();

    }
}
