package siga.dao;

import siga.repository.MatriculaRepository;
import siga.service.TipoDesconto;

/**
 * Código INICIAL da atividade — contém violações PROPOSITAIS do SOLID.
 *
 * PROBLEMA 2 — Violação do Princípio Aberto/Fechado (OCP):
 * o método calcularMensalidade usa um bloco de condicionais por TIPO de desconto
 * que cresce a cada novo tipo. Adicionar "convênio", "funcionário" ou qualquer
 * outro desconto exige MODIFICAR este método e testá-lo novamente por inteiro.
 *
 * PROBLEMA 3 — Violação do Princípio da Inversão de Dependência (DIP):
 * a classe depende DIRETAMENTE de uma implementação concreta de persistência
 * (GravadorMySQL), instanciada com "new" dentro dela. Deveria depender de uma
 * abstração (uma interface), permitindo trocar a implementação sem alterá-la.
 *
 * Tarefa (etapas 3 e 4 da ficha):
 *   - substituir o bloco condicional por polimorfismo (interface Desconto e uma
 *     classe por tipo de desconto), tornando o cálculo aberto para extensão;
 *   - inverter a dependência concreta de GravadorMySQL, fazendo a classe depender
 *     de uma interface (ex.: MatriculaRepositorio).
 */
public class MatriculaDAO {

    private AlunoDAO aluno;
    private double valorBase;
    private TipoDesconto tipoDesconto;   // "NENHUM", "BOLSISTA", "CONVENIO", "FUNCIONARIO"...
    private MatriculaRepository  matriculaRepository;

    public MatriculaDAO(AlunoDAO aluno, double valorBase,TipoDesconto tipoDesconto, MatriculaRepository matriculaRepository) {
        this.aluno = aluno;
        this.valorBase = valorBase;
        this.tipoDesconto = tipoDesconto;
        this.matriculaRepository = matriculaRepository;
    }

    public AlunoDAO getAluno() {
        return aluno;
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
