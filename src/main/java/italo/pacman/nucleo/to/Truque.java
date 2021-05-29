package italo.pacman.nucleo.to;

public class Truque {
    
    private final char[] truqueDigitado;
    private String truqueTexto;    
    
    private int cont;
    private boolean processarTruque;
    private TruqueListener listener;    
    
    public Truque( String truqueTexto, TruqueListener listener ) {
        this.truqueTexto = truqueTexto;
        this.listener = listener;
        
        this.truqueDigitado = new char[ truqueTexto.length() ];
        
        this.cont = 0;
        this.processarTruque = false;
    }    
    
    public char[] getTruqueDigitado() {
        return truqueDigitado;
    }
        
    public String getTruqueTexto() {
        return truqueTexto;
    }

    public void setTruqueTexto(String truqueTexto) {
        this.truqueTexto = truqueTexto;
    }
    
    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public boolean isProcessarTruque() {
        return processarTruque;
    }

    public void setProcessarTruque(boolean processarTruque) {
        this.processarTruque = processarTruque;
    }

    public TruqueListener getTruqueListener() {
        return listener;
    }

    public void setTruqueListener(TruqueListener listener) {
        this.listener = listener;
    }
    
}
