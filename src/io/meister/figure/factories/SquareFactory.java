package io.meister.figure.factories;

import io.meister.figure.Circle;
import io.meister.figure.Figure;
import io.meister.figure.Square;

import java.awt.*;

public class SquareFactory extends BoxFactory {

    public SquareFactory() {
        keyChar = 's';
    }

    public Figure create(Point first, Point second) {
        this.first = first;
        this.second = second;

        optimizePoints();

        return new Square(
                this.first.x,
                this.first.y,
                (this.size.height < this.size.width) ? this.size.height : this.size.width
        );
    }
}
