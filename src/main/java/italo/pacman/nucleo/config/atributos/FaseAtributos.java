package italo.pacman.nucleo.config.atributos;

import java.awt.Color;

public class FaseAtributos {
    
    private int[][] paredes;
    
    private int[][] intervalosCelulasSemBolinha;    
    private int[][] bolinhasGrandes;
    
    private int[][] monstrinhosDirecoesIniciais;
    private Color[] monstrinhosCores;
    
    private int[][] monstrinhoPosicoes;                    
    private int[] pacmanPosicao;

    private int frequenciaPacmanNormal;
    private int frequenciaMonstrinhoNormal;
    private int frequenciaMonstrinhoFraco;
    private int frequenciaMonstrinhoMuitoFraco;
    private int frequenciaEstadoFracoTempo;
    private int frequenciaEstadoMuitoFracoParaCasinha;
    
    private int monstrinhoRaioBuscaPacman;
        
    public int[][] getParedes() {
        return paredes;
    }

    public void setParedes(int[][] paredes) {
        this.paredes = paredes;
    }

    public int[][] getIntervalosCelulasSemBolinha() {
        return intervalosCelulasSemBolinha;
    }

    public void setIntervalosCelulasSemBolinha(int[][] intervalosCelulasSemBolinha) {
        this.intervalosCelulasSemBolinha = intervalosCelulasSemBolinha;
    }

    public int[][] getBolinhasGrandes() {
        return bolinhasGrandes;
    }

    public void setBolinhasGrandes(int[][] bolinhasGrandes) {
        this.bolinhasGrandes = bolinhasGrandes;
    }
    
    public int[][] getMonstrinhosDirecoesIniciais() {
        return monstrinhosDirecoesIniciais;
    }

    public void setMonstrinhosDirecoesIniciais(int[][] monstrinhosDirecoesIniciais) {
        this.monstrinhosDirecoesIniciais = monstrinhosDirecoesIniciais;
    }

    public Color[] getMonstrinhosCores() {
        return monstrinhosCores;
    }

    public void setMonstrinhosCores(Color[] monstrinhosCores) {
        this.monstrinhosCores = monstrinhosCores;
    }

    public int[][] getMonstrinhoPosicoes() {
        return monstrinhoPosicoes;
    }

    public void setMonstrinhoPosicoes(int[][] monstrinhoPosicoes) {
        this.monstrinhoPosicoes = monstrinhoPosicoes;
    }

    public int[] getPacmanPosicao() {
        return pacmanPosicao;
    }

    public void setPacmanPosicao(int[] pacmanPosicao) {
        this.pacmanPosicao = pacmanPosicao;
    }

    public int getFrequenciaPacmanNormal() {
        return frequenciaPacmanNormal;
    }

    public void setFrequenciaPacmanNormal(int frequenciaPacmanNormal) {
        this.frequenciaPacmanNormal = frequenciaPacmanNormal;
    }

    public int getFrequenciaMonstrinhoNormal() {
        return frequenciaMonstrinhoNormal;
    }

    public void setFrequenciaMonstrinhoNormal(int frequenciaMonstrinhoNormal) {
        this.frequenciaMonstrinhoNormal = frequenciaMonstrinhoNormal;
    }

    public int getFrequenciaMonstrinhoFraco() {
        return frequenciaMonstrinhoFraco;
    }

    public void setFrequenciaMonstrinhoFraco(int frequenciaMonstrinhoFraco) {
        this.frequenciaMonstrinhoFraco = frequenciaMonstrinhoFraco;
    }

    public int getFrequenciaMonstrinhoMuitoFraco() {
        return frequenciaMonstrinhoMuitoFraco;
    }

    public void setFrequenciaMonstrinhoMuitoFraco(int frequenciaMonstrinhoMuitoFraco) {
        this.frequenciaMonstrinhoMuitoFraco = frequenciaMonstrinhoMuitoFraco;
    }

    public int getFrequenciaEstadoFracoTempo() {
        return frequenciaEstadoFracoTempo;
    }

    public void setFrequenciaEstadoFracoTempo(int frequenciaEstadoFracoTempo) {
        this.frequenciaEstadoFracoTempo = frequenciaEstadoFracoTempo;
    }

    public int getMonstrinhoRaioBuscaPacman() {
        return monstrinhoRaioBuscaPacman;
    }

    public void setMonstrinhoRaioBuscaPacman(int monstrinhoRaioBuscaPacman) {
        this.monstrinhoRaioBuscaPacman = monstrinhoRaioBuscaPacman;
    }        

    public int getFrequenciaEstadoMuitoFracoParaCasinha() {
        return frequenciaEstadoMuitoFracoParaCasinha;
    }

    public void setFrequenciaEstadoMuitoFracoParaCasinha(int frequenciaEstadoMuitoFracoParaCasinha) {
        this.frequenciaEstadoMuitoFracoParaCasinha = frequenciaEstadoMuitoFracoParaCasinha;
    }
    
}
