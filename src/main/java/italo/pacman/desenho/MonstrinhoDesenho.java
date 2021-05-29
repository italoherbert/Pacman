package italo.pacman.desenho;

import italo.pacman.nucleo.to.Fase;
import italo.pacman.nucleo.to.Monstrinho;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Stroke;

public class MonstrinhoDesenho {
                
    private final Color bordaOlhoCor = Color.LIGHT_GRAY;
    
    private final MonstrinhoOlhoDesenho monstrinhoOlhoDesenho;

    public MonstrinhoDesenho(MonstrinhoOlhoDesenho monstOlhoDesenho ) {
        this.monstrinhoOlhoDesenho = monstOlhoDesenho;
    }
        
    public void desenha( Monstrinho monstrinho, Fase fase, Graphics g, 
            Stroke stroke, Color bordaCor, Color cor, Color olhoCor ) {
        int cw = fase.getCelulaLargura();
        int ch = fase.getCelulaAltura();
        int tx = fase.getTabuleiroX();
        int ty = fase.getTabuleiroY();
        
        int mx = monstrinho.getX() - cw/2;
        int my = monstrinho.getY() - ch/2;
        double olhinhoAngulo = monstrinho.getOlhoAngulo();
        
        int r = (int)( (double)cw / 2.5d );
        int b = ( ( cw - (2*r) ) / 2 );
        
        Polygon p = new Polygon();
        
        for( int x = -r; x <= r; x++ ) {
            int y = (int)Math.sqrt( r*r - x*x );
            p.addPoint( tx + mx + cw/2 + x, ty + my + r - y );
        }
                
        int x = tx + mx + 2*r + b;
        int y = ty + my + ch;
        
        p.addPoint( x, y );

        int div = 5;
        int linha = 2*r / 5;
        for( int i = 0; i <= div; i++ ) {
            if ( i % 2 == 1 ) {                             
                p.addPoint( x - (i*linha), y );
                p.addPoint( x - (i*linha), y - linha/2 );
            } else {                    
                p.addPoint( x - (i*linha), y - linha/2 );
                p.addPoint( x - (i*linha), y );
            }
        }
        
        p.addPoint( tx + mx + b, ty + my + ch );
                        
        ((Graphics2D)g).setStroke( stroke );
        g.setColor( cor );  
        g.fillPolygon( p );
        
        g.setColor( bordaCor ); 
        g.drawPolygon( p );
        
        int olhoD = 9;        
        int olhoEspX = ( 2*r - 2*olhoD ) / 3;
                
        int olho1X = tx + mx + b + olhoEspX;
        int olho1Y = ty + my + r-olhoD/2;
        int olho2X = tx + mx + b + (2*olhoEspX) + olhoD;
        int olho2Y = ty + my + r-olhoD/2;
                
        monstrinhoOlhoDesenho.desenha( g, olhinhoAngulo, olho1X, olho1Y, olhoD, bordaOlhoCor, olhoCor );
        monstrinhoOlhoDesenho.desenha( g, olhinhoAngulo, olho2X, olho2Y, olhoD, bordaOlhoCor, olhoCor );               
    }
}
