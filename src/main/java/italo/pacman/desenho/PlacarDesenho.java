package italo.pacman.desenho;

import italo.pacman.gui.desenho.PainelDesenho;
import italo.pacman.nucleo.to.Jogo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class PlacarDesenho {
    
    private final String vidasTexto = "Vidas=";
    private final String faseTexto = "Fase=";
    private final String pontuacaoTexto = "Pontos=";
        
    public void desenha( Jogo jogo, Graphics g, PainelDesenho tela ) {
        g.setFont( jogo.getPlacarFont() );     
        
        String nvidasTexto = String.valueOf( jogo.getNVidas() );
        String nfaseTexto = String.valueOf( jogo.getFaseCorrente()+1 );
        String npontosTexto = String.valueOf( jogo.getPontuacao() );
                        
        Rectangle2D vidasRet = g.getFontMetrics().getStringBounds( vidasTexto, g );
        Rectangle2D faseRet = g.getFontMetrics().getStringBounds( faseTexto, g );
        Rectangle2D pontosRet = g.getFontMetrics().getStringBounds( pontuacaoTexto, g );
        
        Rectangle2D vidasValorRet = g.getFontMetrics().getStringBounds( nvidasTexto, g );
        Rectangle2D faseValorRet = g.getFontMetrics().getStringBounds( nfaseTexto, g );
        Rectangle2D pontosValorRet = g.getFontMetrics().getStringBounds( npontosTexto, g );
        
        int esp = 30;
        
        Color textoCor = Color.WHITE;
        Color valorCor = Color.GREEN;
        
        int w = (int)( jogo.getBorda() + vidasRet.getWidth() + vidasValorRet.getWidth() + esp +
                faseRet.getWidth() + faseValorRet.getWidth() + esp + 
                pontosRet.getWidth() + pontosValorRet.getWidth() );
        
        int x = ( tela.getWidth() - w ) / 2;
        int y = jogo.getBorda() + jogo.getPlacarH();                
        
        g.setColor( textoCor );
        g.drawString( vidasTexto, x, y );
        
        x += vidasRet.getWidth();
        
        g.setColor( valorCor );
        g.drawString( nvidasTexto, x, y );
        
        x += vidasValorRet.getWidth() + esp;
        
        g.setColor( textoCor );
        g.drawString( faseTexto, x, y );
        
        x += faseRet.getWidth();
        
        g.setColor( valorCor );
        g.drawString( nfaseTexto, x, y );
        
        x += faseValorRet.getWidth() + esp;
        
        g.setColor( textoCor );
        g.drawString( pontuacaoTexto, x, y );
        
        x += pontosRet.getWidth();
        
        g.setColor( valorCor );
        g.drawString( npontosTexto, x, y );
    }
    
}
