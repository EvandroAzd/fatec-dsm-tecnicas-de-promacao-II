package siga;

/**
 * Código INICIAL da disciplina.
 *
 * Esta classe é o ponto de partida da situação-problema da Aula 2 (SOLID).
 * O cálculo da mensalidade usa um bloco de condicionais que CRESCE a cada
 * novo tipo de desconto: a cada semestre, um novo desconto exige MODIFICAR
 * este método e testá-lo novamente por inteiro.
 *
 * Isso viola o princípio Aberto/Fechado (OCP): a classe deveria estar
 * fechada para modificação e aberta para extensão.
 *
 * Na atividade da Aula 2, este método será refatorado com o uso de uma
 * interface (por exemplo, Desconto) e polimorfismo.
 */
public class Matricula {

    public int numMatricula;
    public double valorBase;
    public TipoDesconto tipoDesconto;   // "BOLSISTA", "CONVENIO", "FUNCIONARIO"...

    public Matricula(int numMatricula, TipoDesconto tipoDesconto) {
        this.numMatricula = numMatricula;
        this.valorBase = 1500;
        this.tipoDesconto = tipoDesconto;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public double calcularMensalidade() {
        // A cada novo tipo de desconto, mais um ramo é acrescentado aqui.
        if (this.tipoDesconto == TipoDesconto.BOLSISTA) {
            return valorBase * 0.5;
        } else if (this.tipoDesconto == TipoDesconto.CONVENIO) {
            return valorBase * 0.8;
        } else if (this.tipoDesconto == TipoDesconto.FUNCIONARIO) {
            return valorBase * 0.7;
        } else {
            return valorBase; // sem desconto
        }
    }
}
