package italo.pacman;

import javax.swing.SwingUtilities;

public class PacmanMain {
    
    public static void main( String[] args ) {
        SistemaAplic aplic = new SistemaAplic();
        
        SwingUtilities.invokeLater( () -> {
            aplic.getGUI().getJanelaGUI().setVisible( true ); 
            aplic.executa();
        } );
    }
    
}
