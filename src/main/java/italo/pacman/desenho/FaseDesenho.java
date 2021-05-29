package italo.pacman.desenho;

import italo.pacman.nucleo.to.Fase;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import italo.pacman.gui.desenho.PainelDesenho;
import italo.pacman.nucleo.to.Jogo;
import italo.pacman.nucleo.to.Monstrinho;

public class FaseDesenho {

    private final BasicStroke strokeTabuleiro = new BasicStroke( 15, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND );
    
    private final BasicStroke strokeMonstrinhoNormal = new BasicStroke( 1 );
    private final BasicStroke strokeMonstrinhoFraco = new BasicStroke( 2 );
    
    private final PacmanDesenho pacmanDesenho;
    private final MonstrinhoDesenho monstrinhoDesenho;
    private final MonstrinhoMuitoFracoDesenho monstrinhoMFDesenho;
    
    private int monstrinhoEstadoContador = 0;
    private int monstrinhoEstadoContador2 = 0;
    
    public FaseDesenho() {
        MonstrinhoOlhoDesenho monstOlhoDesenho = new MonstrinhoOlhoDesenho();
        
        this.pacmanDesenho = new PacmanDesenho();        
        this.monstrinhoDesenho = new MonstrinhoDesenho( monstOlhoDesenho );
        this.monstrinhoMFDesenho = new MonstrinhoMuitoFracoDesenho( monstOlhoDesenho );
    }
    
    public void desenha( Jogo jogo, Fase fase, Graphics g, PainelDesenho tela ) {
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setStroke( strokeTabuleiro );
        g2d.setColor( Color.WHITE );
        this.desenhaTabuleiro( fase, g );        
        
        g2d.setColor( Color.RED );
        this.desenhaPortas( fase, g );
        
        g2d.setColor( Color.ORANGE );
        this.desenhaBolinhas( fase, g ); 
        
        pacmanDesenho.desenha( fase.getPacman(), fase, g );       
        
        this.desenhaMonstrinhos( jogo, fase, g );        
        
        /*
        int x = fase.getTabuleiroX() + fase.getCasinhaPortaX();
        int y = fase.getTabuleiroY() + fase.getCasinhaPortaY();
        
        g.setColor( Color.YELLOW ); 
        g.fillArc( x-4, y-4, 8, 8, 0, 360 );
        */
    }
    
    private void desenhaTabuleiro( Fase fase, Graphics g ) {
        Graphics2D g2d = (Graphics2D)g;

        int tx = fase.getTabuleiroX();
        int ty = fase.getTabuleiroY();
        
        int cw = fase.getCelulaLargura();
        int ch = fase.getCelulaAltura();
        
        int[][] paredes = fase.getParedes();
                        
        for( int i = 0; i < paredes.length; i++ ) {
            for( int j = 0; j < paredes[i].length; j++ ) {
                if ( this.ehCelulaVasiaOuCasa( paredes, j, i ) ) 
                    continue;
        
                if ( i > 0 ) {
                    if ( this.ehCelulaSolidaOuSaida( paredes, j, i-1 ) ) {
                        g2d.drawLine( 
                            tx + (j*cw) + (int)(cw*.5d), 
                            ty + (i*ch),
                            tx + (j*cw) + (int)(cw*.5d),
                            ty + (i*ch) + (int)(ch*.5d)
                        );
                    }
                }
                
                if ( i < paredes.length-1 ) {
                    if ( this.ehCelulaSolidaOuSaida( paredes, j, i+1 ) ) {
                        g2d.drawLine( 
                            tx + (j*cw) + (int)(cw*.5d), 
                            ty + (i*ch) + (int)(ch*.5d),
                            tx + (j*cw) + (int)(cw*.5d),
                            ty + ((i+1)*ch)
                        );
                    }
                }
                
                if ( j > 0 ) {
                    if ( this.ehCelulaSolidaOuSaida( paredes, j-1, i ) ) {
                        g2d.drawLine( 
                            tx + (j*cw), 
                            ty + (i*ch) + (int)(ch*.5d),
                            tx + (j*cw) + (int)(cw*.5d),
                            ty + (i*ch) + (int)(ch*.5d)
                        );
                    }
                }
                
                if ( j < paredes[i].length-1 ) {
                    if ( this.ehCelulaSolidaOuSaida( paredes, j+1, i ) ) {
                        g2d.drawLine( 
                            tx + (j*cw) + (int)(cw*.5d), 
                            ty + (i*ch) + (int)(ch*.5d),
                            tx + ((j+1)*cw),
                            ty + (i*ch) + (int)(ch*.5d)
                        );
                    }
                }
                
                /*g2d.setStroke( new BasicStroke( 1 ) );
                g2d.setColor( Color.BLUE );
                g2d.drawRect( tx + (j*cw), ty + (i*ch), cw, ch );*/
            }                        
        }                                 
    }
    
    public void desenhaPortas( Fase fase, Graphics g ) {
        int tx = fase.getTabuleiroX();
        int ty = fase.getTabuleiroY();
        
        int cw = fase.getCelulaLargura();
        int ch = fase.getCelulaAltura();
        
        int[][] paredes = fase.getParedes();
        
        for( int i = 0; i < paredes.length; i++ ) {
            for( int j = 0; j < paredes[i].length; j++ ) {
                if ( paredes[ i ][ j ] == Fase.CELULA_PORTA_H ) {
                    g.drawLine(
                        tx + (j*cw), 
                        ty + (i*ch) + (int)(ch*.5d),
                        tx + (j*cw) + cw,
                        ty + (i*ch) + (int)(ch*.5d)
                    );
                } else if ( paredes[ i ][ j ] == Fase.CELULA_PORTA_V ) {
                    g.drawLine(
                        tx + (j*cw) + (int)(cw*.5d), 
                        ty + (i*ch),
                        tx + (j*cw) + (int)(cw*.5d),
                        ty + (i*ch) + ch
                    );
                }
                
                    
            }
        }
    }
    
    public void desenhaBolinhas( Fase fase, Graphics g ) {
        int cw = fase.getCelulaLargura();
        int ch = fase.getCelulaAltura();
        
        int tx = fase.getTabuleiroX();
        int ty = fase.getTabuleiroY();
                
        int bolR = 4;
        int gbolR = 6;
        
        int[][] bolinhas = fase.getBolinhas();
        for( int i = 0; i < bolinhas.length; i++ ) {
            for( int j = 0; j < bolinhas[i].length; j++ ) {
                int x = tx + ( j * cw ) + ( cw / 2 );
                int y = ty + ( i * ch ) + ( ch / 2 );
                switch ( bolinhas[ i ][ j ] ) {
                    case Fase.BOLINHA:
                        g.setColor( Color.ORANGE );
                        g.fillArc( x - bolR, y - bolR, 2*bolR, 2*bolR, 0, 360 );
                        break;
                    case Fase.BOLINHA_GRANDE:
                        g.setColor( Color.GREEN ); 
                        g.fillArc( x - gbolR, y - gbolR, 2*gbolR, 2*gbolR, 0, 360 );
                        break;                                                        
                } 
            }
        }
    }
    
    public void desenhaMonstrinhos( Jogo jogo, Fase fase, Graphics g ) {
        Monstrinho[] monstrinhos = fase.getMonstrinhos();
        for( Monstrinho monstrinho : monstrinhos ) {
            switch( monstrinho.getEstado() ) {
                case Monstrinho.NORMAL:
                    monstrinhoDesenho.desenha( 
                            monstrinho, fase, g, 
                            strokeMonstrinhoNormal, 
                            Color.WHITE, monstrinho.getCor(), Color.WHITE ); 
                    break;
                case Monstrinho.FRACO:
                    monstrinhoDesenho.desenha( 
                            monstrinho, fase, g, 
                            strokeMonstrinhoFraco, 
                            Color.GRAY, Color.BLACK, Color.BLACK ); 
                    break;
                case Monstrinho.MELHORANDO:
                    if ( monstrinhoEstadoContador % 10 == 0 ) 
                        monstrinhoEstadoContador2++;
                    
                    if ( monstrinhoEstadoContador2 % 2 == 0 || jogo.isPausa() ) {
                        monstrinhoDesenho.desenha( 
                            monstrinho, fase, g, 
                            strokeMonstrinhoFraco, 
                            Color.GRAY, Color.BLACK, Color.BLACK ); 
                    } else {
                        monstrinhoDesenho.desenha( 
                            monstrinho, fase, g, 
                            strokeMonstrinhoFraco, 
                            Color.LIGHT_GRAY, Color.GRAY, Color.LIGHT_GRAY );
                    }
                    
                    monstrinhoEstadoContador++;
                    break;
                case Monstrinho.MUITO_FRACO:
                    monstrinhoMFDesenho.desenha( 
                            monstrinho, fase, g, 
                            strokeMonstrinhoNormal, 
                            Color.DARK_GRAY, Color.WHITE );
                    break;
            }
        }
    }
    
    private boolean ehCelulaSolidaOuSaida( int[][] paredes, int x, int y ) {
        return paredes[ y ][ x ] == Fase.CELULA_PAREDE || 
                paredes[ y ][ x ] == Fase.CELULA_PORTA_H ||
                paredes[ y ][ x ] == Fase.CELULA_PORTA_V;
    }
    
    private boolean ehCelulaVasiaOuCasa( int[][] paredes, int x, int y ) {
        return paredes[ y ][ x ] == Fase.CELULA_LIVRE || 
                paredes[ y ][ x ] == Fase.CELULA_CASA ||
                paredes[ y ][ x ] == Fase.CELULA_SAIDA;
    }
    
}
