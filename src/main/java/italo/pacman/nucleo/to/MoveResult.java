package italo.pacman.nucleo.to;

public class MoveResult {
    
    private boolean moveu;
    private boolean ehPortaPosic;

    public MoveResult( boolean moveu, boolean ehPortaPosic ) {
        this.moveu = moveu;
        this.ehPortaPosic = ehPortaPosic;
    }

    public boolean isMoveu() {
        return moveu;
    }

    public void setMoveu(boolean moveu) {
        this.moveu = moveu;
    }

    public boolean isEhPortaPosic() {
        return ehPortaPosic;
    }

    public void setEhPortaPosic(boolean ehPortaPosic) {
        this.ehPortaPosic = ehPortaPosic;
    }
    
}
