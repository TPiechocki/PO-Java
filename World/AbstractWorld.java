/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po.World;

import pl.piechocki.po.Game;
import pl.piechocki.po.Organisms.AbstractOrganism;
import pl.piechocki.po.UI.UIWindow;
import pl.piechocki.po.World.Field.Field;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public abstract class AbstractWorld implements World {
    int x_size, y_size;
    UIWindow window;
    private ArrayList<AbstractOrganism> entities;
    Field[][] fields;

    LinkedList<String> notifications;


    //INIT
    AbstractWorld(int x_size, int y_size) {
        this.x_size = x_size;
        this.y_size = y_size;
        entities = new ArrayList<>();

        notifications = new LinkedList<>();
    }
    @Override
    public void setNeighbours() {
        for (int j = 0; j < y_size; j++) {
            for (int i = 0; i < x_size; i++) {
                fields[i][j].setNeighbours(fields, x_size, y_size);
            }
        }
    }
    @Override
    public void setListeners(Game game) {
        window.setListeners(game);
    }


    // REST
    @Override
    public void makeTurn() {
        clearNotifications();

        addNotification("Nowa tura");
        addNotification("Test");

        Collections.sort(entities);
        for (AbstractOrganism org : entities) {
            org.action();
        }

        displayWorld();
        window.displayNotification(notifications);
    }

    @Override
    public void displayWorld() {
        window.drawFields(fields);
    }

    @Override
    public void addOrganism(AbstractOrganism org) {
        entities.add(org);

        if (fields[org.getX()][org.getY()].isEmpty())
            fields[org.getX()][org.getY()].setOrganism(org);
    }

    @Override
    public void setOrganismOnBoard(AbstractOrganism org) {
        fields[org.getX()][org.getY()].setOrganism(org);
    }

    @Override
    public Field getField(int x, int y) {
        return fields[x][y];
    }


    // NOTIFICATIONS
    private void clearNotifications() {
        notifications.clear();
    }
    @Override
    public void addNotification(String str) {
        notifications.addLast(str);
    }
    @Override
    public void addPriorityNotification(String str) {
        notifications.addFirst(str);
    }
}
