package siga.dao;

public class AlunoDAO {
    private String nome;
    private String email;
    private double media;
    private boolean bolsista;

    public AlunoDAO(String nome, String email, double media, boolean bolsista) {
        this.nome = nome;
        this.email = email;
        this.media = media;
        this.bolsista = bolsista;
    }

    public String getNome()      { return nome; }
    public String getEmail()     { return email; }
    public double getMedia()     { return media; }
    public boolean isBolsista()  { return bolsista; }

}
