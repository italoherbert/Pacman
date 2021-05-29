package italo.pacman.nucleo.to;

public class Pacman extends Personagem {
    
    private int bocaFator;
    private int quantBocaFatores;

    public void inicializa( Pacman pacman ) {
        super.inicializa( pacman );
        
        quantBocaFatores = pacman.getQuantBocaFatores();
        bocaFator = pacman.getBocaFator();
    }

    @Override
    public boolean isAtravessarParedes() {    
        return true;
    }        
    
    public int getBocaFator() {
        return bocaFator;
    }

    public void setBocaFator(int bocaFator) {
        this.bocaFator = bocaFator;
    }

    public int getQuantBocaFatores() {
        return quantBocaFatores;
    }

    public void setQuantBocaFatores(int quantBocaFatores) {
        this.quantBocaFatores = quantBocaFatores;
    }
    
}
