package italo.pacman.gui.desenho;

public interface PainelDesenho {
    
    public int getWidth();
    
    public int getHeight();
                
    public void repaint();
    
    public void setDesenho( Desenho desenho );
    
}
