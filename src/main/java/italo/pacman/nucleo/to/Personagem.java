package italo.pacman.nucleo.to;

public abstract class Personagem {
    
    public final static int CIMA = 1;
    public final static int BAIXO = 2;
    public final static int TRAZ = 3;
    public final static int FRENTE = 4;        
    
    private int direcaoAtual = FRENTE;
    private int novaDirecao = FRENTE;
    private int x;
    private int y;
    private int execFrequencia;
    
    public abstract boolean isAtravessarParedes();
    
    public void inicializa( Personagem personagem ) {
        direcaoAtual = personagem.getDirecaoAtual();
        novaDirecao = personagem.getNovaDirecao();
        x = personagem.getX();
        y = personagem.getY();
        execFrequencia = personagem.getExecFrequencia();
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirecaoAtual() {
        return direcaoAtual;
    }

    public void setDirecaoAtual(int direcaoAtual) {
        this.direcaoAtual = direcaoAtual;
    }

    public int getNovaDirecao() {
        return novaDirecao;
    }

    public void setNovaDirecao(int novaDirecao) {
        this.novaDirecao = novaDirecao;
    }

    public int getExecFrequencia() {
        return execFrequencia;
    }

    public void setExecFrequencia(int execFrequencia) {
        this.execFrequencia = execFrequencia;
    }
    
}
