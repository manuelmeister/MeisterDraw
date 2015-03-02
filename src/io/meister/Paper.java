package io.meister;

import io.meister.figure.Square;

import java.awt.*;

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
public class Paper extends JPanel {
    /**
     * Die Zeichnung.
     */
    private Drawing drawing;

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
}
