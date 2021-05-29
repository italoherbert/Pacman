package italo.pacman.nucleo.config.atributos;

import java.awt.Font;

public class JogoAtributos {
    
    private int nVidas;
    private int faseCorrente;  
    
    private int quantPontosParaIncVida;

    private int placarH;
    private int borda;
    private Font placarFonte;
    private Font mensagemFont;
    
    public int getNVidas() {
        return nVidas;
    }

    public void setNVidas(int nVidas) {
        this.nVidas = nVidas;
    }

    public int getFaseCorrente() {
        return faseCorrente;
    }

    public void setFaseCorrente(int faseCorrente) {
        this.faseCorrente = faseCorrente;
    }

    public int getQuantPontosParaIncVida() {
        return quantPontosParaIncVida;
    }

    public void setQuantPontosParaIncVida(int quantPontosParaIncVida) {
        this.quantPontosParaIncVida = quantPontosParaIncVida;
    }

    public int getPlacarH() {
        return placarH;
    }

    public void setPlacarH(int placarH) {
        this.placarH = placarH;
    }

    public int getBorda() {
        return borda;
    }

    public void setBorda(int borda) {
        this.borda = borda;
    }

    public Font getPlacarFonte() {
        return placarFonte;
    }

    public void setPlacarFonte(Font placarFonte) {
        this.placarFonte = placarFonte;
    }

    public Font getMensagemFont() {
        return mensagemFont;
    }

    public void setMensagemFont(Font mensagemFont) {
        this.mensagemFont = mensagemFont;
    }

    
    
}
