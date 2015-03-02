package io.meister.figure;

import java.awt.*;

public class Box extends Figure {

    private int side;
    private int lenght;

    public Box(int posx, int posy, int side, int lenght) {
        super(posx, posy);
        this.side = side;
        this.lenght = lenght;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(this.startPosX,this.startPosY,this.lenght,this.side);
    }
}
