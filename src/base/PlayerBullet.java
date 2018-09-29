package base;

import Game.GameCanvas;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {
    public PlayerBullet(float x, float y) {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(x, y);
    }

    public void run() {
        this.position.y -= 1;
    }
}
