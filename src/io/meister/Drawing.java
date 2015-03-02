package io.meister;

import io.meister.figure.Figure;

import java.awt.*;
import java.util.ArrayList;

public class Drawing {

    private Figure[] figuren;

    public Drawing(Figure[] figuren) {
        this.figuren = figuren;
    }

//    public void add(Figure f){
//        this.figuren.add(f);
//    }

    public void draw(Graphics g) {
        for (Figure f : this.figuren){
            f.draw(g);
        }
    }
}
