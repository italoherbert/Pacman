package italo.pacman.nucleo.logica;

import italo.pacman.nucleo.to.Fase;
import italo.pacman.nucleo.to.Jogo;
import italo.pacman.nucleo.to.Personagem;

public class JogoManager {                         
        
    private final TodosManagers managers;

    public JogoManager( TodosManagers managers ) {
        this.managers = managers;
    }
    
    public void verificaSeVenceu( Jogo jogo, Fase fase ) {
        int quantBolinhas = this.getFaseCorrenteQuantBolinhas( jogo );
        fase.setVenceu( quantBolinhas == 0 );
    }
    
    public void incPontos( Jogo jogo, int pontos ) {
        jogo.setPontuacao( jogo.getPontuacao() + pontos ); 
        
        int pontuacao = jogo.getPontuacao();
        int ultPontuacao = jogo.getUltimaPontuacaoIncVida();
        int quantPontosParaGanharVida = jogo.getQuantPontosParaGanharVida();
        if ( pontuacao - ultPontuacao > quantPontosParaGanharVida ) {
            jogo.setNVidas( jogo.getNVidas() + 1 );
            jogo.setUltimaPontuacaoIncVida( jogo.getUltimaPontuacaoIncVida() + jogo.getQuantPontosParaGanharVida() ); 
        }
    }
    
    public boolean proximaFase( Jogo jogo ) {        
        if ( jogo.getFaseCorrente() == jogo.getFases().length-1 )
            return false;
        
        jogo.setFaseCorrente( jogo.getFaseCorrente() + 1 ); 
        return true;
    }
    
    public Fase getFaseCorrente( Jogo jogo ) {
        return jogo.getFases()[ jogo.getFaseCorrente() ];
    }
    
    public int getFaseCorrenteQuantBolinhas( Jogo jogo ) {
        Fase fase = this.getFaseCorrente( jogo );
        int[][] bolinhas = fase.getBolinhas();
        
        int cont = 0;
        for( int i = 0; i < bolinhas.length; i++ )
            for( int j = 0; j < bolinhas[i].length; j++ )
                if ( bolinhas[i][j] == 1 )
                    cont++;
        return cont;
    }
    
    public void setAtravessarParedes( Jogo jogo, boolean atravessarParedes ) {
        if ( atravessarParedes ) {
            jogo.setAtravessarParedes( true );
        } else {
            jogo.setSetarComoNaoAtravessarParedes( true ); 
        }
    }
    
    public void processaNaoAtravessarParedes( Jogo jogo, Fase fase, Personagem personagem ) {
        FaseManager faseManager = managers.getFaseManager();
        
        boolean atr = jogo.isAtravessarParedes();
        boolean setarComoNAtr = jogo.isSetarComoNaoAtravessarParedes();
        boolean celPosic = faseManager.isPosicaoCelula( personagem, fase );
        if ( celPosic && atr && setarComoNAtr ) {
            jogo.setAtravessarParedes( false );
            jogo.setSetarComoNaoAtravessarParedes( false ); 
        }            
    }    
        
    public void delay( int delay ) {
        try {
            Thread.sleep( delay ); 
        } catch ( InterruptedException e ) {
            
        }
    }
    
}
