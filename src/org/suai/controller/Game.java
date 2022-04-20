package org.suai.controller;

import org.suai.model.Player;
import org.suai.model.Weapon;

public class Game {

    Controller controller;

    public static void main(String[] args) {

        Weapon sword1 = new Weapon(5, 1);
        Weapon bow1 = new Weapon(3, 3);

        Player player = new Player(0, 0, 100, 1, 5, sword1);

        Player monster1 = new Player(0, 0, 20, 1, 5, sword1);
        Player monster2 = new Player(0, 0, 20, 1, 5, bow1);

        while (true) {



        }

    }

    public void update() {

    }

    public void render() {

    }

}
