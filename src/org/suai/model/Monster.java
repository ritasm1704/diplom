package org.suai.model;

import java.util.ArrayList;
import java.util.List;

public class Monster extends GameObject{

    private boolean isRunning = false;
    private int health;
    private int speed;
    private Weapon weapon;
    private int radius;
    int numberOfPlayer = -1;

    public Monster(int x, int y, int width, int height, int health, int speed, int radius, Weapon weapon) {
        super(x, y, width, height);
        this.health = health;
        this.speed = speed;
        this.radius = radius;
        this.weapon = weapon;
    }

    public void itIsRunning(boolean a) {
        isRunning = a;
    }

    public void moveX(int a, int[][] arena) {
        if (getX() + a >= 0 && getX() + a < arena[0].length && arena[getY()][getX() + a] != -1 ) {
            setX(getX() + a * speed);
        }
    }

    public void moveY(int a, int[][] arena) {
        if (getY() + a >= 0 && getY() + a < arena.length && arena[getY() + a][getX()] != -1 ) {
            setY(getY() + a * speed);
        }
    }

    public void update(int[][] arena, ArrayList<Player> players) {


        Player nearest = null;
        /*if (numberOfPlayer != -1) {
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                if (player.number == numberOfPlayer) {
                    if (player.isDead) {
                        numberOfPlayer = -1;
                    }
                    else {
                        nearest = player;
                    }
                }
            }
        }

        if (numberOfPlayer == -1) {
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                if (!player.isDead) {

                }
            }
        }*/

        nearest = players.get(0);
        if (nearest != null) {
            int xStart = getX();
            int yStart = getY();
            int xFinish = nearest.getX();
            int yFinish = nearest.getY();

            int[][] copyOfArena = new int[arena.length][arena[0].length];

            for (int i = 0; i < arena.length; i++) {
                for (int j = 0; j < arena[0].length; j++) {
                    if (arena[i][j] != -1) {
                        copyOfArena[i][j] = Math.max(Math.abs(yStart - i),Math.abs(xStart - j));
                    }
                    else {
                        copyOfArena[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            int[] masPrev = new int[] {xFinish, yFinish};
            int[] mas = new int[] {xFinish, yFinish};

            while (!(mas[0] == xStart && mas[1] == yStart)) {
                masPrev = mas;
                mas = getNextStep(mas[0], mas[1], copyOfArena);
            }
            setX(masPrev[0]);
            setY(masPrev[1]);

            /*for (int i = 0; i < copyOfArena.length; i++) {
                for (int j = 0; j < copyOfArena[0].length; j++) {
                    System.out.print(copyOfArena[i][j] + " ");
                }
                System.out.println();
            }*/


        }

    }

    public int[] getNextStep(int x, int y, int[][] arena) {


        int minX = 0;
        int minY = 0;
        if (y + 1 < arena.length) {
            if (arena[y + 1][x] < arena[minY][minX]) {
                minY = y + 1;
                minX = x;
            }
            if (x + 1 < arena[0].length) {
                if (arena[y + 1][x + 1] < arena[minY][minX]) {
                    minY = y + 1;
                    minX = x + 1;
                }
            }
            if (x - 1 >= 0) {
                if (arena[y + 1][x - 1] < arena[minY][minX]) {
                    minY = y + 1;
                    minX = x - 1;
                }
            }
        }
        if (y - 1 >= 0) {
            if (arena[y - 1][x] < arena[minY][minX]) {
                minY = y - 1;
                minX = x;
            }
            if (x + 1 < arena[0].length) {
                if (arena[y - 1][x + 1] < arena[minY][minX]) {
                    minY = y - 1;
                    minX = x + 1;
                }
            }
            if (x - 1 >= 0) {
                if (arena[y - 1][x - 1] < arena[minY][minX]) {
                    minY = y - 1;
                    minX = x - 1;
                }
            }
        }
        if (x + 1 < arena[0].length) {
            if (arena[y][x + 1] < arena[minY][minX]) {
                minY = y;
                minX = x + 1;
            }
        }
        if (x - 1 >= 0) {
            if (arena[y][x - 1] < arena[minY][minX]) {
                minY = y;
                minX = x - 1;
            }
        }

        return new int[] {minX, minY};
    }
}
