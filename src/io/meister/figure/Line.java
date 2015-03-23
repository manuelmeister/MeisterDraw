package io.meister.figure;

import java.awt.*;

public class Line extends Figure {

    private int endPosX;
    private int endPosY;

    public Line(int startPosX, int startPosY, int endPosX, int endPosY) {
        super(startPosX, startPosY);
        this.endPosX = endPosX;
        this.endPosY = endPosY;
    }

    public void draw(Graphics g) {
        g.drawLine(this.startPosX,this.startPosY,this.endPosX,this.endPosY);
    }

    public void move(int x, int y) {
        super.move(x, y);
        this.endPosX += x;
        this.endPosY += y;
    }
}
