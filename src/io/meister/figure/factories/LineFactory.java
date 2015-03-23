package io.meister.figure.factories;

import io.meister.FigureFactory;
import io.meister.figure.Figure;
import io.meister.figure.Line;

import java.awt.*;

public class LineFactory extends FigureFactory {

    public LineFactory() {
        keyChar = 'l';
    }

    public Figure create(Point first, Point second) {
        this.first = first;
        this.second = second;

        return new Line(
                this.first.x,
                this.first.y,
                this.second.x,
                this.second.y
        );
    }
}
