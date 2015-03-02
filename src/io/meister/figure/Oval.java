package io.meister.figure;

import java.awt.*;

public class Oval extends Figure {

    private int height;
    private int width;

    public Oval(int posx, int posy, int height, int width) {
        super(posx, posy);
        this.height = height;
        this.width = width;
    }

    public void draw(Graphics g) {
        g.drawOval(this.startPosX,this.startPosY,this.width,this.height);
    }
}
