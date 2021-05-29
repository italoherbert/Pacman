package italo.pacman.nucleo.logica;

import italo.pacman.nucleo.to.Fase;
import italo.pacman.nucleo.to.Personagem;

public class FaseManager {
    
    public boolean isPosicaoCelula( Personagem personagem, Fase fase ) {
        boolean ehPosH = this.isPosicaoHorizontal( personagem, fase );
        boolean ehPosV = this.isPosicaoVertical( personagem, fase );        
        return ( ehPosH && ehPosV );
    }
    
    public boolean isPosicaoHorizontal( Personagem personagem, Fase fase ) {
        int cw = fase.getCelulaLargura();        
        int x = personagem.getX() - (cw/2);        
        return ( x % cw == 0 );
    }
    
    public boolean isPosicaoVertical( Personagem personagem, Fase fase ) {
        int ch = fase.getCelulaAltura();        
        int y = personagem.getY() - (ch/2);        
        return ( y % ch == 0 );
    }
    
}
