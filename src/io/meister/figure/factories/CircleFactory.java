package io.meister.figure.factories;

import io.meister.figure.Circle;
import io.meister.figure.Figure;
import io.meister.figure.Oval;

import java.awt.*;

public class CircleFactory extends OvalFactory {

    public CircleFactory() {
        keyChar = 'c';
    }

    public Figure create(Point first, Point second) {
        this.first = first;
        this.second = second;

        optimizePoints();

        return new Circle(
                this.first.x,
                this.first.y,
                (this.size.height < this.size.width) ? this.size.height : this.size.width
        );
    }
}
