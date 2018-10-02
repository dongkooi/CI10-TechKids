package base.renderer;

import base.GameObject;
import base.counter.FrameCounter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int curruntImage = 0;
    FrameCounter frameCounter;

    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this.images = images;
        this.frameCounter=new FrameCounter(5);
    }

    public AnimationRenderer(ArrayList<BufferedImage>images, int framecount){
        this.images = images;
        this.frameCounter = new FrameCounter(framecount);
    }
    @Override
    public void render(Graphics g, GameObject master) {
        if (images.size() > 0) {
            g.drawImage(images.get(curruntImage), (int) master.position.x, (int) master.position.y, null);
            if (frameCounter.run()) {
                curruntImage++;
                if (curruntImage >= images.size() - 1) {
                    curruntImage = 0;
                }
                frameCounter.reset();
            }
        }
    }
}

