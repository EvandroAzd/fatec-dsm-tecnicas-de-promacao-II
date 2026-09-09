package siga;

public abstract class CriadorPainel {
    public abstract Painel criarPainel();

    public void montarPainel(){
        Painel painel = criarPainel();
        painel.montar();
    }
}
