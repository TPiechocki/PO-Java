/*
 * File created by Tomasz Piechocki on 2019/4/29.
 */

package pl.piechocki.po;

import pl.piechocki.po.Organisms.Animals.*;
import pl.piechocki.po.Organisms.Plants.*;
import pl.piechocki.po.Organisms.Player;
import pl.piechocki.po.World.Field.Field;
import pl.piechocki.po.World.SquareWorld;
import pl.piechocki.po.World.World;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;


/**
 * General app controler
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class Game implements ActionListener {
    private World world;
    private Player player;

    private void newGame() {
        world = new SquareWorld(20, 20);
        world.setListeners(this);

        Field temp;     // temporary empty field
        int rate, limit;       // rate of probability
        Random random = new Random();

        temp = world.getRandomEmptyField();

        player = new Player(temp.getX(), temp.getY(), world);
        world.setPlayer(player);
        world.addOrganism(player);

        rate = 1 + (world.getSizeX() * world.getSizeY()) / 200;
        limit = random.nextInt(2 * rate) + 2 * rate;
        for (int i = 0; i < limit; i++) {
            temp = world.getRandomEmptyField();
            world.addOrganism(new Sheep(temp.getX(), temp.getY(), world));
        }

        rate = 1 + (world.getSizeX() * world.getSizeY()) / 400;
        limit = random.nextInt((int) (1.5 * rate)) + 2 * rate;
        for (int i = 0; i < limit; i++) {
            temp = world.getRandomEmptyField();
            world.addOrganism(new Wolf(temp.getX(), temp.getY(), world));
        }

        rate = 1 + (world.getSizeX() * world.getSizeY()) / 300;
        limit = random.nextInt(2 * rate) + 2 * rate;
        for (int i = 0; i < limit; i++) {
            temp = world.getRandomEmptyField();
            world.addOrganism(new Fox(temp.getX(), temp.getY(), world));
        }

        rate = 1 + (world.getSizeX() * world.getSizeY()) / 500;
        limit = random.nextInt((int) (1.5 * rate)) + 2 * rate;
        for (int i = 0; i < limit; i++) {
            temp = world.getRandomEmptyField();
            world.addOrganism(new Tortoise(temp.getX(), temp.getY(), world));
        }

        rate = 1 + (world.getSizeX() * world.getSizeY()) / 300;
        limit = random.nextInt(2 * rate) + 2 * rate;
        for (int i = 0; i < limit; i++) {
            temp = world.getRandomEmptyField();
            world.addOrganism(new Antelope(temp.getX(), temp.getY(), world));
        }

        rate = (world.getSizeX() * world.getSizeY()) / 100;
        limit = random.nextInt(2 * rate) + 2 * rate;
        for (int i = 0; i < limit; i++) {
            temp = world.getRandomEmptyField();
            world.addOrganism(new Grass(temp.getX(), temp.getY(), world));
        }

        rate = (world.getSizeX() * world.getSizeY()) / 100;
        limit = random.nextInt(2 * rate) + rate;
        for (int i = 0; i < limit; i++) {
            temp = world.getRandomEmptyField();
            world.addOrganism(new Dandelion(temp.getX(), temp.getY(), world));
        }

        rate = 1 + (world.getSizeX() * world.getSizeY()) / 500;
        limit = random.nextInt(3 * rate) + rate;
        for (int i = 0; i < limit; i++) {
            temp = world.getRandomEmptyField();
            world.addOrganism(new Guarana(temp.getX(), temp.getY(), world));
        }

        rate = 1 + (world.getSizeX() * world.getSizeY()) / 500;
        limit = random.nextInt(2 * rate) + rate;
        for (int i = 0; i < limit; i++) {
            temp = world.getRandomEmptyField();
            world.addOrganism(new Belladonna(temp.getX(), temp.getY(), world));
        }

        rate = 1 + (world.getSizeX() * world.getSizeY()) / 1000;
        limit = rate;
        for (int i = 0; i < limit; i++) {
            temp = world.getRandomEmptyField();
            world.addOrganism(new Hogweed(temp.getX(), temp.getY(), world));
        }

        /*
        world.addOrganism(new Sheep(0,0, world));
        world.addOrganism(new Sheep(1,0, world));
        world.addOrganism(new Sheep(0,1, world));
        world.addOrganism(new Wolf(19,  19, world));
        world.addOrganism(new Fox(18, 19, world));
        world.addOrganism(new Tortoise(5, 8, world));
        world.addOrganism(new Antelope(2,2, world));

        world.addOrganism(new Grass(10, 10, world));
        world.addOrganism(new Dandelion(12, 12, world));
        world.addOrganism(new Guarana(1,2, world));
        world.addOrganism(new Belladonna(5, 2, world));
        world.addOrganism(new Hogweed(0, 15, world));

        player = new Player(6,8,world);
        world.setPlayer(player);
        world.addOrganism(player); */

        world.displayWorld();
    }

    Game() {
        newGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String name;

        if (obj instanceof JButton) {
            JButton button = (JButton) obj;
            name = button.getName();

            switch (name) {
                case "turn":
                    world.makeTurn();
                    break;
                case "new_game":
                    world.closeWindow();
                    newGame();
                    break;
                case "skill":
                    player.activateImmortality();
                    world.refreshInfo();
                    break;
                case "save":
                    try {
                        String filename = JOptionPane.showInputDialog("Podaj nazwę pliku: ");
                        File file = new File("saves/" + filename + ".save");

                        File dir = new File("./saves");
                        // create directory for saves
                        if (!dir.exists())
                            dir.mkdir();
                        // create file
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileOutputStream fileOut = new FileOutputStream(file);
                        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                        world.stopNotifications();
                        objectOut.writeObject(world);
                        objectOut.close();
                    } catch (IOException err) {
                        err.printStackTrace();
                    }
                    break;
                case "load":
                    try {
                        String filename = JOptionPane.showInputDialog("Podaj nazwę pliku: ");
                        File file = new File("saves/" + filename + ".save");

                        FileInputStream fileIn = new FileInputStream(file);
                        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                        World temp = (World) objectIn.readObject();
                        objectIn.close();
                        System.out.println("The Object  was succesfully read");

                        world.closeWindow();
                        world = temp;
                        world.openWindow();
                        world.setListeners(this);
                        player = world.getPlayer();
                        world.setPlayer(player);

                        world.displayWorld();
                    } catch (IOException | ClassNotFoundException err) {
                        JOptionPane.showMessageDialog(new JFrame(), "Nie udało się otworzyć zapisu", "Load Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
        }
    }
}
