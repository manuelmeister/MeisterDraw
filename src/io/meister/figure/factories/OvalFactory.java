package io.meister.figure.factories;

import io.meister.FigureFactory;
import io.meister.figure.Figure;
import io.meister.figure.Oval;

import java.awt.*;

public class OvalFactory extends FigureFactory {

    public OvalFactory() {
        keyChar = 'o';
    }

    public Figure create(Point first, Point second) {
        this.first = first;
        this.second = second;

        optimizePoints();

        return new Oval(
                this.first.x,
                this.first.y,
                this.size.height,
                this.size.width
        );
    }
}
