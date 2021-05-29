package italo.pacman.nucleo.logica;

public interface TodosManagers {
    
    public JogoManager getJogoManager();

    public TruqueManager getTruqueManager();

    public MoveManager getMoveManager();

    public FaseManager getFaseManager();

    public PacmanManager getPacmanManager();

    public MonstrinhoManager getMonstrinhoManager();

    public AEstrelaManager getAEstrelaManager();
    
}
