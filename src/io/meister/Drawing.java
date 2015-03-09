package io.meister;

import io.meister.figure.Figure;

import java.awt.*;
import java.util.ArrayList;

public class Drawing {

    private ArrayList<Figure> figuren;

    public Drawing(ArrayList<Figure> figuren) {
        this.figuren = figuren;
    }

    public void add(Figure f){
        this.figuren.add(f);
    }

    public void draw(Graphics g) {
        for (Figure f : this.figuren){
            f.draw(g);
        }
    }

    public void move(int x, int y) {
        for (Figure f : this.figuren){
            f.move(x,y);
        }
    }
}
