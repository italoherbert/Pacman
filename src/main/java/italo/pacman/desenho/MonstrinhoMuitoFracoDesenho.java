package italo.pacman.desenho;

import italo.pacman.nucleo.to.Fase;
import italo.pacman.nucleo.to.Monstrinho;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class MonstrinhoMuitoFracoDesenho {
    
    private final MonstrinhoOlhoDesenho monstrinhoOlhoDesenho;

    public MonstrinhoMuitoFracoDesenho( MonstrinhoOlhoDesenho monstrinhoOlhoDesenho ) {
        this.monstrinhoOlhoDesenho = monstrinhoOlhoDesenho;
    }
    
    public void desenha( Monstrinho monstrinho, Fase fase, Graphics g, 
            Stroke stroke, Color bordaCor, Color cor ) {
        int cw = fase.getCelulaLargura();
        int ch = fase.getCelulaAltura();
        int tx = fase.getTabuleiroX();
        int ty = fase.getTabuleiroY();
        
        int mx = tx + monstrinho.getX();
        int my = ty + monstrinho.getY();
        double olhinhoAngulo = monstrinho.getOlhoAngulo();
        
        int d = (int)( (double)Math.min( cw, ch ) / 2 ); 

        ((Graphics2D)g).setStroke( stroke ); 
        monstrinhoOlhoDesenho.desenha( g, olhinhoAngulo, mx-d, my-d, d, bordaCor, cor );
        monstrinhoOlhoDesenho.desenha( g, olhinhoAngulo, mx, my-d, d, bordaCor, cor );
    }
    
}
