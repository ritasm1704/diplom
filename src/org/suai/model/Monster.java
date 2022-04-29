package org.suai.model;

import java.util.List;

public class Monster extends GameObject{

    private boolean isRunning = false;
    private int health;
    private int speed;
    private Weapon weapon;
    private Arena arena;
    private int radius;

    public Monster(int x, int y, int width, int height, int health, int speed, int radius, Weapon weapon, Arena arena) {
        super(x, y, width, height);
        this.health = health;
        this.speed = speed;
        this.radius = radius;
        this.weapon = weapon;
        this.arena = arena;
    }

    public void itIsRunning(boolean a) {
        isRunning = a;
    }

    public void moveX(int a) {
        setX(getX() + a * speed);
    }

    public void moveY(int a) {
        setY(getY() + a * speed);
    }

    public void update() {

        int widthOfArena = arena.getWidthOfArena();
        int heightOfArena = arena.getHeightOfArena();
        int[][] arenaAsMas = arena.getArenaAsMas();

        int xStart = getX();
        int yStart = getY();
        Node first = new Node(xStart, yStart, arenaAsMas);
        Player player = search();
        if (player != null) {
            dijkstra(xStart, yStart, player.getX(), player.getY(), first);
        }
    }

    public Player search() {
        List<Player> players = arena.getPlayers();
        isRunning = false;
        if (players == null) {
            return null;
        }

        Player nearest = null;
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            for (int x = getX() - radius; x <= getX() + radius; x++){
                for (int y = getY() - radius; y <= getY() + radius; y++) {

                    if (player.getX() == x && player.getY() == y) {
                        isRunning = true;
                        nearest = player;
                    }
                }
            }
        }
        return nearest;
    }

    public void dijkstra(int xStart, int yStart, int xFinish, int yFinish, Node first) {


    }

    public void A(int xStart, int yStart, int xFinish, int yFinish, Node first) {


    }
}
