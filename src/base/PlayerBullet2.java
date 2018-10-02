package base;

import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet2 extends GameObject{
    public PlayerBullet2() {
        ArrayList<BufferedImage> images = SpriteUtils.loadImage(
                "assets/images/sphere-bullets/0.png",
                "assets/images/sphere-bullets/1.png",
                "assets/images/sphere-bullets/2.png",
                "assets/images/sphere-bullets/3.png"
        );
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(0,0);
    }

    public void run() {
        this.position.addThis(2, -2);
    }
}
