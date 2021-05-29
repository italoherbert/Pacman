package italo.pacman.desenho;

import java.awt.Color;
import java.awt.Graphics;

public class MonstrinhoOlhoDesenho {
    
    public void desenha( Graphics g, double olhinhoAngulo, int olhoX, int olhoY, int olhoD, Color bordaCor, Color cor ) {                                       
        g.setColor( cor ); 
        g.fillArc( olhoX, olhoY, olhoD, olhoD, 0, 360 );
        
        g.setColor( bordaCor ); 
        g.drawArc( olhoX, olhoY, olhoD, olhoD, 0, 360 );
        
        int olho1CentroX = olhoX + olhoD/2;
        int olho1CentroY = olhoY + olhoD/2;
                
        int olhinhoR = 2;
        int olhinho1X = olho1CentroX + (int)Math.round( ((olhoD/2)-(olhinhoR/2)) * Math.cos( olhinhoAngulo ) );
        int olhinho1Y = olho1CentroY - (int)Math.round( ((olhoD/2)-(olhinhoR/2)) * Math.sin( olhinhoAngulo ) );

        g.setColor( Color.BLACK );
        g.fillArc( olhinho1X - (olhinhoR/2), olhinho1Y - (olhinhoR/2), 2*olhinhoR, 2*olhinhoR, 0, 360 );        
    }

}
