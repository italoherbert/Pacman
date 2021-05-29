package italo.pacman.controller.truque;

import italo.pacman.SistemaAplic;
import italo.pacman.nucleo.logica.ini.GrupoTruqueListener;
import italo.pacman.nucleo.to.TruqueListener;

public class GrupoTruqueController implements GrupoTruqueListener {
    
    private final SistemaAplic aplic;

    public GrupoTruqueController(SistemaAplic aplic) {
        this.aplic = aplic;
    }

    @Override
    public TruqueListener getPularFaseTruqueListener() {
        return aplic.getPularFaseTruqueController();
    }

    @Override
    public TruqueListener getVidasTruqueListener() {
        return aplic.getVidasTruqueController();
    }

    @Override
    public TruqueListener getAtravessarParedesTruqueListener() {
        return aplic.getAtravessarParedesTruqueController();
    }    
    
}
