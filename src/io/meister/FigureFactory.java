package io.meister;

import io.meister.figure.Figure;

import java.awt.*;

public abstract class FigureFactory {

    protected Character keyChar;

    protected Point first;
    protected Point second;
    protected Size size;

    public abstract Figure create(Point first, Point second);

    protected void optimizePoints(){
        double startPosX = (this.second.getX() > this.first.getX()) ? this.first.getX() : this.second.getX();
        double startPosY = (this.second.getY() > this.first.getY()) ? this.first.getY() : this.second.getY();
        double endPosX = Math.abs(this.second.getX() - this.first.getX());
        double endPosY = Math.abs(this.second.getY() - this.first.getY());
        this.first = new Point((int)startPosX,(int)startPosY);
        this.size = new Size((int)endPosX,(int)endPosY);
    }

    public Character getKeyChar() {
        return this.keyChar;
    }
}
