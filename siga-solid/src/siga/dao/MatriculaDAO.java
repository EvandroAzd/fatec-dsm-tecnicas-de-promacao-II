package siga.dao;

import siga.repository.MatriculaRepository;
import siga.service.TipoDesconto;

public class MatriculaDAO {

    private int numMatricula;
    private AlunoDAO aluno;
    private double valorBase;
    private TipoDesconto tipoDesconto;   // "NENHUM", "BOLSISTA", "CONVENIO", "FUNCIONARIO"...
    private MatriculaRepository matriculaRepository;

    public MatriculaDAO(int numMatricula,AlunoDAO aluno, double valorBase,TipoDesconto tipoDesconto, MatriculaRepository matriculaRepository) {
        this.numMatricula = numMatricula;
        this.aluno = aluno;
        this.valorBase = valorBase;
        this.tipoDesconto = tipoDesconto;
        this.matriculaRepository = matriculaRepository;
    }

    public AlunoDAO getAluno() {
        return aluno;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setAluno(AlunoDAO aluno) {
        this.aluno = aluno;
    }

    public TipoDesconto getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(TipoDesconto tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public void salvar(double mensalidade) {
        matriculaRepository.gravar("Matrícula de " + aluno.getNome() + " - mensalidade: " + mensalidade);
    }
}
