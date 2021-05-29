package italo.pacman.nucleo.logica;

import italo.pacman.nucleo.to.Truque;
import italo.pacman.nucleo.to.TruqueListener;
import java.awt.event.KeyEvent;

public class TruqueManager {
    
    public void novoCharPressinado( Truque truque, char ch ) {                
        String truqueTexto = truque.getTruqueTexto();
        int cont = truque.getCont();        
        if ( cont >= truqueTexto.length() )
            return;                    
                
        char ch2 = Character.toLowerCase( truqueTexto.charAt( cont ) );
        char ch3 = Character.toLowerCase( ch );
        if ( ( ch2 == ch3 || ch2 == '?' ) && ch != KeyEvent.VK_ENTER ) {
            truque.getTruqueDigitado()[ cont ] = ch;
            if ( cont == truqueTexto.length()-1 )
                truque.setProcessarTruque( true );             
            
            cont++;
        } else {
            cont = 0;
        }
        truque.setCont( cont ); 
    }
    
    public void processaTruqueAtivado( Truque truque ) {
        if ( truque.isProcessarTruque() ) {
            TruqueListener listener = truque.getTruqueListener();
            if ( listener != null )
                listener.executa( truque.getTruqueDigitado() ); 
            
            truque.setProcessarTruque( false );
            truque.setCont( 0 ); 
        }
    }
    
}
