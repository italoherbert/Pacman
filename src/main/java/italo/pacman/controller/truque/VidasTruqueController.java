package italo.pacman.controller.truque;

import italo.pacman.SistemaAplic;
import italo.pacman.nucleo.to.TruqueListener;

public class VidasTruqueController implements TruqueListener {

    private final SistemaAplic aplic;

    public VidasTruqueController(SistemaAplic aplic) {
        this.aplic = aplic;
    }
    
    @Override
    public void executa( char[] truque ) {        
        int ncasas = 0;
        
        System.out.println( new String( truque  ) );
        
        boolean ehNumero = true;
        while( ehNumero && ncasas < truque.length ) {       
            char ch = truque[ ncasas ];
            if ( Character.isDigit( ch ) ) {
                ncasas++;
            } else {
                ehNumero = false;
            }
        }        
                
        char[] vidasCHs = new char[ ncasas ];
        for( int i = 0; i < ncasas; i++ )
            vidasCHs[ i ] = truque[ i ];
                  
        int vidas = Integer.parseInt( new String( vidasCHs ) );
        
        aplic.getJogo().setNVidas( vidas ); 
    }
    
}
