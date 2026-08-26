package siga;

/**
 * Código INICIAL da disciplina.
 *
 * Observe que Aluno e Professor repetem os atributos "nome" e "matricula"/"registro".
 * Na atividade da Aula 1, essa duplicação será eliminada com a criação de uma
 * superclasse comum (Pessoa), aplicando herança.
 */

//professor extende de Pessoa, evitando repetição de código e especializand o necessário
public class Professor extends Pessoa {

    // Atributos públicos: mesma violação de encapsulamento da classe Aluno.
    //foi retirado atributos em comum com Aluno e inserido na classe Pessoa além de tornar o modidicador de acesso private
    private String siape;

    public Professor(String nome, String siape) {
        this.nome = nome;
        this.ativo = true; //O objeto Professor começa sendo criado como ativo
        this.siape = siape;
    }

    public void  setSiape(String siape) {
        this.siape = siape;
    }

    public String getSiape() {
        return siape;
    }

    @Override
    public String toString() {
        return "Nome do Professor: " + this.nome + "\n" +
                "Siape: " + this.siape + "\n" +
                "Ativo: " + this.ativo + "\n";
    }
}
