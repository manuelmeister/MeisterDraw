package io.meister;

import io.meister.figure.Box;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * Papier ist eine von JPanel abgeleitete Swing-Komponente.
 * - Sie dient als "Zeichenblatt" f¸r Zeichnungen.
 * - Sie speichert die Zeichnung in einer Instanzvariablen.
 * - Sie ¸berschreibt die Methode paintComponent der Klasse JPanel
 *   so, dass bei ihrem Aufruf die Zeichnung auf das Papier gezeichnet
 *   wird.
 *
 * @author Andres Scheidegger
 */
@SuppressWarnings("serial")
public class Paper extends JPanel implements MouseListener,KeyListener {
    /**
     * Die Zeichnung.
     */
    private Drawing drawing;

    private int x,y;

    public Paper() {

        addMouseListener(this);
        addKeyListener(this);
    }

    /**
     * Die Methode paintComponent zeichnet die Zeichnung auf das Papier.
     * Sie erh‰lt dazu ein Graphics-Objekt, welches sie an die Zeichnung
     * weitergibt.
     *
     * @param g  Graphics-Objekt, welches zum zeichnen verwendet werden soll.
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (drawing != null) drawing.draw(g);
    }

    /**
     * Setter f¸r die Instanzvariable zeichnung.
     *
     * @param drawing Die zu zeichnende Zeichnung.
     */
    public void setDrawing(final Drawing drawing) {
        this.drawing = drawing;
    }

    public void mousePressed(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
    }

    public void mouseReleased(MouseEvent e) {

        // Bestimmen Breite und Hoehe des neuen Rechtecks
        // Wenn die neue X Maus Position grösser ist als die initale, dann nimm die initiale, sonst die Neue
        int startPosX = (e.getX() > this.x) ? this.x : e.getX();
        int startPosY = (e.getY() > this.y) ? this.y : e.getY();
        int width = Math.abs(e.getX() - this.x);
        int height = Math.abs(e.getY() - this.y);

        // Erzeugen ein neues Rechteckobjekt und speichern dieses
        // in der Zeichnung. Anschliessend alles neu zeichnen.

        Box figur = new Box(startPosX, startPosY, height, width);
        drawing.add(figur);
        repaint();
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    // if the mouse is excited ;)
    public void mouseExited(MouseEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
