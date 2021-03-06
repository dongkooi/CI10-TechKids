package base.enemy;

import base.*;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {
    public Vector2D velocity;
    BoxCollider collider;
    int damage;

    public EnemyBullet(){
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImage(
                "assets/images/enemies/bullets/pink.png",
                "assets/images/enemies/bullets/pink.png");
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(0, 0);
        this.velocity = new Vector2D(0, 0);
        this.collider = new BoxCollider(16, 16);
        this.damage = 4;
    }

    @Override
    public void run() {
        Player player = GameObject.intersect(Player.class, this);
        if (player != null) {
            player.takeDamage(this.damage);
            this.destroy();
            return;
        }
        if (this.position.y < 0) {
            this.destroy();
            return;
        }
        this.position.addThis(this.velocity.x, this.velocity.y);
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
