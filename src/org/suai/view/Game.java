package org.suai.view;

import org.suai.model.Arena;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    Arena arena;
    boolean isOver = false;

    public Game(String title) {
        super(title);

        System.out.println("Creating Arena");
        //arena = new Arena(100,70);
        arena = new Arena(10,10);
        Container c = getContentPane();
        c.add(arena);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1020, 745);
        setVisible(true);
    }

    public void loop() {
        long lastTime = System.currentTimeMillis();
        long delta;
        long deltaMax = System.currentTimeMillis() - lastTime;
        System.out.println("Starting loop");
        while (!isOver) {
            delta = System.currentTimeMillis() - lastTime;
            if (delta > deltaMax) {
                deltaMax = delta;
            }
            arena.update();

            //isOver = arena.getIsOver();
            //isOver = true;
            lastTime = System.currentTimeMillis();
        }
        System.out.println(deltaMax);
    }

    public static void main(String[] args) {
        Game game = new Game("Game");
        game.loop();
    }
}
