package base;

import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Background extends GameObject {
    public Background() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.renderer = new SingleImageRenderer("assets/images/background/0.png");
        this.position =new Vector2D(0, -(image.getHeight() - 600));
    }

    @Override
    public void run() {
        if (this.position.y >= 0)
            return;
        else
            this.position.y += 5;
    }
}
