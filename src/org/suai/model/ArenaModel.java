package org.suai.model;

import java.util.ArrayList;

public class ArenaModel {

    private int widthOfArena;
    private int heightOfArena;
    private int[][] arenaAsMas;

    ArrayList<Monster> monsters = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();

    public ArenaModel(int width, int height) {

        widthOfArena = width;
        heightOfArena = height;

        arenaAsMas = new int[heightOfArena][widthOfArena];
        for (int i = 0; i < heightOfArena; i++) {
            for (int j = 0; j < widthOfArena; j++) {
                if (i == 0 || i == heightOfArena - 1 || j == 0 || j == widthOfArena - 1) {
                    arenaAsMas[i][j] = -1;
                }
                else {
                    arenaAsMas[i][j] = 0;
                }
            }
        }
        players.add(new Player(5,5, 10, 10, 100, 1, 1, 1));
        monsters.add(new Monster(6,6, 10,10,100, 1, 50, new Weapon(1,1)));
    }

    public void update(InputComponent inputComponent) {
        //System.out.println("update arena");
        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).update(arenaAsMas, players);
        }
        for (int i = 0; i < players.size(); i++) {
            players.get(i).update(inputComponent, arenaAsMas);
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
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

}
