package italo.pacman.nucleo.to;

import java.awt.Color;

public class Monstrinho extends Personagem {
    
    public final static int NORMAL = 1;
    public final static int FRACO = 2;
    public final static int MUITO_FRACO = 3;
    public final static int MELHORANDO = 4;
            
    private int estado;
    private Color cor;
    
    private double olhoAngulo;
    
    private int frequenciaFraco;
    private int frequenciaMuitoFraco;
        
    private int tempoEstadoFraco;
    private int tempoEstadoMuitoFracoParaCasinha;

    private int controleFrequenciaFraco;    
    private int controleFrequenciaMuitoFraco;
    
    private boolean configNovaDirDistanteFlag;

    public void inicializa( Monstrinho monstrinho ) {
        super.inicializa( monstrinho );
     
        estado = monstrinho.getEstado();
        cor = monstrinho.getCor();
        
        tempoEstadoFraco = monstrinho.getTempoEstadoFraco();
        tempoEstadoMuitoFracoParaCasinha = monstrinho.getTempoEstadoMuitoFracoParaCasinha();
        
        frequenciaFraco = monstrinho.getFrequenciaFraco();
        frequenciaMuitoFraco = monstrinho.getFrequenciaMuitoFraco();
        
        configNovaDirDistanteFlag = true;
        
        controleFrequenciaFraco = 0;
        controleFrequenciaMuitoFraco = 0;

        olhoAngulo = 0;
    }
    
    @Override
    public boolean isAtravessarParedes() {
        return false;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }    

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public double getOlhoAngulo() {
        return olhoAngulo;
    }

    public void setOlhoAngulo(double olhoAngulo) {
        this.olhoAngulo = olhoAngulo;
    }

    public int getControleFrequenciaFraco() {
        return controleFrequenciaFraco;
    }

    public void setControleFrequenciaFraco(int controleFrequenciaFraco) {
        this.controleFrequenciaFraco = controleFrequenciaFraco;
    }

    public int getFrequenciaFraco() {
        return frequenciaFraco;
    }

    public void setFrequenciaFraco(int frequenciaFraco) {
        this.frequenciaFraco = frequenciaFraco;
    }

    public int getFrequenciaMuitoFraco() {
        return frequenciaMuitoFraco;
    }

    public void setFrequenciaMuitoFraco(int frequenciaMuitoFraco) {
        this.frequenciaMuitoFraco = frequenciaMuitoFraco;
    }

    public int getTempoEstadoFraco() {
        return tempoEstadoFraco;
    }

    public void setTempoEstadoFraco(int tempoEstadoFraco) {
        this.tempoEstadoFraco = tempoEstadoFraco;
    }

    public int getTempoEstadoMuitoFracoParaCasinha() {
        return tempoEstadoMuitoFracoParaCasinha;
    }

    public void setTempoEstadoMuitoFracoParaCasinha(int tempoEstadoMuitoFracoTempoParaCasinha) {
        this.tempoEstadoMuitoFracoParaCasinha = tempoEstadoMuitoFracoTempoParaCasinha;
    }

    public int getControleFrequenciaMuitoFraco() {
        return controleFrequenciaMuitoFraco;
    }

    public void setControleFrequenciaMuitoFraco(int controleFrequenciaMuitoFraco) {
        this.controleFrequenciaMuitoFraco = controleFrequenciaMuitoFraco;
    }

    public boolean isConfigNovaDirDistanteFlag() {
        return configNovaDirDistanteFlag;
    }

    public void setConfigNovaDirDistanteFlag(boolean configNovaDirDistanteFlag) {
        this.configNovaDirDistanteFlag = configNovaDirDistanteFlag;
    }
    
}
