package org.suai.model;

public class Player {

    private int x, y;
    private int health;
    private int maxHealth;
    private int speed;
    private int minSpeed;
    private int maxSpeed;
    private Weapon weapon;

    public Player(int x, int y, int maxHealth, int minSpeed, int maxSpeed, Weapon weapon) {
        this.x = x;
        this.y = y;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.minSpeed = minSpeed;
        this.speed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.weapon = weapon;
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
        this.x += a * speed;
    }

    public void moveY(int a) {
        this.y += a * speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
