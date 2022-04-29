package org.suai.model;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Arena extends JFrame {

    boolean leftPressed = false;
    boolean rightPressed = false;
    boolean downPressed = false;
    boolean upPressed = false;

    ArrayList<Monster> monsters;
    ArrayList<Player> players;

    private class KeyInputHandler extends KeyAdapter {

        public void  keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {
                case (KeyEvent.VK_D) -> rightPressed = true;
                case (KeyEvent.VK_A) -> leftPressed = true;
                case (KeyEvent.VK_W) -> upPressed = true;
                case (KeyEvent.VK_S) -> downPressed = true;
            }
        }
        public void  keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case (KeyEvent.VK_D) -> rightPressed = false;
                case (KeyEvent.VK_A) -> leftPressed = false;
                case (KeyEvent.VK_W) -> upPressed = false;
                case (KeyEvent.VK_S) -> downPressed = false;
            }
        }
        public void  keyTyped(KeyEvent e) {

        }
    }

    private int widthOfArena;
    private int heightOfArena;
    private int[][] arenaAsMas;
    boolean isOver = false;

    public Arena(int width, int height) {
        addKeyListener(new KeyInputHandler());
        widthOfArena = width;
        heightOfArena = height;

        arenaAsMas = new int[heightOfArena][widthOfArena];
        for (int i = 0; i < heightOfArena; i++) {
            for (int j = 0; j < widthOfArena; j++) {
                if (i == 0 || i == heightOfArena - 1 || j == 0 || j == widthOfArena - 1) {
                    arenaAsMas[i][j] = 1;
                }
                else {
                    arenaAsMas[i][j] = 0;
                }
            }
        }
    }

    public void update() {
        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).update();
        }
    }

    public boolean getIsOver() {
        return isOver;
    }

    public int getHeightOfArena() {
        return heightOfArena;
    }

    public int getWidthOfArena() {
        return widthOfArena;
    }

    public int[][] getArenaAsMas() {
        return arenaAsMas;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
