package base;

import Game.GameCanvas;
import base.counter.FrameCounter;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider collider;

    public Player() {
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImage(
                "assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png",
                "assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png",
                "assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png",
                "assets/images/players/straight/6.png");
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(Settings.START_PLAYER_POSITION_X, Settings.START_PLAYER_POSITION_Y);
        this.fireCounter = new FrameCounter(30);
    }

    @Override
    public void run() {
        if (KeyEventPress.isUpPress) {
            this.move(0, -1);
        }

        if (KeyEventPress.isDownPress) {
            this.move(0, 1);
        }

        if (KeyEventPress.isLeftPress) {
            this.move(-1, 0);
        }

        if (KeyEventPress.isRightPress) {
            this.move(1, 0);
        }

        boolean fireCounterRun = this.fireCounter.run();
        if (KeyEventPress.isSpacePress && fireCounterRun) {
            this.fire();
        }

    }

    public void fire() {
        PlayerBullet playerBullet = GameObject.recycle(PlayerBullet.class);
        PlayerBullet playerBullet1 = GameObject.recycle(PlayerBullet.class);
        PlayerBullet playerBullet2 = GameObject.recycle(PlayerBullet.class);

        playerBullet.velocity.set(0, -1);
        playerBullet1.velocity.set(1, -1);
        playerBullet2.velocity.set(-1, -1);
        playerBullet.position.set(this.position.x, this.position.y);
        playerBullet1.position.set(this.position.x, this.position.y);
        playerBullet2.position.set(this.position.x, this.position.y);
        this.fireCounter.reset();
    }

    public void move(int translateX, int translateY) {
        this.position.add(translateX, translateY);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
