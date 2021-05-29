package italo.pacman.nucleo.logica;

import italo.pacman.nucleo.to.Fase;
import italo.pacman.nucleo.to.Pacman;

public class PacmanManager {
         
    public void calculaNovoBocaFator( Pacman pacman ) {
        int bf = pacman.getBocaFator();
        int quantBF = pacman.getQuantBocaFatores();
        pacman.setBocaFator( (bf+1) % quantBF );        
    }               
                    
    public int comeBolinha( Fase fase, Pacman pacman ) {
        int[][] bolinhas = fase.getBolinhas();
        int cw = fase.getCelulaLargura();
        int ch = fase.getCelulaAltura();
        
        int x = pacman.getX();
        int y = pacman.getY();
        
        int xx = x / cw;
        int yy = y / ch;
        
        switch( bolinhas[ yy ][ xx ] ) {
            case Fase.BOLINHA:
                bolinhas[ yy ][ xx ] = Fase.SEM_BOLINHA;
                return Fase.BOLINHA;                
            case Fase.BOLINHA_GRANDE:
                bolinhas[ yy ][ xx ] = Fase.SEM_BOLINHA;
                return Fase.BOLINHA_GRANDE;                
        }
        return Fase.SEM_BOLINHA;
    }  
        
}
