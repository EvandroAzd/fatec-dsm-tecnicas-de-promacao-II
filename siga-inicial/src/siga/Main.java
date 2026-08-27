package siga;

/**
 * Ponto de entrada do SIGA (código INICIAL).
 *
 * Esta classe demonstra os problemas do código atual, que servirão de
 * ponto de partida para a atividade prática da Aula 1.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Sistema de Gestão Acadêmica Simplificado ===");
        System.out.println("Versão INICIAL (a ser refatorada na Aula 1)\n");

        //Problema 01 e 02 corrigido: criei matricula antes de aluno existir e não podemos lançar medias negativas ou maior do que 10
        Matricula matricula1 = new Matricula(123128090, TipoDesconto.BOLSISTA);
        Aluno aluno1 = new Aluno("Evandro Azevedo", matricula1, 10);

        aluno1.setMedia(9);
        System.out.println(aluno1.toString());

        Professor professor1 = new Professor("Jonas", "1234567");
        System.out.println(professor1.toString());

    }
}
