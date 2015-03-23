package io.meister.figure.factories;

import io.meister.FigureFactory;
import io.meister.figure.Figure;
import io.meister.figure.Text;

import java.awt.*;

public class TextFactory extends FigureFactory {

    public TextFactory() {
        keyChar = 't';
    }

    public Figure create(Point first, Point second) {
        this.first = first;
        this.second = second;

        return new Text(
                this.first.x,
                this.first.y,
                "test"
        );
    }
}
