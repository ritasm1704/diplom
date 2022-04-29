package org.suai.model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends GameObject {

    private boolean isRunning = false;
    private int health;
    private int maxHealth;
    private int speed;
    private int minSpeed;
    private int maxSpeed;
    private Weapon weapon;
    private Arena arena;

    public Player(int x, int y, int width, int height, int maxHealth, int minSpeed, int maxSpeed, Arena arena) {

        super(x, y, width, height);
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.minSpeed = minSpeed;
        this.speed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.weapon = new Weapon(10, 1);
        this.arena = arena;
    }

    public void reduceHealth(int a) {
        if (health - a < 0) {
            health = 0;
        }
        else {
            health -= a;
        }
    }

    public void enhanceHealth(int a){
        if (health + a > maxHealth) {
            health = maxHealth;
        }
        else {
            health += a;
        }
    }

    public void enhanceMaxHealth(int a){
        maxHealth += a;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void reduceSpeed(int a){
        if (speed - a < minSpeed) {
            speed = minSpeed;
        }
        else {
            speed -= a;
        }
    }

    public void enhanceSpeed(int a){
        if (speed + a > maxSpeed) {
            speed = maxSpeed;
        }
        else {
            speed += a;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void moveX(int a) {
        setX(getX() + a * speed);
    }

    public void moveY(int a) {
        setY(getY() + a * speed);
    }

    public GameObject checkCollision() {


        return null;
    }

    public void itIsRunning(boolean a) {
        isRunning = a;
    }

    public void update(Arena arena) {
        if (arena.rightPressed) {
            moveX(1);
        }
        if (arena.leftPressed) {
            moveX(-1);
        }
        if (arena.upPressed) {
            moveY(-1);
        }
        if (arena.downPressed) {
            moveY(1);
        }
    }

}
