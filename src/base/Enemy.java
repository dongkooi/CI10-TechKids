package base;

import base.counter.FrameCounter;
import base.renderer.AnimationRenderer;
import base.renderer.EnemyBullet;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider collider;

    public Enemy() {
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImage(
                "assets/images/enemies/level0/pink/0.png",
                "assets/images/enemies/level0/pink/1.png",
                "assets/images/enemies/level0/pink/2.png",
                "assets/images/enemies/level0/pink/3.png");

        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(200,100);
        this.collider = new BoxCollider(28,28);
        this.fireCounter = new FrameCounter(20);
    }

    public void fire() {
        EnemyBullet enemyBullet = GameObject.recycle(EnemyBullet.class);
        enemyBullet.velocity.set(0, 3);
        enemyBullet.position.set(this.position.x, this.position.y);
        this.fireCounter.reset();
    }

    @Override
    public void run() {
        boolean fireCounterRun = this.fireCounter.run();
        if (fireCounterRun) {
            this.fire();
        }
    }
    @Override
    public BoxCollider getBoxCollider(){
        return this.collider;
    }
}
