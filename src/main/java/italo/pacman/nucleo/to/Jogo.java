package italo.pacman.nucleo.to;

import java.awt.Font;

public class Jogo {
    
    public final static int NENHUMA_FASE = -1;
    
    private Fase[] fases;
    private Truque[] truques;
    
    private int nvidas;
    private int pontuacao;
    private int quantPontosParaGanharVida;
    private int ultimaPontuacaoIncVida;
    private int faseCorrente;
        
    private boolean atravessarParedes;
    private boolean setarComoNaoAtravessarParedes;
    
    private int borda;
    private int placarH;
        
    private Font placarFont = new Font( Font.SANS_SERIF, Font.PLAIN, 18 );
    private Font mensagemFont = new Font( Font.SANS_SERIF, Font.PLAIN, 24 );
    
    private boolean pausa = false;
    private boolean fim = false;
        
    public void inicializa( Jogo jogo ) {
        Fase[] fases2 = jogo.getFases();
        if ( fases == null ) {
            fases = new Fase[ fases2.length ];
            for( int i = 0; i < fases.length; i++ )
                fases[ i ] = new Fase();
        }
        
        for( int i = 0; i < fases.length; i++ )
            fases[ i ].inicializa( fases2[ i ] ); 
        
        nvidas = jogo.getNVidas();
        pontuacao = jogo.getPontuacao();
        quantPontosParaGanharVida = jogo.getQuantPontosParaGanharVida();
        
        faseCorrente = jogo.getFaseCorrente();
        
        pausa = jogo.isPausa();
        fim = jogo.isFim();
        
        borda = jogo.getBorda();
        placarH = jogo.getPlacarH();
        
        truques = jogo.getTruques();
        
        atravessarParedes = false;
        setarComoNaoAtravessarParedes = false;
        ultimaPontuacaoIncVida = 0;
    }
    
    public Fase[] getFases() {
        return fases;
    }

    public void setFases(Fase[] fases) {
        this.fases = fases;
    }

    public int getNVidas() {
        return nvidas;
    }

    public void setNVidas(int nvidas) {
        this.nvidas = nvidas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getFaseCorrente() {
        return faseCorrente;
    }

    public void setFaseCorrente(int faseCorrente) {
        this.faseCorrente = faseCorrente;
    }

    public boolean isPausa() {
        return pausa;
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }

    public boolean isFim() {
        return fim;
    }

    public void setFim(boolean fim) {
        this.fim = fim;
    }

    public int getBorda() {
        return borda;
    }

    public void setBorda(int borda) {
        this.borda = borda;
    }

    public int getPlacarH() {
        return placarH;
    }

    public void setPlacarH(int placarH) {
        this.placarH = placarH;
    }

    public Truque[] getTruques() {
        return truques;
    }

    public void setTruques(Truque[] truques) {
        this.truques = truques;
    }

    public Font getPlacarFont() {
        return placarFont;
    }

    public void setPlacarFont(Font placarFont) {
        this.placarFont = placarFont;
    }

    public Font getMensagemFont() {
        return mensagemFont;
    }

    public void setMensagemFont(Font mensagemFont) {
        this.mensagemFont = mensagemFont;
    }

    public boolean isAtravessarParedes() {
        return atravessarParedes;
    }

    public void setAtravessarParedes(boolean atravessarParedes) {
        this.atravessarParedes = atravessarParedes;
    }

    public boolean isSetarComoNaoAtravessarParedes() {
        return setarComoNaoAtravessarParedes;
    }

    public void setSetarComoNaoAtravessarParedes(boolean setarComoNaoAtravessarParedes) {
        this.setarComoNaoAtravessarParedes = setarComoNaoAtravessarParedes;
    }

    public int getQuantPontosParaGanharVida() {
        return quantPontosParaGanharVida;
    }

    public void setQuantPontosParaGanharVida(int quantPontosParaGanharVida) {
        this.quantPontosParaGanharVida = quantPontosParaGanharVida;
    }

    public int getUltimaPontuacaoIncVida() {
        return ultimaPontuacaoIncVida;
    }

    public void setUltimaPontuacaoIncVida(int ultimaPontuacaoIncVida) {
        this.ultimaPontuacaoIncVida = ultimaPontuacaoIncVida;
    }
    
}
