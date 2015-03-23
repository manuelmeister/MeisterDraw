package io.meister;

import io.meister.figure.Figure;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.*;

/**
 * Papier ist eine von JPanel abgeleitete Swing-Komponente.
 * - Sie dient als "Zeichenblatt" f¸r Zeichnungen.
 * - Sie speichert die Zeichnung in einer Instanzvariablen.
 * - Sie ¸berschreibt die Methode paintComponent der Klasse JPanel
 * so, dass bei ihrem Aufruf die Zeichnung auf das Papier gezeichnet
 * wird.
 *
 * @author Andres Scheidegger
 */
@SuppressWarnings("serial")
public class Paper extends JPanel implements MouseListener, KeyListener {
    /**
     * Die Zeichnung.
     */
    private Drawing drawing;

    private FigureFactory figureFactory;

    private Map<Character, FigureFactory> factories;

    private Point firstPoint, secondPoint;

    public Paper() {
        this.factories = FactoryLoader.load();
        this.figureFactory = factories.get('r');
        addMouseListener(this);
        addKeyListener(this);
    }

    /**
     * Die Methode paintComponent zeichnet die Zeichnung auf das Papier.
     * Sie erh‰lt dazu ein Graphics-Objekt, welches sie an die Zeichnung
     * weitergibt.
     *
     * @param g Graphics-Objekt, welches zum zeichnen verwendet werden soll.
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (drawing != null) drawing.draw(g);
    }

    /**
     * Setter für die Instanzvariable zeichnung.
     *
     * @param drawing Die zu zeichnende Zeichnung.
     */
    public void setDrawing(final Drawing drawing) {
        this.drawing = drawing;
    }

    public void mousePressed(MouseEvent e) {
        this.firstPoint = new Point(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {

        // Bestimmen Breite und Hoehe des neuen Rechtecks
        // Wenn die neue X Maus Position grösser ist als die initale, dann nimm die initiale, sonst die Neue

        this.secondPoint = new Point(e.getX(), e.getY());

        // Erzeugen ein neues Rechteckobjekt und speichern dieses
        // in der Zeichnung. Anschliessend alles neu zeichnen.
        Figure figure;
        try {
            figure = figureFactory.create(this.firstPoint, this.secondPoint);
            drawing.add(figure);
        } catch (Exception exeption) {
            Window parentWindow = SwingUtilities.windowForComponent(this);
            Frame parentFrame = null;
            if (parentWindow instanceof Frame) {
                parentFrame = (Frame) parentWindow;
            }
            JDialog dialog = new JDialog(parentFrame, "Information");
            dialog.setSize(200, 100);
            dialog.add(new JLabel("Tool nicht verfügbar"));
            dialog.setLocation(300, 300);
            dialog.setVisible(true);
            this.figureFactory = factories.get('r');
            figure = figureFactory.create(this.firstPoint, this.secondPoint);
            drawing.add(figure);
        }
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
        Character keyChar = e.getKeyChar();
        this.figureFactory = factories.get((keyChar == null ? 'r' : keyChar));
    }

    public void keyReleased(KeyEvent e) {

    }
}
