package io.meister.figure;

public class Square extends Box {

    public static char shortcutchar = 's';

    public Square(int posx, int posy, int side) {
        super(posx, posy, side, side);
    }
}
