package italo.pacman.desenho;

import italo.pacman.SistemaAplic;
import italo.pacman.gui.desenho.Desenho;
import java.awt.Graphics;
import italo.pacman.gui.desenho.PainelDesenho;
import italo.pacman.nucleo.to.Fase;
import italo.pacman.nucleo.to.Jogo;

public class JogoDesenho implements Desenho {

    private final FaseDesenho faseDesenho;
    private final PlacarDesenho placarDesenho;
    private final MensagemDesenho mensagemDesenho;
    
    private final SistemaAplic aplic;

    public JogoDesenho( SistemaAplic aplic ) {
        this.faseDesenho = new FaseDesenho();
        this.placarDesenho = new PlacarDesenho();
        this.mensagemDesenho = new MensagemDesenho();
        this.aplic = aplic;
    }        
    
    @Override
    public void desenha( Graphics g, PainelDesenho tela ) {        
        Jogo jogo = aplic.getJogo();
        Fase fase = aplic.getJogoManager().getFaseCorrente( jogo );

        placarDesenho.desenha( jogo, g, tela );
        faseDesenho.desenha( jogo, fase, g, tela );        
        
        mensagemDesenho.desenha( jogo, fase, g, tela );
    }
    
}
