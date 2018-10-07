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


    public GameCanvas() {
        this.background = GameObject.recycle(Background.class);
        this.player = GameObject.recycle(Player.class);

        Enemy enemy = GameObject.recycle(Enemy.class);
    }


    public void run() {
        GameObject.runall();
    }

    public void render(Graphics g) {
       GameObject.rendererAll(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);
    }
}
