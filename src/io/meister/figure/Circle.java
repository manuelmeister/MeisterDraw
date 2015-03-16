package io.meister.figure;

public class Circle extends Oval {

    public static char shortcutchar = 'c';

    public Circle(int posx, int posy, int diameter) {
        super(posx, posy, diameter, diameter);
    }
}
