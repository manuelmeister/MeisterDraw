package io.meister.figure;

import java.awt.*;

public abstract class Figure {
    protected int startPosX;
    protected int startPosY;

    protected Figure(int startPosX, int startPosY) {
        this.startPosX = startPosX;
        this.startPosY = startPosY;
    }

    public abstract void draw(Graphics g);

    public void move(int x, int y){
        this.startPosX += x;
        this.startPosY += y;
    }
}
