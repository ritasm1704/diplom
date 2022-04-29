package org.suai.view;

import org.suai.model.Arena;

public class Game {

    public static void main(String[] args) {

        boolean isOver = false;

        long lastTime = System.currentTimeMillis();
        long delta;
        long deltaMax = System.currentTimeMillis() - lastTime;

        Arena arena = new Arena(100,100);

        while (!isOver) {
            delta = System.currentTimeMillis() - lastTime;
            if (delta > deltaMax) {
                deltaMax = delta;
            }

            arena.update();
            isOver = arena.getIsOver();

            lastTime = System.currentTimeMillis();
        }
        System.out.println(deltaMax);
    }
}
