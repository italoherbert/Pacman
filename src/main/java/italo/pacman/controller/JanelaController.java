package italo.pacman.controller;

import italo.pacman.SistemaAplic;
import italo.pacman.gui.principal.JanelaGUIListener;
import italo.pacman.nucleo.to.Fase;
import italo.pacman.nucleo.to.Jogo;
import italo.pacman.nucleo.to.Pacman;
import italo.pacman.nucleo.to.Personagem;
import italo.pacman.nucleo.to.Truque;

public class JanelaController implements JanelaGUIListener {

    private final SistemaAplic aplic;

    public JanelaController( SistemaAplic aplic ) {
        this.aplic = aplic;
    }
    
    @Override
    public void teclaFuncPressionada( int tecla ) {
        Jogo jogo = aplic.getJogo();
        Fase fase = aplic.getJogoManager().getFaseCorrente( jogo );
        Pacman pacman = fase.getPacman();
        
        switch( tecla ) {
            case JanelaGUIListener.TRAZ:
                pacman.setNovaDirecao( Personagem.TRAZ );
                break;
            case JanelaGUIListener.FRENTE:
                pacman.setNovaDirecao( Personagem.FRENTE );
                break;
            case JanelaGUIListener.BAIXO:
                pacman.setNovaDirecao( Personagem.BAIXO );
                break;
            case JanelaGUIListener.CIMA:
                pacman.setNovaDirecao( Personagem.CIMA );
                break;
            case JanelaGUIListener.ENTER:
                jogo.setPausa( !jogo.isPausa() ); 
                break;
            case JanelaGUIListener.ESC:
                jogo.setFim( true ); 
                break;
            
                
        }
    }

    @Override
    public void teclaCharPressionada( char ch ) {
        Truque[] truques = aplic.getJogo().getTruques();
        for( Truque truque : truques ) {
            aplic.getTruqueManager().novoCharPressinado( truque, ch ); 
        }
    }

    @Override
    public void fechandoJanela() {
        aplic.getJogo().setFim( true ); 
    }
    
}
