package italo.pacman.nucleo.logica;

import italo.pacman.nucleo.logica.aestrela.CelulaTiposCondicao;
import italo.pacman.nucleo.to.Fase;
import italo.pacman.nucleo.to.Personagem;
import java.util.LinkedList;

public class AEstrelaManager {
                    
    public void configuraNovaDirMaisProxima( Personagem p1, Personagem p2, 
            Fase fase, 
            CelulaTiposCondicao ctipoCondicao ) {
        
        int pcx = p2.getX();
        int pcy = p2.getY();
        this.configuraNovaDirMaisProxima( p1, fase, pcx, pcy, ctipoCondicao );
    }
    
    public void configuraNovaDirMaisProxima( Personagem personagem, Fase fase, 
            int pcx, int pcy, 
            CelulaTiposCondicao ctipoCondicao ) {
        
        int[][] paredes = fase.getParedes();
        int cw = fase.getCelulaLargura();
        int ch = fase.getCelulaAltura();
        
        int cx1 = ( personagem.getX() - (cw/2) ) / cw;
        int cy1 = ( personagem.getY() - (ch/2) ) / ch;
        int cx2 = ( pcx - (cw/2) ) / cw;
        int cy2 = ( pcy - (ch/2) ) / ch;
        
        int[][] tabuleiro = fase.getTabuleiroAEstrela();
        for( int i = 0; i < tabuleiro.length; i++ )
            for( int j = 0; j < tabuleiro[ i ].length; j++ )
                tabuleiro[ i ][ j ] = 0;
        
        int[][] dirs = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
        };
        
        LinkedList<int[]> celulas = new LinkedList();
                   
        celulas.addLast( new int[] { cx1, cy1 } );
        
        boolean achou = false;
        while( !achou && !celulas.isEmpty() ) {
            int[] c = celulas.removeFirst();
            int h = tabuleiro[ c[1] ][ c[0] ];
            for( int i = 0; !achou && i < dirs.length; i++ ) {
                int x = c[ 0 ] + dirs[ i ][ 0 ];
                int y = c[ 1 ] + dirs[ i ][ 1 ];                 
                if ( x >= 0 && x < tabuleiro[0].length && y >= 0 && y < tabuleiro.length ) {
                    if ( ctipoCondicao.condicao( paredes[ y ][ x ] ) ) {
                        int h2 = tabuleiro[ y ][ x ];
                        if ( h2 == 0 || h2 > h+10 ) {
                            tabuleiro[ y ][ x ] = h + 10;                    
                            celulas.addLast( new int[] { x, y } );
                            if ( x == cx2 && y == cy2 ) {                                
                                achou = true; 
                            }
                        }
                    }
                }
            }            
        }                        
        
        if ( !achou )
            return;
                       
        achou = false;
        int x = cx2;
        int y = cy2;
                        
        while( !achou ) {
            int h = tabuleiro[ y ][ x ];
            int x1 = x;
            int y1 = y;            
            for( int i = 0; !achou && i < dirs.length; i++ ) {
                int x2 = x1 + dirs[ i ][ 0 ];
                int y2 = y1 + dirs[ i ][ 1 ];
                if ( x2 >= 0 && x2 < tabuleiro[0].length && y2 >= 0 && y2 < tabuleiro.length ) {
                    int h2 = tabuleiro[ y2 ][ x2 ];
                    if ( h2 == 0 && ( x2 != cx1 || y2 != cy1 ) )
                        continue;

                    if ( x2 == cx1 && y2 == cy1 ) {
                        achou = true;
                    } else if ( h2 < h ) {
                       h = h2;
                       x = x2;
                       y = y2;
                    } 
                }
            }  
        }

        if ( !achou )
            return;
            
        if ( cx1 + 1 == x && cy1 == y ) {
            personagem.setNovaDirecao( Personagem.FRENTE );
        } else if ( cx1 - 1 == x && cy1 == y ) {
            personagem.setNovaDirecao( Personagem.TRAZ );
        } else if ( cx1 == x && cy1 + 1 == y ) {
            personagem.setNovaDirecao( Personagem.BAIXO );
        } else if ( cx1 == x && cy1 - 1 == y ) {
            personagem.setNovaDirecao( Personagem.CIMA );
        }        
        
    }
    
}
