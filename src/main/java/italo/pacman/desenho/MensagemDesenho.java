package italo.pacman.desenho;

import italo.pacman.gui.desenho.PainelDesenho;
import italo.pacman.nucleo.to.Fase;
import italo.pacman.nucleo.to.Jogo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class MensagemDesenho {
        
    private final String PERDEU = "Você perdeu!";
    private final String VENCEU = "Você venceu!";
    private final String PAUSA = "Pausa!";
    private final String GAMEOVER = "Game Over";
    private final String CONCLUIU = "Você concluiu o jogo, parabéns!";
    
    private final Color INFO_COR = Color.WHITE;
    private final Color PERDEU_COR = Color.RED;
    
    private final Color BG_COR = Color.BLACK;    
    
    private final int BORDA = 5;
    
    public void desenha( Jogo jogo, Fase fase, Graphics g, PainelDesenho tela ) {                
        int tx = fase.getTabuleiroX();
        int ty = fase.getTabuleiroY();
        int tw = fase.getTabuleiroLargura();
        int th = fase.getTabuleiroAltura();
        
        if ( fase.isPerdeu() || fase.isVenceu() || jogo.isPausa() ) {
            String texto = PAUSA;
            Color cor = INFO_COR;
            if ( fase.isPerdeu() ) {
                if ( jogo.getNVidas() == 0 ) {
                    texto = GAMEOVER;
                } else {
                    texto = PERDEU;
                }
                cor = PERDEU_COR;
            } else if ( fase.isVenceu() ) {
                if ( jogo.getFaseCorrente() == jogo.getFases().length-1 ) {
                    texto = CONCLUIU;
                } else {
                    texto = VENCEU;
                }
                cor = INFO_COR;
            } else if ( jogo.isPausa() ) {
                texto = PAUSA;
                cor = INFO_COR;
            }
            
            g.setFont( jogo.getMensagemFont() );
            Rectangle2D ret = g.getFontMetrics().getStringBounds( texto, g );
            
            int w = (int)ret.getWidth();
            int h = (int)ret.getHeight();
            int x = tx + ( ( tw - w - 2*BORDA ) / 2 );
            int y = ty + ( ( th - h - 2*BORDA ) / 2 ) + h;
            
            int rx = x - BORDA;
            int ry = y - h;
            int rw = w + 2*BORDA;
            int rh = h + 2*BORDA;
            
            g.setColor( BG_COR );
            g.fillRect( rx, ry, rw, rh );
            
            g.setColor( cor );
            g.drawRect( rx, ry, rw, rh );
            
            g.drawString( texto, x, y );
        }
    }
}
