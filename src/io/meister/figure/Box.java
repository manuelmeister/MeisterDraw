package io.meister.figure;

import java.awt.*;

public class Box extends Figure {

    private int side;
    private int length;

    public Box(int posx, int posy, int side, int length) {
        super(posx, posy);
        this.side = side;
        this.length = length;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(this.startPosX,this.startPosY,this.length,this.side);
    }
}
