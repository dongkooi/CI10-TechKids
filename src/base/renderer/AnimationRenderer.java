package base.renderer;

import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int curruntImage = 0;
    int frameCount = 0;

    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this.images = images;
    }

    @Override
    public void render(Graphics g, GameObject master) {
        if (images.size() > 0) {
            g.drawImage(images.get(curruntImage), (int) master.position.x, (int) master.position.y, null);
            if (frameCount > 5) {
                curruntImage++;
                if (curruntImage >= images.size() - 1) {
                    curruntImage = 0;
                }
                frameCount = 0;
            } else {
                frameCount++;
            }
        }
    }
}

