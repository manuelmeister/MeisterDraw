package io.meister;

import io.meister.figure.*;
import io.meister.figure.Box;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.lang.reflect.*;

public class MeisterDraw {

    public MeisterDraw() {
        Box rect = new Box(0,0,10,100);
        rect.move(10,10);
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
