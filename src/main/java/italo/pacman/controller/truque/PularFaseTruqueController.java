package italo.pacman.controller.truque;

import italo.pacman.SistemaAplic;
import italo.pacman.nucleo.to.Jogo;
import italo.pacman.nucleo.to.TruqueListener;

public class PularFaseTruqueController implements TruqueListener {
    
    private final SistemaAplic aplic;

    public PularFaseTruqueController(SistemaAplic aplic) {
        this.aplic = aplic;
    }

    @Override
    public void executa( char[] truque ) {
        Jogo jogo = aplic.getJogo();
        int maxFaseI = jogo.getFases().length-1;
                
        int i = truque.length-1;
        char ch = truque[ i ];
        if ( Character.isDigit( ch ) ) {
            int faseI = Integer.parseInt( ""+ch );
            faseI--;
            
            if ( faseI > 0 && faseI <= maxFaseI ) {
                jogo.setFaseCorrente( faseI ); 
                aplic.getGUI().getPainelDesenho().repaint();
            }            
        }            
    }
    
}
