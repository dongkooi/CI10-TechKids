package Game;

import base.*;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    Background background;
    Player player;
    Enemy enemy;
    public static ArrayList<Enemy> enemies;
    public static ArrayList<PlayerBullet> playerBullets;
    boolean shootLock;
    int count = 0;

    public GameCanvas() {
        this.background = new Background();
        this.player = new Player();
        enemies = new ArrayList<>();
        playerBullets = new ArrayList<>();

        this.enemy = new Enemy(50, 100);
        Enemy enemy1 = new Enemy(175, 100);
        Enemy enemy2 = new Enemy(300, 100);
        enemies.add(enemy);
        enemies.add(enemy1);
        enemies.add(enemy2);

    }


    public void run() {
        background.run();
        player.run();
        for (Enemy enemy : enemies) {
            enemy.run();
        }


        if (KeyEventPress.isSpacePress && !shootLock) {
            PlayerBullet playerBullet = new PlayerBullet(player.position.x,player.position.y);
            playerBullets.add(playerBullet);
            shootLock = true;
        }

        if (shootLock) {
            count++;
            if (count > 30) {
                shootLock = false;
                count = 0;
            }
        }


        for (PlayerBullet playerBullet : playerBullets) {
            playerBullet.run();
        }
    }

    public void render(Graphics g) {
        background.render(g);
        player.render(g);
        for (Enemy enemy : enemies) {
            enemy.render(g);
        }
        for (PlayerBullet playerBullet : playerBullets) {
            playerBullet.render(g);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);
    }
}
