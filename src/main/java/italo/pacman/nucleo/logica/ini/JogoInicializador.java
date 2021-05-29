package italo.pacman.nucleo.logica.ini;

import italo.pacman.nucleo.logica.util.ArrayUtil;
import italo.pacman.nucleo.config.JogoConf;
import italo.pacman.nucleo.to.Fase;
import italo.pacman.nucleo.to.Jogo;
import italo.pacman.nucleo.to.Monstrinho;
import italo.pacman.nucleo.to.Personagem;
import italo.pacman.gui.desenho.PainelDesenho;
import italo.pacman.nucleo.config.FaseConf1;
import italo.pacman.nucleo.config.atributos.FaseAtributos;
import italo.pacman.nucleo.config.atributos.JogoAtributos;
import italo.pacman.nucleo.to.Pacman;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import italo.pacman.nucleo.config.FaseConf2;
import italo.pacman.nucleo.config.FaseConf3;
import italo.pacman.nucleo.config.FaseConf4;
import italo.pacman.nucleo.config.FaseConf5;
import italo.pacman.nucleo.logica.util.TodosUtils;
import italo.pacman.nucleo.to.Truque;

public class JogoInicializador {
     
    private final int QUANT_BOCA_FATORES = 4;
    private final int FATOR_BOCA_PACMAN_INICIAL = QUANT_BOCA_FATORES-1;
    private final int MONSTRINHO_OLHO_ANGULO_INICIAL = 0;
        
    private final TodosUtils utils;

    public JogoInicializador(TodosUtils utils) {
        this.utils = utils;
    }
            
    public Jogo inicializa( PainelDesenho tela, GrupoTruqueListener gTruqueListener ) {                
        Font placarFont = JogoConf.PLACAR_FONTE;
        Font mensagemFont = JogoConf.MENSAGEM_FONTE;
        
        BufferedImage textoBufferedImage = new BufferedImage( 1, 1, BufferedImage.TYPE_INT_RGB );
        Graphics textoGraphics = textoBufferedImage.getGraphics();
        textoGraphics.setFont( placarFont ); 
        Rectangle2D placarLetraRet = textoGraphics.getFontMetrics( placarFont ).getStringBounds( "A", textoGraphics );

        int placarTextoH = (int)placarLetraRet.getHeight();        
        int borda = 10;
        
        JogoAtributos jogoAtr = new JogoAtributos();
        jogoAtr.setFaseCorrente( JogoConf.FASE_CORRENTE );
        jogoAtr.setQuantPontosParaIncVida( JogoConf.QUANT_PONTOS_PARA_INC_VIDAS ); 
        jogoAtr.setPlacarH( placarTextoH );
        jogoAtr.setBorda( borda );
        
        FaseAtributos faseAtr1 = new FaseAtributos();
        faseAtr1.setParedes( FaseConf1.PAREDES );
        faseAtr1.setIntervalosCelulasSemBolinha( FaseConf1.INTERVALO_CELULAS_SEM_BOLINHAS );
        faseAtr1.setBolinhasGrandes( FaseConf1.BOLINHAS_GRANDES );
        faseAtr1.setMonstrinhosDirecoesIniciais( FaseConf1.MONSTRINHOS_DIRECOES_INICIAIS );
        faseAtr1.setMonstrinhoPosicoes( FaseConf1.MONSTRINHOS_POSICOES );
        faseAtr1.setPacmanPosicao( FaseConf1.PACMAN_POSICAO );
        faseAtr1.setFrequenciaPacmanNormal( FaseConf1.FREQUENCIA_PACMAN_NORMAL );
        faseAtr1.setFrequenciaMonstrinhoNormal( FaseConf1.FREQUENCIA_MONSTRINHO_NORMAL );
        faseAtr1.setFrequenciaMonstrinhoFraco( FaseConf1.FREQUENCIA_MONSTRINHO_FRACO );
        faseAtr1.setFrequenciaMonstrinhoMuitoFraco( FaseConf1.FREQUENCIA_MONSTRINHO_MUITO_FRACO );
        faseAtr1.setFrequenciaEstadoFracoTempo( FaseConf1.FREQUENCIA_ESTADO_FRACO_TEMPO ); 
        faseAtr1.setFrequenciaEstadoMuitoFracoParaCasinha( FaseConf1.FREQUENCIA_ESTADO_MUITO_FRACO_TEMPO_PARA_CASINHA );
        faseAtr1.setMonstrinhoRaioBuscaPacman( FaseConf1.MONSTRINHO_RAIO_BUSCA_PACMAN ); 
        faseAtr1.setMonstrinhosCores( FaseConf1.MONSTRINHOS_CORES );        
        
        FaseAtributos faseAtr2 = new FaseAtributos();
        faseAtr2.setParedes( FaseConf2.PAREDES );
        faseAtr2.setIntervalosCelulasSemBolinha(FaseConf2.INTERVALO_CELULAS_SEM_BOLINHAS );
        faseAtr2.setBolinhasGrandes( FaseConf2.BOLINHAS_GRANDES );
        faseAtr2.setMonstrinhosDirecoesIniciais( FaseConf2.MONSTRINHOS_DIRECOES_INICIAIS );
        faseAtr2.setMonstrinhoPosicoes( FaseConf2.MONSTRINHOS_POSICOES );
        faseAtr2.setPacmanPosicao(FaseConf2.PACMAN_POSICAO );
        faseAtr2.setFrequenciaPacmanNormal( FaseConf2.FREQUENCIA_PACMAN_NORMAL );
        faseAtr2.setFrequenciaMonstrinhoNormal( FaseConf2.FREQUENCIA_MONSTRINHO_NORMAL );
        faseAtr2.setFrequenciaMonstrinhoFraco( FaseConf2.FREQUENCIA_MONSTRINHO_FRACO );
        faseAtr2.setFrequenciaMonstrinhoMuitoFraco( FaseConf2.FREQUENCIA_MONSTRINHO_MUITO_FRACO );
        faseAtr2.setFrequenciaEstadoFracoTempo( FaseConf2.FREQUENCIA_ESTADO_FRACO_TEMPO );
        faseAtr2.setMonstrinhoRaioBuscaPacman( FaseConf2.MONSTRINHO_RAIO_BUSCA_PACMAN ); 
        faseAtr2.setFrequenciaEstadoMuitoFracoParaCasinha(FaseConf2.FREQUENCIA_ESTADO_MUITO_FRACO_TEMPO_PARA_CASINHA );
        faseAtr2.setMonstrinhosCores( FaseConf2.MONSTRINHOS_CORES );
        
        FaseAtributos faseAtr3 = new FaseAtributos();
        faseAtr3.setParedes( FaseConf3.PAREDES );
        faseAtr3.setIntervalosCelulasSemBolinha( FaseConf3.INTERVALO_CELULAS_SEM_BOLINHAS );
        faseAtr3.setBolinhasGrandes( FaseConf3.BOLINHAS_GRANDES );
        faseAtr3.setMonstrinhosDirecoesIniciais( FaseConf3.MONSTRINHOS_DIRECOES_INICIAIS );
        faseAtr3.setMonstrinhoPosicoes( FaseConf3.MONSTRINHOS_POSICOES );
        faseAtr3.setPacmanPosicao( FaseConf3.PACMAN_POSICAO );
        faseAtr3.setFrequenciaPacmanNormal( FaseConf3.FREQUENCIA_PACMAN_NORMAL );
        faseAtr3.setFrequenciaMonstrinhoNormal( FaseConf3.FREQUENCIA_MONSTRINHO_NORMAL );
        faseAtr3.setFrequenciaMonstrinhoFraco( FaseConf3.FREQUENCIA_MONSTRINHO_FRACO );
        faseAtr3.setFrequenciaMonstrinhoMuitoFraco( FaseConf3.FREQUENCIA_MONSTRINHO_MUITO_FRACO ); 
        faseAtr3.setFrequenciaEstadoMuitoFracoParaCasinha( FaseConf3.FREQUENCIA_ESTADO_MUITO_FRACO_TEMPO_PARA_CASINHA );
        faseAtr3.setFrequenciaEstadoFracoTempo( FaseConf3.FREQUENCIA_ESTADO_FRACO_TEMPO );
        faseAtr3.setMonstrinhoRaioBuscaPacman( FaseConf3.MONSTRINHO_RAIO_BUSCA_PACMAN ); 
        faseAtr3.setMonstrinhosCores( FaseConf3.MONSTRINHOS_CORES );
        
        FaseAtributos faseAtr4 = new FaseAtributos();
        faseAtr4.setParedes( FaseConf4.PAREDES );
        faseAtr4.setIntervalosCelulasSemBolinha( FaseConf4.INTERVALO_CELULAS_SEM_BOLINHAS );
        faseAtr4.setBolinhasGrandes( FaseConf4.BOLINHAS_GRANDES );
        faseAtr4.setMonstrinhosDirecoesIniciais( FaseConf4.MONSTRINHOS_DIRECOES_INICIAIS );
        faseAtr4.setMonstrinhoPosicoes( FaseConf4.MONSTRINHOS_POSICOES );
        faseAtr4.setPacmanPosicao( FaseConf4.PACMAN_POSICAO );
        faseAtr4.setFrequenciaPacmanNormal( FaseConf4.FREQUENCIA_PACMAN_NORMAL );
        faseAtr4.setFrequenciaMonstrinhoNormal( FaseConf4.FREQUENCIA_MONSTRINHO_NORMAL );
        faseAtr4.setFrequenciaMonstrinhoFraco( FaseConf4.FREQUENCIA_MONSTRINHO_FRACO );
        faseAtr4.setFrequenciaMonstrinhoMuitoFraco( FaseConf4.FREQUENCIA_MONSTRINHO_MUITO_FRACO );
        faseAtr4.setFrequenciaEstadoFracoTempo( FaseConf4.FREQUENCIA_ESTADO_FRACO_TEMPO ); 
        faseAtr4.setFrequenciaEstadoMuitoFracoParaCasinha( FaseConf4.FREQUENCIA_ESTADO_MUITO_FRACO_TEMPO_PARA_CASINHA );
        faseAtr4.setMonstrinhoRaioBuscaPacman( FaseConf4.MONSTRINHO_RAIO_BUSCA_PACMAN ); 
        faseAtr4.setMonstrinhosCores( FaseConf4.MONSTRINHOS_CORES );
        
        FaseAtributos faseAtr5 = new FaseAtributos();
        faseAtr5.setParedes( FaseConf5.PAREDES );
        faseAtr5.setIntervalosCelulasSemBolinha( FaseConf5.INTERVALO_CELULAS_SEM_BOLINHAS );
        faseAtr5.setBolinhasGrandes( FaseConf5.BOLINHAS_GRANDES );
        faseAtr5.setMonstrinhosDirecoesIniciais( FaseConf5.MONSTRINHOS_DIRECOES_INICIAIS );
        faseAtr5.setMonstrinhoPosicoes( FaseConf5.MONSTRINHOS_POSICOES );
        faseAtr5.setPacmanPosicao( FaseConf5.PACMAN_POSICAO );
        faseAtr5.setFrequenciaPacmanNormal( FaseConf5.FREQUENCIA_PACMAN_NORMAL );
        faseAtr5.setFrequenciaMonstrinhoNormal( FaseConf5.FREQUENCIA_MONSTRINHO_NORMAL );
        faseAtr5.setFrequenciaMonstrinhoFraco( FaseConf5.FREQUENCIA_MONSTRINHO_FRACO );
        faseAtr5.setFrequenciaMonstrinhoMuitoFraco( FaseConf5.FREQUENCIA_MONSTRINHO_MUITO_FRACO );
        faseAtr5.setFrequenciaEstadoFracoTempo( FaseConf5.FREQUENCIA_ESTADO_FRACO_TEMPO );         
        faseAtr2.setFrequenciaEstadoMuitoFracoParaCasinha(FaseConf2.FREQUENCIA_ESTADO_MUITO_FRACO_TEMPO_PARA_CASINHA );
        faseAtr5.setMonstrinhoRaioBuscaPacman( FaseConf5.MONSTRINHO_RAIO_BUSCA_PACMAN ); 
        faseAtr5.setMonstrinhosCores( FaseConf5.MONSTRINHOS_CORES );
                 
        Fase[] fases = {              
            this.configuraFase( tela, jogoAtr, faseAtr1 ),
            this.configuraFase( tela, jogoAtr, faseAtr2 ),
            this.configuraFase( tela, jogoAtr, faseAtr3 ),
            this.configuraFase( tela, jogoAtr, faseAtr4 ),
            this.configuraFase( tela, jogoAtr, faseAtr5 )
        };
        
        Truque[] truques = {
            new Truque( JogoConf.TRUQUE_PULAR_FASE, gTruqueListener.getPularFaseTruqueListener() ),
            new Truque( JogoConf.TRUQUE_ATRAVESSAR_PAREDES, gTruqueListener.getAtravessarParedesTruqueListener() ),
            new Truque( JogoConf.TRUQUE_VIDAS9, gTruqueListener.getVidasTruqueListener() ),            
            new Truque( JogoConf.TRUQUE_VIDAS99, gTruqueListener.getVidasTruqueListener() ),            
            new Truque( JogoConf.TRUQUE_VIDAS999, gTruqueListener.getVidasTruqueListener() )           
        };
        
        Jogo jogo = new Jogo();
        jogo.setNVidas( JogoConf.N_VIDAS );
        jogo.setFaseCorrente( JogoConf.FASE_CORRENTE );
        jogo.setQuantPontosParaGanharVida( jogoAtr.getQuantPontosParaIncVida() );
        jogo.setFases( fases );
        jogo.setPontuacao( 0 );
        jogo.setFim( false );
        jogo.setPausa( false );
        jogo.setPlacarFont( placarFont );
        jogo.setMensagemFont( mensagemFont ); 
        jogo.setBorda( jogoAtr.getBorda() ); 
        jogo.setPlacarH( jogoAtr.getPlacarH() ); 
        jogo.setTruques( truques );
                
        return jogo;
    }    
    
    private Fase configuraFase( PainelDesenho tela, JogoAtributos jogoAtr, FaseAtributos faseAtr ) {
        ArrayUtil arrayUtil = utils.getArrayUtil();
        
        int w = tela.getWidth();
        int h = tela.getHeight();
        
        int borda = jogoAtr.getBorda();
        int placarH = jogoAtr.getPlacarH();
        int[][] paredes = faseAtr.getParedes();
        int[][] monstrinhosPosicoes = faseAtr.getMonstrinhoPosicoes();
        int[][] monstrinhosDirecoesIniciais = faseAtr.getMonstrinhosDirecoesIniciais();
        Color[] monstrinhosCores = faseAtr.getMonstrinhosCores();
        
        int[] pacmanPosicao = faseAtr.getPacmanPosicao();
                
        int frequenciaPacmanNormal = faseAtr.getFrequenciaPacmanNormal();
        int frequenciaMonstrinhoNormal = faseAtr.getFrequenciaMonstrinhoNormal();
        int frequenciaMonstrinhoFraco = faseAtr.getFrequenciaMonstrinhoFraco();
        int frequenciaMonstrinhoMuitoFraco = faseAtr.getFrequenciaMonstrinhoMuitoFraco();
        
        int frequenciaEstadoFracoTempo = faseAtr.getFrequenciaEstadoFracoTempo();        
        int frequenciaEstadoMuitoFracoTempoParaCasinha = faseAtr.getFrequenciaEstadoMuitoFracoParaCasinha();
        
        int monstrinhoRaioBuscaPacman = faseAtr.getMonstrinhoRaioBuscaPacman();
        
        int[][] intervalosCelulasSemBolinha = faseAtr.getIntervalosCelulasSemBolinha();
        int[][] bolinhasGrandes = faseAtr.getBolinhasGrandes();
                
        int cw = ( w - borda ) / paredes[0].length;
        int ch = ( h - placarH - (3*borda) ) / paredes.length;
        
        int tw = cw * paredes[ 0 ].length;
        int th = ch * paredes.length;        
        int tx = borda;
        int ty = 2*borda + placarH;
                                
        Monstrinho[] monstrinhos = new Monstrinho[ monstrinhosPosicoes.length ];
        for( int i = 0; i < monstrinhos.length; i++ ) {
            Monstrinho monstrinho = new Monstrinho();
            monstrinho.setEstado( Monstrinho.NORMAL );
            monstrinho.setDirecaoAtual( monstrinhosDirecoesIniciais[ i ][ 0 ] );
            monstrinho.setNovaDirecao( monstrinhosDirecoesIniciais[ i ][ 1 ] );
            monstrinho.setX( monstrinhosPosicoes[ i ][ 0 ] * cw + (cw/2) );
            monstrinho.setY( monstrinhosPosicoes[ i ][ 1 ] * ch + (ch/2) );
            monstrinho.setExecFrequencia( frequenciaMonstrinhoNormal );
            monstrinho.setFrequenciaFraco( frequenciaMonstrinhoFraco );
            monstrinho.setFrequenciaMuitoFraco( frequenciaMonstrinhoMuitoFraco );
            monstrinho.setTempoEstadoFraco( frequenciaEstadoFracoTempo ); 
            monstrinho.setTempoEstadoMuitoFracoParaCasinha( frequenciaEstadoMuitoFracoTempoParaCasinha );
            monstrinho.setCor( monstrinhosCores[ i ] );
            monstrinhos[ i ] = monstrinho;
        }
                        
        Pacman pacman = new Pacman();
        pacman.setDirecaoAtual( Personagem.FRENTE );
        pacman.setNovaDirecao( Personagem.FRENTE );
        pacman.setX( pacmanPosicao[ 0 ] * cw + (cw/2) );
        pacman.setY( pacmanPosicao[ 1 ] * ch + (ch/2) );
        pacman.setQuantBocaFatores( QUANT_BOCA_FATORES ); 
        pacman.setBocaFator( FATOR_BOCA_PACMAN_INICIAL );
        pacman.setExecFrequencia( frequenciaPacmanNormal ); 
                      
        int[][] paredes2 = arrayUtil.copiaIntMatriz( paredes );        
        int[][] bolinhas = this.geraBolinhas( paredes2, intervalosCelulasSemBolinha, bolinhasGrandes );
        
        Fase fase = new Fase();
        fase.setTabuleiroX( tx );
        fase.setTabuleiroY( ty );
        fase.setTabuleiroLargura( tw );
        fase.setTabuleiroAltura( th ); 
        fase.setCelulaLargura( cw ); 
        fase.setCelulaAltura( ch );
        fase.setPacman( pacman );
        fase.setMonstrinhos( monstrinhos );
        fase.setParedes( paredes2 );
        fase.setBolinhas( bolinhas );
        fase.setMonstrinhoRaioBuscaPacman( monstrinhoRaioBuscaPacman ); 
        
        fase.setVenceu( false );
        fase.setPerdeu( false );
        return fase;
    }          
    
    private int[][] geraBolinhas( int[][] paredes, int[][] celulasSemBolinhas, int[][] bolinhasGrandes ) {        
        int bw = paredes[0].length;
        int bh = paredes.length;
        
        int x1 = celulasSemBolinhas[0][0];
        int x2 = celulasSemBolinhas[0][1];
        int y1 = celulasSemBolinhas[1][0];
        int y2 = celulasSemBolinhas[1][1];
        
        int[][] bolinhas = new int[ bh ][ bw ];
        for( int i = 0; i < bh; i++ )
            for( int j = 0; j < bw; j++ )
                bolinhas[i][j] = Fase.SEM_BOLINHA;
                                
        for( int i = 0; i < bh; i++ ) {
            for( int j = 0; j < bw; j++ ) {
                if ( i > y1 && i < y2 && j > x1 && j < x2 )
                    continue;
                                                    
                bolinhas[i][j] = ( paredes[ i ][ j ] == 0 ? Fase.BOLINHA : Fase.SEM_BOLINHA );               
            }
        }
        
        for( int i = 0; i < bolinhasGrandes.length; i++ ) {
            for( int j = 0; j < bolinhasGrandes[ i ].length; j++ ) {
                int x = bolinhasGrandes[ i ][ 0 ];
                int y = bolinhasGrandes[ i ][ 1 ];
                bolinhas[ y ][ x ] = Fase.BOLINHA_GRANDE;
            }
        }
        
        /*
        int xdiv = bgFatorX;
        int ydiv = bgFatorY;
                        
        if ( paredes[1][xdiv] == Fase.CELULA_VASIA )
            bolinhas[1][xdiv] = Fase.BOLINHA_GRANDE;
        if ( paredes[1][paredes[0].length - 1 - xdiv] == Fase.CELULA_VASIA )
            bolinhas[1][paredes[0].length - 1 - xdiv] = Fase.BOLINHA_GRANDE;
        if ( paredes[paredes.length-2][xdiv] == Fase.CELULA_VASIA )
            bolinhas[paredes.length-2][xdiv] = Fase.BOLINHA_GRANDE;
        if ( paredes[paredes.length-2][paredes[0].length - 1 - xdiv] == Fase.CELULA_VASIA )
            bolinhas[paredes.length-2][paredes[0].length - 1 - xdiv] = Fase.BOLINHA_GRANDE;
        if ( paredes[ydiv][1] == Fase.CELULA_VASIA )
            bolinhas[ydiv][1] = Fase.BOLINHA_GRANDE;
        if ( paredes[paredes.length - 1 - ydiv][1] == Fase.CELULA_VASIA )
            bolinhas[paredes.length - 1 - ydiv][1] = Fase.BOLINHA_GRANDE;
        if ( paredes[ydiv][paredes[0].length-2] == Fase.CELULA_VASIA )
            bolinhas[ydiv][paredes[0].length-2] = Fase.BOLINHA_GRANDE;
        if ( paredes[paredes.length - 1 - ydiv][paredes[0].length-2] == Fase.CELULA_VASIA )
            bolinhas[paredes.length - 1 - ydiv][paredes[0].length-2] = Fase.BOLINHA_GRANDE;        
        */
        return bolinhas;
    }
    
    public Color randomCor() {
        int r = (int)Math.round( 255 * Math.random() );
        int g = (int)Math.round( 255 * Math.random() );
        int b = (int)Math.round( 255 * Math.random() );
        return new Color( r, g, b );
    }
        
}
