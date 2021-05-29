package italo.pacman.gui.principal;

import italo.pacman.gui.desenho.DesenhoPNL;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class JanelaGUI extends JFrame implements WindowListener, KeyListener {
    
    private final DesenhoPNL desenhoPNL = new DesenhoPNL();
    private JanelaGUIListener listener = null;
    
    public JanelaGUI() {
        super.setTitle( "Jogo de PacMan" );
        super.setContentPane( desenhoPNL );
        super.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        super.setSize( 600, 550 );
        super.setLocationRelativeTo( this ); 
        
        super.addWindowListener( this );
        super.addKeyListener( this );
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if ( listener == null )
            return;
            
        switch( e.getKeyCode() ) {
            case KeyEvent.VK_LEFT:
                listener.teclaFuncPressionada( JanelaGUIListener.TRAZ );
                break;
            case KeyEvent.VK_DOWN:
                listener.teclaFuncPressionada( JanelaGUIListener.BAIXO );
                break;
            case KeyEvent.VK_RIGHT:
                listener.teclaFuncPressionada( JanelaGUIListener.FRENTE );
                break;
            case KeyEvent.VK_UP:
                listener.teclaFuncPressionada( JanelaGUIListener.CIMA );
                break;
            case KeyEvent.VK_ENTER:
                listener.teclaFuncPressionada( JanelaGUIListener.ENTER );
                break;
            case KeyEvent.VK_ESCAPE:
                listener.teclaFuncPressionada( JanelaGUIListener.ESC );
                break;
        }
    }
        
    @Override
    public void keyReleased(KeyEvent e) {
        if ( listener == null )
            return;
    
        listener.teclaCharPressionada( e.getKeyChar() );
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        if ( listener != null )
            listener.fechandoJanela();
    }

    @Override
    public void windowOpened(WindowEvent e) {}    

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
        
    public void setJanelaGUIListener( JanelaGUIListener listener ) {
        this.listener = listener;
    }

    public DesenhoPNL getDesenhoPNL() {
        return desenhoPNL;
    }
    
}
