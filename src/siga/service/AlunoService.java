package siga.service;

import siga.dao.AlunoDAO;

public class AlunoService {
    private final AlunoDAO aluno;

    public String getNome()      { return nome; }
    public String getMatricula() { return matricula; }
    public String getEmail()     { return email; }
    public double getMedia()     { return media; }
    public boolean isBolsista()  { return bolsista; }
}
