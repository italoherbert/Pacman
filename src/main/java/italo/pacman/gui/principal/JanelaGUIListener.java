package italo.pacman.gui.principal;

public interface JanelaGUIListener {
    
    public final static int TRAZ = 1;
    public final static int BAIXO = 2;
    public final static int FRENTE = 3;
    public final static int CIMA = 4;
    public final static int ENTER = 5;
    public final static int ESC = 6;    
    
    public void teclaCharPressionada( char ch );
    
    public void teclaFuncPressionada( int tecla );
    
    public void fechandoJanela();
    
}
