package italo.pacman.nucleo.logica.aestrela;

import italo.pacman.nucleo.to.Fase;

public class PortaCelulaTiposCondicao implements CelulaTiposCondicao {

    @Override
    public boolean condicao( int celulaTipo ) {
        return celulaTipo != Fase.CELULA_PAREDE;
    }
    
}
