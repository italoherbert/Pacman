package italo.pacman.nucleo.config;

import italo.pacman.nucleo.to.Personagem;
import java.awt.Color;

public interface FaseConf3{
    
    public final static int[][] PAREDES = {
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },  
        { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },  
        { 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1 },  
        { 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1 },  
        { 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1 },  
        { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 },  
        { 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },  
        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },  
        { 1, 0, 1, 0, 1, 1, 1, 1, 3, 1, 1, 1, 1, 0, 1, 0, 1 },  
        { 5, 0, 1, 0, 0, 1, 2, 2, 2, 2, 2, 1, 0, 0, 1, 0, 5 },  
        { 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1 },  
        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },  
        { 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },  
        { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 },  
        { 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1 },  
        { 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1 },  
        { 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1 },  
        { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },  
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },           
    };
    
    public final static int[][] INTERVALO_CELULAS_SEM_BOLINHAS = {
        { 4, 12 },
        { 6, 12 }
    };
        
    public final static int[][] BOLINHAS_GRANDES = {
        { 1, 6 }, { 6, 1 }, { 10, 17 }, { 15, 12 }
    };
    
    public final static int[][] MONSTRINHOS_POSICOES = {
        { 6, 9 }, { 7, 9 }, { 9, 9 }, { 10, 9 }
    };
    
    public final static int[][] MONSTRINHOS_DIRECOES_INICIAIS = {
        { Personagem.FRENTE, Personagem.CIMA },
        { Personagem.FRENTE, Personagem.CIMA },
        { Personagem.TRAZ, Personagem.CIMA },
        { Personagem.TRAZ, Personagem.CIMA },        
    };
    
    public final static Color[] MONSTRINHOS_CORES = {
        Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN
    };
                
    public final static int[] PACMAN_POSICAO = {
        9, 11
    };
        
    public final static int FREQUENCIA_ESTADO_FRACO_TEMPO = 4000;
    public final static int FREQUENCIA_ESTADO_MUITO_FRACO_TEMPO_PARA_CASINHA = 2500;
    public final static int FREQUENCIA_PACMAN_NORMAL = 6;
    public final static int FREQUENCIA_MONSTRINHO_NORMAL = 6;
    public final static int FREQUENCIA_MONSTRINHO_FRACO = 8;
    public final static int FREQUENCIA_MONSTRINHO_MUITO_FRACO = 3;
    
    public final static int MONSTRINHO_RAIO_BUSCA_PACMAN = 200;
        
}
