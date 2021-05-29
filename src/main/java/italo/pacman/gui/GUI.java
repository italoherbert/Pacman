package italo.pacman.gui;

import italo.pacman.gui.desenho.PainelDesenho;
import italo.pacman.gui.principal.JanelaGUI;

public class GUI {
    
    private final JanelaGUI janelaGUI = new JanelaGUI();
    
    public JanelaGUI getJanelaGUI() {
        return janelaGUI;
    }
    
    public PainelDesenho getPainelDesenho() {
        return janelaGUI.getDesenhoPNL();
    }
    
}
