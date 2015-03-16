package io.meister.figure;

import java.awt.*;

public class Text extends Figure {

    private String content;

    public static char shortcutchar = 't';

    public Text(int startPosX, int startPosY, String content) {
        super(startPosX, startPosY);
        this.content = content;
    }

    public void draw(Graphics g) {
        g.drawString(this.content,this.startPosX,this.startPosY);
    }
}
