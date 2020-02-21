/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lienzoarbol;

import java.awt.Graphics;
import javax.swing.JPanel;
import logica.Arbol;
import logica.Nodo;

/**
 *
 * @author daniel
 */
public class Lienzo extends JPanel {
    private Arbol objArbol;
    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 50;

    public void setObjArbol(Arbol objArbol) {
        this.objArbol = objArbol;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        pintar(g, getWidth() / 2, 20, objArbol.getRaiz());
    }
    
    void pintar(Graphics g, int x, int y, Nodo n) {
        if (n == null)
        {}
        else {
            int EXTRA = n.nodosCompletos(n) * (ANCHO / 2);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.drawString(n.getElemento().toString(), x + 12, y + 18);
            if (n.getIzquierda() != null)
                g.drawLine(x , y + RADIO, x - ANCHO - EXTRA + RADIO , y + ANCHO);
            if (n.getDerecha() != null)
                g.drawLine(x + RADIO * 2, y + RADIO, x + ANCHO + EXTRA + RADIO , y + ANCHO );    
                pintar(g, x - ANCHO - EXTRA, y + ANCHO, n.getIzquierda());
                pintar(g, x + ANCHO + EXTRA, y + ANCHO, n.getDerecha());
        }
    }
    
}
