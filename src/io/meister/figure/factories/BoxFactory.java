package io.meister.figure.factories;

import io.meister.FigureFactory;
import io.meister.figure.Box;
import io.meister.figure.Figure;

import java.awt.*;

public class BoxFactory extends FigureFactory {

    public BoxFactory() {
        keyChar = 'r';
    }

    public Figure create(Point first, Point second) {
        this.first = first;
        this.second = second;

        optimizePoints();

        return new Box(
                this.first.x,
                this.first.y,
                this.size.height,
                this.size.width
        );
    }
}
