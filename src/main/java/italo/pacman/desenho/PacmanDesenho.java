package italo.pacman.desenho;

import italo.pacman.nucleo.to.Fase;
import italo.pacman.nucleo.to.Pacman;
import italo.pacman.nucleo.to.Personagem;
import java.awt.Color;
import java.awt.Graphics;

public class PacmanDesenho {
        
    public void desenha( Pacman pacman, Fase fase, Graphics g ) {
        int bf = pacman.getBocaFator();
        int atualDir = pacman.getDirecaoAtual();
        
        int px = pacman.getX();
        int py = pacman.getY();
        
        int tx = fase.getTabuleiroX();
        int ty = fase.getTabuleiroY();
        int cw = fase.getCelulaLargura();
        int ch = fase.getCelulaAltura();
        
        int x = tx + px - ( cw / 2 );
        int y = ty + py - ( ch / 2 );
        int w = cw;
        int h = ch;
        
        int bocaAngulo = bf * 45;
        
        int ang1 = bocaAngulo/2;
        int ang2 = 360 - bocaAngulo;
        switch ( atualDir ) {
            case Personagem.FRENTE:
                ang1 = bocaAngulo / 2;
                break;
            case Personagem.BAIXO:
                ang1 = 270 + ( bocaAngulo / 2 );
                break;
            case Personagem.TRAZ:
                ang1 = 180 + ( bocaAngulo / 2 );
                break;
            case Personagem.CIMA:
                ang1 = 90 + ( bocaAngulo / 2 );
                break;
        }
        
        g.setColor( Color.ORANGE ); 
        g.fillArc( x, y, w, h, ang1, ang2 );
        
        //((Graphics2D)g).setStroke( new BasicStroke( 1 ) ); 
        //g.drawRect( x, y, w, h ); 
    }
    
}
