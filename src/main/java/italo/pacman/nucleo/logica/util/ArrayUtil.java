package italo.pacman.nucleo.logica.util;

public class ArrayUtil {
    
    public int[][] copiaIntMatriz( int[][] vetor ) {
        int[][] vet = new int[ vetor.length ][];
        for( int i = 0; i < vetor.length; i++ )
            vet[ i ] = this.copiaIntVetor( vetor[ i ] );              
        return vet;
    }
    
    public boolean[][] copiaBoolMatriz( boolean[][] vetor ) {
        boolean[][] vet = new boolean[ vetor.length ][];
        for( int i = 0; i < vetor.length; i++ )
            vet[ i ] = this.copiaBoolVetor( vetor[ i ] );        
        return vet;
    }
    
    public int[] copiaIntVetor( int[] vetor ) {
        int[] vet = new int[ vetor.length ];
        for( int j = 0; j < vetor.length; j++ )
            vet[ j ] = vetor[ j ];
        return vet;
    }
    
    public boolean[] copiaBoolVetor( boolean[] vetor ) {
        boolean[] vet = new boolean[ vetor.length ];
        for( int j = 0; j < vetor.length; j++ )
            vet[ j ] = vetor[ j ];
        return vet;
    }
    
}
