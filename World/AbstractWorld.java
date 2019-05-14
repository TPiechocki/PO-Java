/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po.World;

import pl.piechocki.po.Game;
import pl.piechocki.po.Organisms.AbstractOrganism;
import pl.piechocki.po.Organisms.Player;
import pl.piechocki.po.UI.UIWindow;
import pl.piechocki.po.World.Field.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public abstract class AbstractWorld implements World, Serializable {
    int x_size, y_size;
    UIWindow window;
    private ArrayList<AbstractOrganism> entities;
    Field[][] fields;

    private Player player;
    private Random random;

    LinkedList<String> notifications;


    //INIT
    AbstractWorld(int x_size, int y_size) {
        this.x_size = x_size;
        this.y_size = y_size;
        entities = new ArrayList<>();

        notifications = new LinkedList<>();

        random = new Random();
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
        int max = entities.size();

        // Sort and do actino for living organisms. New ones will be added at the end and their action will be skipped.
        Collections.sort(entities);
        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < max; i++) {
            if (!(entities.get(i).isKilled())) {
                entities.get(i).addOneAge();
                entities.get(i).action();
            }
        }

        // Remove killed organisms
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).isKilled()) {
                entities.remove(i);
                --i;
            }
        }

        window.refreshInfo();
        displayWorld();
        window.displayNotification(notifications);
    }

    @Override
    public void displayWorld() {
        window.drawFields(fields);
    }

    @Override
    public void closeWindow() {
        window.closeWindow();
    }

    @Override
    public void displayNotifications() {
        //window.stopNotifications();
        window.displayNotification(notifications);
    }

    @Override
    public void addOrganism(AbstractOrganism org) {
        entities.add(org);

        if (fields[org.getX()][org.getY()].isEmpty())
            fields[org.getX()][org.getY()].setOrganism(org);


    }

    @Override
    public void refreshInfo() {
        window.refreshInfo();
    }

    @Override
    public void setOrganismOnBoard(AbstractOrganism org) {
        fields[org.getX()][org.getY()].setOrganism(org);
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
        window.setPlayer(player);
    }

    @Override
    public Field getField(int x, int y) {
        return fields[x][y];
    }

    @Override
    public Field getRandomEmptyField() {
        Field field;
        int x,y;
        do {
            x = random.nextInt(x_size);
            y = random.nextInt(y_size);
            field = getField(x, y);
        } while (!(field.isEmpty()));
        return field;
    }

    @Override
    public int getSizeX() {
        return x_size;
    }

    @Override
    public int getSizeY() {
        return y_size;
    }

    // NOTIFICATIONS
    private void clearNotifications() {
        window.stopNotifications();
        notifications.clear();
    }
    @Override
    public void addNotification(String str) {
        notifications.addLast(str);
    }

    @Override
    public void stopNotifications() {
        window.stopNotifications();
    }

    @Override
    public void addPriorityNotification(String str) {
        stopNotifications();
        notifications.addFirst(str);

        window.displayNotification(notifications);
    }
}
