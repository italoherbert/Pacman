package italo.pacman.nucleo.logica.ini;

import italo.pacman.nucleo.to.TruqueListener;

public interface GrupoTruqueListener {
    
    public TruqueListener getPularFaseTruqueListener();
    
    public TruqueListener getVidasTruqueListener();
    
    public TruqueListener getAtravessarParedesTruqueListener();
    
}
