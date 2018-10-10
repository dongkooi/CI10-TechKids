package base.enemy;

import base.Settings;
import base.action.*;
import base.physics.BoxCollider;
import base.GameObject;
import base.physics.Physics;
import base.Vector2D;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    //    FrameCounter fireCounter;
    BoxCollider collider;
    Action action;

    public Enemy() {
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImage(
                "assets/images/enemies/level0/pink/0.png",
                "assets/images/enemies/level0/pink/1.png",
                "assets/images/enemies/level0/pink/2.png",
                "assets/images/enemies/level0/pink/3.png");

        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(200, 100);
        this.collider = new BoxCollider(28, 28);
//        this.fireCounter = new FrameCounter(20);
        this.defineAction();
    }

    void defineAction() {
        ActionWait actionWait = new ActionWait(20);
        Action actionfire = new Action() {
            @Override
            public void run(GameObject master) {
                fire();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };

        Action actionMove = new Action() {
            @Override
            public void run(GameObject master) {
                move();
//                this.isDone = true;
            }

            @Override
            public void reset() {
//                this.isDone = false;
            }
        };
        ActionSequence actionSequence = new ActionSequence(actionWait, actionfire);
        ActionParallel actionParallel = new ActionParallel(actionMove, actionSequence);
        ActionRepeat actionRepeat = new ActionRepeat(actionParallel);
        this.action = actionRepeat;
    }

    @Override
    public void run() {
        this.action.run(this);
    }

    public void fire() {
        EnemyBullet enemyBullet = GameObject.recycle(EnemyBullet.class);
        enemyBullet.velocity.set(0, 3);
        enemyBullet.position.set(this.position.x, this.position.y + 5);
    }

    public void move() {
        if (this.position.x < 0) {
            this.destroy();
        } else {
            this.position.x -= 2;
        }
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
