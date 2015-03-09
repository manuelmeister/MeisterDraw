package io.meister;

import io.meister.figure.*;
import io.meister.figure.Box;

import java.lang.reflect.*;

public class MeisterDraw {

    public MeisterDraw() {
        DrawingBoard drawingBoard = new DrawingBoard();
        Figure[] figuren = new Figure[2];
        figuren[0] = new Box(0,0,100,200);
        figuren[1] = new Circle(300,300,300);
        Drawing drawing = new Drawing(figuren);
        drawingBoard.show(drawing);
    }

    public void loader(){
        String className = "io.meister.figure.Square";
        int startPosX = 0;
        int startPosY = 0;
        int width = 100;
        try {
            Class cl = Class.forName(className);
            Constructor con = cl.getConstructor(int.class, int.class, int.class);
            Object newFigure = con.newInstance(startPosX, startPosY, width);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void main(String[] args) {
        MeisterDraw drawingApp = new MeisterDraw();

    }
}
