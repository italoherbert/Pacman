package italo.pacman.nucleo.to;

public class Fase {
    
    public final static int CELULA_LIVRE = 0;
    public final static int CELULA_PAREDE = 1;
    public final static int CELULA_CASA = 2;
    public final static int CELULA_PORTA_H = 3;
    public final static int CELULA_PORTA_V = 4;
    public final static int CELULA_SAIDA = 5;
    
    public final static int SEM_BOLINHA = 0;
    public final static int BOLINHA = 1;
    public final static int BOLINHA_GRANDE = 2;
    
    private int[][] paredes;
    private int[][] bolinhas;
    private int[][] tabuleiroAEstrela;
    
    private Monstrinho[] monstrinhos;
    private Pacman pacman;
    
    private int tabuleiroX;
    private int tabuleiroY;
    private int tabuleiroLargura;
    private int tabuleiroAltura;
    private int celulaLargura;
    private int celulaAltura;
    
    private int casinhaPortaX;
    private int casinhaPortaY;
    
    private int monstrinhoRaioBuscaPacman;
    
    private boolean venceu;
    private boolean perdeu;    
    
    private Fase faseInicializador = null;

    public void inicializa( Fase fase ) {
        this.faseInicializador = fase;
        
        int[][] paredes2 = fase.getParedes();
        int[][] bolinhas2 = fase.getBolinhas();
        Monstrinho[] monstrinhos2 = fase.getMonstrinhos();
        Pacman pacman2 = fase.getPacman();
        
        if ( paredes == null )
            paredes = new int[ paredes2.length ][ paredes2[ 0 ].length ];
        if ( bolinhas == null )
            bolinhas = new int[ bolinhas2.length ][ bolinhas2[ 0 ].length ];
        if ( tabuleiroAEstrela == null )
            tabuleiroAEstrela = new int[ paredes2.length ][ paredes2[ 0 ].length ];                     
        if ( monstrinhos == null ) {
            monstrinhos = new Monstrinho[ monstrinhos2.length ];
            for( int i = 0; i < monstrinhos.length; i++ )
                monstrinhos[ i ] = new Monstrinho();                            
        }
        if ( pacman == null )
            pacman = new Pacman();        
        
        for( int i = 0; i < paredes.length; i++ )
            for( int j = 0; j < paredes[ i ].length; j++ )
                paredes[ i ][ j ] = paredes2[ i ][ j ];
        
        for( int i = 0; i < bolinhas.length; i++ )
            for( int j = 0; j < bolinhas[ i ].length; j++ )
                bolinhas[ i ][ j ] = bolinhas2[ i ][ j ];
                
        for( int i = 0; i < monstrinhos.length; i++ )
            monstrinhos[ i ].inicializa( monstrinhos2[ i ] );        
        
        pacman.inicializa( pacman2 );
        
        tabuleiroX = fase.getTabuleiroX();
        tabuleiroY = fase.getTabuleiroY();
        tabuleiroLargura = fase.getTabuleiroLargura();
        tabuleiroAltura = fase.getTabuleiroAltura();
        celulaLargura = fase.getCelulaLargura();
        celulaAltura = fase.getCelulaAltura();
        
        monstrinhoRaioBuscaPacman = fase.getMonstrinhoRaioBuscaPacman();
        
        perdeu = fase.isPerdeu();
        venceu = fase.isVenceu();
        
        casinhaPortaX = -1;
        casinhaPortaY = -1;
        int paredePorta = -1;
        
        int casinhaX = -1;
        int casinhaY = -1;
        
        boolean achou1 = false;
        boolean achou2 = false;
        for( int i = 0; ( !achou1 || !achou2 ) && i < paredes.length; i++ ) {
            for( int j = 0; ( !achou1 || !achou2 ) && j < paredes[i].length; j++ ) {
                if ( paredes[ i ][ j ] == CELULA_PORTA_H || paredes[ i ][ j ] == CELULA_PORTA_V ) {
                    casinhaPortaX = (j * celulaLargura) + (celulaLargura/2);
                    casinhaPortaY = (i * celulaAltura ) + (celulaAltura /2);
                    
                    paredePorta = paredes[ i ][ j ];
                    achou1 = true;
                } else if ( paredes[ i ][ j ] == CELULA_CASA ) {
                    casinhaX = (j * celulaLargura) + (celulaLargura/2);
                    casinhaY = (i * celulaAltura ) + (celulaAltura /2);
                    
                    achou2 = true;
                }
            }
        }
        
        if ( paredePorta == CELULA_PORTA_H ) {
            if ( casinhaPortaY < casinhaY ) {
                casinhaPortaY += celulaAltura;
            } else {
                casinhaPortaY -= celulaAltura;
            }
        } else if ( paredePorta == CELULA_PORTA_V ) {
            if ( casinhaPortaX < casinhaX ) {
                casinhaPortaX += celulaLargura;
            } else {
                casinhaPortaX -= celulaLargura;
            }
        }
        
    }
    
    public void reinicia() {
        if ( faseInicializador != null ) {
            Monstrinho[] monstrinhos2 = faseInicializador.getMonstrinhos();
            Pacman pacman2 = faseInicializador.getPacman();
            for( int i = 0; i < monstrinhos.length; i++ )
                monstrinhos[ i ].inicializa( monstrinhos2[ i ] );        

            pacman.inicializa( pacman2 );
            
            perdeu = faseInicializador.isPerdeu();
            venceu = faseInicializador.isVenceu();
        }        
    }

    public int getCasinhaPortaX() {
        return casinhaPortaX;
    }

    public int getCasinhaPortaY() {
        return casinhaPortaY;
    }
    
    public int getTabuleiroX() {
        return tabuleiroX;
    }

    public void setTabuleiroX(int tabuleiroX) {
        this.tabuleiroX = tabuleiroX;
    }

    public int getTabuleiroY() {
        return tabuleiroY;
    }

    public void setTabuleiroY(int tabuleiroY) {
        this.tabuleiroY = tabuleiroY;
    }

    public int getTabuleiroLargura() {
        return tabuleiroLargura;
    }

    public void setTabuleiroLargura(int tabuleiroLargura) {
        this.tabuleiroLargura = tabuleiroLargura;
    }

    public int getTabuleiroAltura() {
        return tabuleiroAltura;
    }

    public void setTabuleiroAltura(int tabuleiroAltura) {
        this.tabuleiroAltura = tabuleiroAltura;
    }

    public int getCelulaLargura() {
        return celulaLargura;
    }

    public void setCelulaLargura(int celulaLargura) {
        this.celulaLargura = celulaLargura;
    }

    public int getCelulaAltura() {
        return celulaAltura;
    }

    public void setCelulaAltura(int celulaAltura) {
        this.celulaAltura = celulaAltura;
    }
        
    public int[][] getParedes() {
        return paredes;
    }

    public void setParedes(int[][] paredes) {
        this.paredes = paredes;
    }

    public int[][] getBolinhas() {
        return bolinhas;
    }

    public void setBolinhas(int[][] bolinhas) {
        this.bolinhas = bolinhas;
    }

    public Monstrinho[] getMonstrinhos() {
        return monstrinhos;
    }

    public void setMonstrinhos(Monstrinho[] monstrinhos) {
        this.monstrinhos = monstrinhos;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public boolean isVenceu() {
        return venceu;
    }

    public void setVenceu(boolean venceu) {
        this.venceu = venceu;
    }

    public boolean isPerdeu() {
        return perdeu;
    }

    public void setPerdeu(boolean perdeu) {
        this.perdeu = perdeu;
    }

    public int[][] getTabuleiroAEstrela() {
        return tabuleiroAEstrela;
    }

    public void setTabuleiroAEstrela(int[][] tabuleiroAEstrela) {
        this.tabuleiroAEstrela = tabuleiroAEstrela;
    }

    public int getMonstrinhoRaioBuscaPacman() {
        return monstrinhoRaioBuscaPacman;
    }

    public void setMonstrinhoRaioBuscaPacman(int monstrinhoRaioBuscaPacman) {
        this.monstrinhoRaioBuscaPacman = monstrinhoRaioBuscaPacman;
    }
        
}
