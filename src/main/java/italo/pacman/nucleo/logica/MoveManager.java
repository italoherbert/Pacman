package italo.pacman.nucleo.logica;

import italo.pacman.nucleo.logica.aestrela.PacmanCelulaTipoCondicao;
import italo.pacman.nucleo.to.Fase;
import italo.pacman.nucleo.to.Jogo;
import italo.pacman.nucleo.to.Monstrinho;
import italo.pacman.nucleo.to.Pacman;
import italo.pacman.nucleo.to.Personagem;

public class MoveManager {
        
    private final TodosManagers managers;
    private final PacmanCelulaTipoCondicao pacmanCTipoCondicao = new PacmanCelulaTipoCondicao();

    public MoveManager( TodosManagers managers ) {
        this.managers = managers;
    }
    
    public boolean configuraNovaDirPorRaio( Monstrinho monstrinho, Fase fase, double pacmanDist ) {
        FaseManager faseManager = managers.getFaseManager();
        AEstrelaManager aestrelaManager = managers.getAEstrelaManager();
        MonstrinhoManager monstrinhoManager = managers.getMonstrinhoManager();
        
        Pacman pacman = fase.getPacman();
        int estado = monstrinho.getEstado();
                
        boolean ehCelPosic = faseManager.isPosicaoCelula( monstrinho, fase );
        int raioBuscaPacman = fase.getMonstrinhoRaioBuscaPacman();
        if ( ehCelPosic && pacmanDist <= raioBuscaPacman ) { 
            if ( estado == Monstrinho.NORMAL ) {
                aestrelaManager.configuraNovaDirMaisProxima( monstrinho, pacman, fase, pacmanCTipoCondicao ); 
                return true;
            } else {
                if ( monstrinho.isConfigNovaDirDistanteFlag() ) {
                    monstrinhoManager.configuraNovaDirMaisDistante( monstrinho, pacman, fase );                 
                    monstrinho.setConfigNovaDirDistanteFlag( false ); 
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean move( Personagem personagem, Fase fase, Jogo jogo ) {
        FaseManager faseManager = managers.getFaseManager();
        
        int cw = fase.getCelulaLargura();
        int ch = fase.getCelulaAltura();
        int[][] paredes = fase.getParedes();
        
        int quantCelH = paredes[0].length;
        int quantCelV = paredes.length;
        
        int x = personagem.getX();
        int y = personagem.getY();

        int novaDir = personagem.getNovaDirecao();
                
        boolean moveu = false;
        if ( x + (cw/2) <= cw && novaDir == Personagem.TRAZ ) {
            personagem.setX( ( quantCelH-1 ) * cw );
            moveu = true;
        } else if ( x - (cw/2) >= ( ( quantCelH-1 ) * cw ) && novaDir == Personagem.FRENTE ) {
            personagem.setX( 0 ); 
            moveu = true;
        } else if ( y + (ch/2) <= ch && novaDir == Personagem.CIMA ) {
            personagem.setY( ( quantCelV-1 ) * ch );
            moveu = true;
        } else if ( y - (ch/2) >= ( ( quantCelV-1 ) * ch ) && novaDir == Personagem.BAIXO ) {
            personagem.setY( 0 ); 
            moveu = true;
        } else {                 
            int atualDir = personagem.getDirecaoAtual();
            boolean celPosic = faseManager.isPosicaoCelula( personagem, fase );

            int dirOposta = this.direcaoOposta( atualDir );
            int[] celulaLivreValores = this.calculaCelulaLivreValores( personagem, fase );

            if ( dirOposta == novaDir || celPosic ) {        
                int[] fatorMovXY = this.movIncremento( personagem, fase, jogo, novaDir, celulaLivreValores );
                int fmovX = fatorMovXY[0];
                int fmovY = fatorMovXY[1];
                if ( fmovX != 0 || fmovY != 0 ) {
                    personagem.setX( personagem.getX() + fmovX );
                    personagem.setY( personagem.getY() + fmovY );
                    personagem.setDirecaoAtual( novaDir );            
                    moveu = true;
                }
            }    

            if ( !moveu ) {
                int[] fatorMovXY = this.movIncremento( personagem, fase, jogo, atualDir, celulaLivreValores );
                int fmovX = fatorMovXY[0];
                int fmovY = fatorMovXY[1];
                if ( fmovX != 0 || fmovY != 0 ) {
                    personagem.setX( personagem.getX() + fmovX );
                    personagem.setY( personagem.getY() + fmovY );            
                    moveu = true;
                }
            }                    
        }
        return moveu;
    }                        
                                
    private int[] movIncremento( Personagem personagem, Fase fase, Jogo jogo, int dir, int[] celulaLivreValores ) {        
        FaseManager faseManager = managers.getFaseManager();
        
        int[][] paredes = fase.getParedes();         
        int cw = fase.getCelulaLargura();
        int ch = fase.getCelulaAltura();
        
        int fmovX = 0;
        int fmovY = 0;
        
        int x = personagem.getX();
        int y = personagem.getY();
                
        boolean ehPosH = faseManager.isPosicaoHorizontal( personagem, fase );
        boolean ehPosV = faseManager.isPosicaoVertical( personagem, fase );
        
        boolean atrParedes = jogo.isAtravessarParedes() && personagem.isAtravessarParedes();

        int xx;
        int yy;
        
        switch( dir ) {
            case Personagem.FRENTE:    
                xx = ( ( x - (cw/2) ) / cw ) + 1;
                yy = ( y - (ch/2) ) / ch;
                if ( ( atrParedes && ehPosV ) || this.ehCelulaLivre( paredes, xx, yy, celulaLivreValores ) )
                    fmovX = 1;
                break;
            case Personagem.TRAZ: 
                xx = ( ( (x-1) - (cw/2) ) / cw );
                yy = ( y - (ch/2) ) / ch;
                if ( ( atrParedes && ehPosV ) || this.ehCelulaLivre( paredes, xx, yy, celulaLivreValores ) )
                    fmovX = -1;
                break;                                
            case Personagem.CIMA:
                xx = ( x - (cw/2) ) / cw;
                yy = ( ( (y-1) - (ch/2) ) / ch );
                if ( ( atrParedes && ehPosH ) || this.ehCelulaLivre( paredes, xx, yy, celulaLivreValores ) )
                    fmovY = -1;                
                break;
            case Personagem.BAIXO:
                xx = ( x - (cw/2) ) / cw;
                yy = ( ( y - (ch/2) ) / ch ) + 1;
                if ( ( atrParedes && ehPosH ) || this.ehCelulaLivre( paredes, xx, yy, celulaLivreValores ) )
                    fmovY = 1;
                break;
        }
                       
        return new int[] { fmovX, fmovY };
    }
    
    private int[] calculaCelulaLivreValores( Personagem personagem, Fase fase ) {
        if ( personagem instanceof Monstrinho ) {                        
            int[][] paredes = fase.getParedes();
            int cw = fase.getCelulaLargura();
            int ch = fase.getCelulaAltura();

            int x = personagem.getX();
            int y = personagem.getY();

            int xx = ( x - ( cw/2 ) ) / cw;
            int yy = ( y - ( ch/2 ) ) / ch;
            
            Monstrinho m = (Monstrinho)personagem;
            int estado = m.getEstado();
            if ( paredes[ yy ][ xx ] == Fase.CELULA_CASA || 
                    paredes[ yy ][ xx ] == Fase.CELULA_PORTA_H || 
                    paredes[ yy ][ xx ] == Fase.CELULA_PORTA_V || 
                    estado == Monstrinho.MUITO_FRACO ) {
                return new int[] { 
                    Fase.CELULA_LIVRE, 
                    Fase.CELULA_CASA, 
                    Fase.CELULA_PORTA_H, 
                    Fase.CELULA_PORTA_V 
                };                                        
            }
            return new int[] { Fase.CELULA_LIVRE, Fase.CELULA_CASA };
        } else if ( personagem instanceof Pacman ) {
            return new int[] { Fase.CELULA_LIVRE, Fase.CELULA_SAIDA, Fase.CELULA_CASA };
        }       
        return new int[] { Fase.CELULA_LIVRE };
    }
        
    private boolean ehCelulaLivre( int[][] paredes, int x, int y, int[] celulaLivreValores ) {        
        for( int valor : celulaLivreValores ) {
            if ( x >= 0 && x < paredes[0].length && y >= 0 && y < paredes.length )
                if ( valor == paredes[ y ][ x ] )
                    return true;
        }
        return false;
    }
    
    public int direcaoOposta( int dir ) {
        switch( dir ) {
            case Personagem.FRENTE:  return Personagem.TRAZ;
            case Personagem.TRAZ:    return Personagem.FRENTE;
            case Personagem.CIMA:    return Personagem.BAIXO;
            case Personagem.BAIXO:   return Personagem.CIMA;
        }
        return 0;
    }             
    
}
