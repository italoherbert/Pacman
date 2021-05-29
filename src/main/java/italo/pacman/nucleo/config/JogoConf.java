package italo.pacman.nucleo.config;

import java.awt.Font;

public interface JogoConf {
    
    public final static int N_VIDAS = 8;
    public final static int FASE_CORRENTE = 0;

    public final static int QUANT_PONTOS_PARA_INC_VIDAS = 1000;
      
    public final static Font PLACAR_FONTE = new Font( Font.SANS_SERIF, Font.PLAIN, 18 );
    public final static Font MENSAGEM_FONTE = new Font( Font.SANS_SERIF, Font.BOLD, 24 );
    
    public final static String TRUQUE_PULAR_FASE = "FASE?";
    public final static String TRUQUE_ATRAVESSAR_PAREDES = "AP";
    public final static String TRUQUE_VIDAS9 = "?VIDAS";    
    public final static String TRUQUE_VIDAS99 = "??VIDAS";    
    public final static String TRUQUE_VIDAS999 = "???VIDAS";
    
}
