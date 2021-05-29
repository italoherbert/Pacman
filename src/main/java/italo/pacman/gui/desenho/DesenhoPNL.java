package italo.pacman.gui.desenho;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class DesenhoPNL extends JPanel implements PainelDesenho {
    
    private Desenho desenho = null;
    private BufferedImage imagem = null;
    private Graphics imagemGraphics = null;
                
    public DesenhoPNL() {
        super.setBackground( Color.BLACK ); 
    }
    
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        
        if ( imagem == null ) {
            imagem = new BufferedImage( super.getWidth(), super.getHeight(), BufferedImage.TYPE_INT_RGB );
            imagemGraphics = imagem.getGraphics();

            ((Graphics2D)imagemGraphics).setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );                         
        }
                
        if ( desenho != null ) {
            imagemGraphics.setColor( Color.BLACK ); 
            imagemGraphics.fillRect( 0, 0, imagem.getWidth()-1, imagem.getHeight()-1 );
            
            desenho.desenha( imagemGraphics, this );                  
            g.drawImage( imagem, 0, 0, this );
        }
    }
        
    @Override
    public void setDesenho( Desenho desenho ) {
        this.desenho = desenho;
    }
        
}
