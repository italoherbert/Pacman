package italo.pacman.nucleo.logica.util;

import italo.pacman.nucleo.to.Personagem;

public class MatematicaUtil {
    
    public double distancia( Personagem p1, Personagem p2 ) {
        return this.distancia( p1.getX(), p1.getY(), p2.getX(), p2.getY() );
    }
    
    public double distancia( int x1, int y1, int x2, int y2 ) {
        return Math.sqrt( Math.pow( x2-x1, 2 ) + Math.pow( y2-y1, 2 ) );
    }
    
}
